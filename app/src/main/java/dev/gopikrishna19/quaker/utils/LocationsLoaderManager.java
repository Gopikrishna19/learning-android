package dev.gopikrishna19.quaker.utils;

import android.content.Context;
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
            LoaderManager loaderManager
    ) {

        this.context = context;
        this.loaderManager = loaderManager;
    }

    public void load() {

        this.loaderManager.initLoader(0, null, this);
    }

    @Override
    public Loader<ArrayList<Location>> onCreateLoader(int id, Bundle args) {

        if (iLocationsStatus != null) {
            iLocationsStatus.onStart();
        }

        return new LocationsLoader(context);
    }

    @Override
    public void onLoadFinished(Loader<ArrayList<Location>> loader, ArrayList<Location> locations) {

        if (iLocationsStatus != null) {
            iLocationsStatus.onFinish(locations);
        }
    }

    @Override
    public void onLoaderReset(Loader<ArrayList<Location>> loader) {

        if (iLocationsStatus != null) {
            iLocationsStatus.onFinish(new ArrayList<Location>());
        }
    }

    public void setILocationsStatus(ILocationsStatus iLocationsStatus) {

        this.iLocationsStatus = iLocationsStatus;
    }
}
