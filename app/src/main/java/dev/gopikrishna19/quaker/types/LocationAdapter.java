package dev.gopikrishna19.quaker.types;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import dev.gopikrishna19.quaker.R;

public class LocationAdapter extends ArrayAdapter<Location> {
    private static final String LOCATION_SEPARATOR = " of ";

    public LocationAdapter(Context context, ArrayList<Location> locations) {

        super(context, 0, locations);
    }

    private String getRelativeName(String name) {

        if (name.contains(LOCATION_SEPARATOR)) {
            return name.split(LOCATION_SEPARATOR)[0] + LOCATION_SEPARATOR;
        }

        return getContext().getString(R.string.near_the);
    }

    private String getName(String name) {

        if (name.contains(LOCATION_SEPARATOR)) {
            return name.split(LOCATION_SEPARATOR)[1];
        }

        return name;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;

        if (convertView == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item_location, parent, false);
        }

        Location location = getItem(position);
        assert location != null;

        String locationName = location.getName();

        ((TextView) listItem.findViewById(R.id.txtDate)).setText(location.getDateString());
        ((TextView) listItem.findViewById(R.id.txtLocation)).setText(getName(locationName));
        ((TextView) listItem.findViewById(R.id.txtMagnitude)).setText(location.getMagnitude());
        ((TextView) listItem.findViewById(R.id.txtRelativeLocation)).setText(getRelativeName(locationName));
        ((TextView) listItem.findViewById(R.id.txtTime)).setText(location.getTimeString());

        return listItem;
    }
}
