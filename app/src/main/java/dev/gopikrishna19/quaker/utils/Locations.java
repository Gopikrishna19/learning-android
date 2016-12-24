package dev.gopikrishna19.quaker.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import dev.gopikrishna19.quaker.interfaces.OnLocationsLoaded;
import dev.gopikrishna19.quaker.types.Location;

public class Locations extends AsyncTask<URL, Void, ArrayList<Location>> {
    private static final String LOG_TAG = Locations.class.getSimpleName();
    private static final String USGS_URL = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson";

    private HttpURLConnection urlConnection;
    private InputStream inputStream;
    private OnLocationsLoaded onLocationsLoaded;
    private URL url;

    public Locations() {

        url = createUrl();
    }

    @Override
    protected ArrayList<Location> doInBackground(URL... urls) {

        try {
            return extractLocations(getLocations());
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error while making Http Request", e);
        }

        return new ArrayList<>();
    }

    @Override
    protected void onPostExecute(ArrayList<Location> locations) {

        if (urlConnection != null) {
            urlConnection.disconnect();
        }

        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.e(LOG_TAG, "Error while closing stream", e);
            }
        }

        if (onLocationsLoaded != null) {
            onLocationsLoaded.onLoad(locations);
        }
    }

    @Nullable
    private URL createUrl() {

        try {
            String startTime = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
            return new URL(USGS_URL + "&starttime=" + startTime);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL", e);
            return null;
        }
    }

    @NonNull
    private ArrayList<Location> extractLocations(String response) {

        ArrayList<Location> locations = new ArrayList<>();

        try {

            JSONObject root = new JSONObject(response);
            JSONArray features = root.getJSONArray("features");

            for (int i = 0; i < features.length(); ++i) {
                JSONObject feature = features.getJSONObject(i);
                JSONObject properties = feature.getJSONObject("properties");

                double magnitude = properties.getDouble("mag");
                String name = properties.getString("place");
                long time = properties.getLong("time");
                String url = properties.getString("url");

                locations.add(new Location(name, magnitude, time, url));
            }

        } catch (JSONException e) {
            Log.e(LOG_TAG, "Problem parsing the JSON results", e);
        }

        return locations;
    }

    @NonNull
    private String getLocations() throws IOException {

        assert url != null;

        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(10000);
        urlConnection.setConnectTimeout(15000);
        urlConnection.connect();

        if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            inputStream = urlConnection.getInputStream();
            return readFromStream(inputStream);
        }

        throw new IOException("Disconnected: " + urlConnection.getResponseCode());
    }

    @NonNull
    private String readFromStream(InputStream inputStream) throws IOException {

        StringBuilder output = new StringBuilder();

        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("utf-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();
    }

    public void setOnLocationsLoaded(OnLocationsLoaded onLocationsLoaded) {

        this.onLocationsLoaded = onLocationsLoaded;
    }
}
