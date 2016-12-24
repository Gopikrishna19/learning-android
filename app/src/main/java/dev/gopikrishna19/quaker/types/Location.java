package dev.gopikrishna19.quaker.types;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Location {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("h:mm a", Locale.getDefault());
    private static final String LOCATION_SEPARATOR = " of ";

    private String name;
    private String relativeName;

    private double magnitude;
    private long dateTime;

    public Location(String name, double magnitude, long dateTime) {

        this.magnitude = magnitude;
        this.dateTime = dateTime * 1000L;
        setName(name);
    }

    private void setName(String name) {

        if (name.contains(LOCATION_SEPARATOR)) {
            String[] parts = name.split(LOCATION_SEPARATOR);
            this.relativeName = parts[0] + LOCATION_SEPARATOR;
            this.name = parts[1];
        } else {
            this.relativeName = "Near the ";
            this.name = name;
        }
    }

    String getDateString() {

        return DATE_FORMAT.format(new Date(dateTime));
    }

    String getTimeString() {

        return TIME_FORMAT.format(new Date(dateTime));
    }

    String getMagnitude() {

        return DECIMAL_FORMAT.format(magnitude);
    }

    String getName() {

        return name;
    }

    String getRelativeName() {

        return relativeName;
    }
}
