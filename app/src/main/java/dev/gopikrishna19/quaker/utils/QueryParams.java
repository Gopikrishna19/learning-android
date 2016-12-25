package dev.gopikrishna19.quaker.utils;

import android.content.Context;
import android.content.SharedPreferences;

import dev.gopikrishna19.quaker.R;

public class QueryParams {
    private float minMagnitude;
    private String orderBy;
    private int limit;

    public QueryParams(Context context, SharedPreferences sharedPreferences) {

        setLimit(context, sharedPreferences);
        setMinMagnitude(context, sharedPreferences);
        setOrderBy(context, sharedPreferences);
    }

    private void setLimit(Context context, SharedPreferences sharedPreferences) {

        String key = context.getString(R.string.limit_key);
        String defaultValue = context.getString(R.string.limit_default);

        limit = Integer.valueOf(sharedPreferences.getString(key, defaultValue));
    }

    private void setMinMagnitude(Context context, SharedPreferences sharedPreferences) {

        String key = context.getString(R.string.min_magnitude_key);
        String defaultValue = context.getString(R.string.min_magnitude_default);

        minMagnitude = Float.valueOf(sharedPreferences.getString(key, defaultValue));
    }

    private void setOrderBy(Context context, SharedPreferences sharedPreferences) {

        String key = context.getString(R.string.order_by_key);
        String defaultValue = context.getString(R.string.order_by_default);

        orderBy = sharedPreferences.getString(key, defaultValue);
    }

    int getLimit() {

        return limit;
    }

    float getMinMagnitude() {

        return minMagnitude;
    }

    String getOrderBy() {

        return orderBy;
    }
}
