package dev.gopikrishna19.quaker.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import java.util.ArrayList;

import dev.gopikrishna19.quaker.interfaces.ILocationsStatus;
import dev.gopikrishna19.quaker.types.Location;

public class LocationsLoaderManager implements LoaderManager.LoaderCallbacks<ArrayList<Location>> {

    private Context context;
    private ILocationsStatus iLocationsStatus;
    private LoaderManager loaderManager;

    public LocationsLoaderManager(
            Context context,
            LoaderManager loaderManager,
            ILocationsStatus iLocationsStatus
    ) {

        this.context = context;
        this.loaderManager = loaderManager;
        this.iLocationsStatus = iLocationsStatus;
    }

    public void load() {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            this.loaderManager.initLoader(0, null, this);
        } else {
            iLocationsStatus.onNoConnectivity();
        }
    }

    @Override
    public Loader<ArrayList<Location>> onCreateLoader(int id, Bundle args) {

        iLocationsStatus.onStart();

        return new LocationsLoader(context);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Location>> loader, ArrayList<Location> locations) {

        if (locations.size() == 0) {
            iLocationsStatus.onEmpty();
        } else {
            iLocationsStatus.onFinish(locations);
        }
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Location>> loader) {

        iLocationsStatus.onFinish(new ArrayList<Location>());
    }
}
