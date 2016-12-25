package dev.gopikrishna19.quaker.utils;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
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
import java.util.ArrayList;

import dev.gopikrishna19.quaker.types.Location;

class LocationsLoader extends AsyncTaskLoader<ArrayList<Location>> {
    private static final String LOG_TAG = LocationsLoader.class.getSimpleName();
    private static final String USGS_URL = "http://earthquake.usgs.gov/fdsnws/event/1/query";

    private ArrayList<Location> locations = new ArrayList<>();
    private final QueryParams queryParams;
    private boolean isLoading = false;

    LocationsLoader(Context context, QueryParams queryParams) {

        super(context);

        this.queryParams = queryParams;
    }

    @Nullable
    private URL createUrl() {

        try {
            Uri.Builder uriBuilder = Uri.parse(USGS_URL).buildUpon();

            uriBuilder.appendQueryParameter("format", "geojson");
            uriBuilder.appendQueryParameter("orderby", "time");
            uriBuilder.appendQueryParameter("minmagnitude", String.valueOf(queryParams.getMinMagnitude()));
            uriBuilder.appendQueryParameter("limit", "10");

            return new URL(uriBuilder.toString());
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL", e);
        }

        return null;
    }

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

        URL url = createUrl();
        assert url != null;

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = urlConnection.getInputStream();
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

    @Override
    protected void onStartLoading() {

        if (!isLoading) {
            forceLoad();
        } else {
            deliverResult(locations);
        }
    }

    @Override
    public ArrayList<Location> loadInBackground() {

        try {
            isLoading = true;
            locations = extractLocations(getLocations());
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error while making Http Request", e);
        } finally {
            isLoading = false;
        }

        return locations;
    }
}
