package dev.gopikrishna19.quaker.utils;

import android.content.Context;
import android.content.SharedPreferences;

import dev.gopikrishna19.quaker.R;

public class QueryParams {
    private float minMagnitude;

    public QueryParams(Context context, SharedPreferences sharedPreferences) {

        setMagnitude(context, sharedPreferences);
    }

    private void setMagnitude(Context context, SharedPreferences sharedPreferences) {

        String key = context.getString(R.string.min_magnitude_key);
        String defaultValue = context.getString(R.string.min_magnitude_default);

        minMagnitude = Float.valueOf(sharedPreferences.getString(key, defaultValue));
    }

    public float getMinMagnitude() {

        return minMagnitude;
    }
}
