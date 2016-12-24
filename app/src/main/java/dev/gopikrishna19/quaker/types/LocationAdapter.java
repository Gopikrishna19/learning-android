package dev.gopikrishna19.quaker.types;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
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

    private int getMagnitudeColor(double magnitude) {

        int magnitudeColor = R.color.magnitude10plus;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColor = R.color.magnitude1;
                break;
            case 2:
                magnitudeColor = R.color.magnitude2;
                break;
            case 3:
                magnitudeColor = R.color.magnitude3;
                break;
            case 4:
                magnitudeColor = R.color.magnitude4;
                break;
            case 5:
                magnitudeColor = R.color.magnitude5;
                break;
            case 6:
                magnitudeColor = R.color.magnitude6;
                break;
            case 7:
                magnitudeColor = R.color.magnitude7;
                break;
            case 8:
                magnitudeColor = R.color.magnitude8;
                break;
            case 9:
                magnitudeColor = R.color.magnitude9;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColor);
    }

    private String getName(String name) {

        if (name.contains(LOCATION_SEPARATOR)) {
            return name.split(LOCATION_SEPARATOR)[1];
        }

        return name;
    }

    private String getRelativeName(String name) {

        if (name.contains(LOCATION_SEPARATOR)) {
            return name.split(LOCATION_SEPARATOR)[0] + LOCATION_SEPARATOR;
        }

        return getContext().getString(R.string.near_the);
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

        TextView txtMagnitude = (TextView) listItem.findViewById(R.id.txtMagnitude);
        txtMagnitude.setText(location.getMagnitudeString());

        GradientDrawable drawableMagnitude = (GradientDrawable) txtMagnitude.getBackground();
        drawableMagnitude.setColor(getMagnitudeColor(location.getMagnitude()));

        ((TextView) listItem.findViewById(R.id.txtDate)).setText(location.getDateString());
        ((TextView) listItem.findViewById(R.id.txtLocation)).setText(getName(locationName));
        ((TextView) listItem.findViewById(R.id.txtRelativeLocation)).setText(getRelativeName(locationName));
        ((TextView) listItem.findViewById(R.id.txtTime)).setText(location.getTimeString());

        return listItem;
    }
}
