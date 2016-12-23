package dev.gopikrishna19.quaker.types;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Location {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
    private String name;
    private double magnitude;
    private long dateTime;

    public Location(String name, double magnitude, long dateTime) {

        this.name = name;
        this.magnitude = magnitude;
        this.dateTime = dateTime;
    }

    String getDateString() {

        return Location.dateFormat.format(new Date(dateTime * 1000L));
    }

    double getMagnitude() {

        return magnitude;
    }

    String getName() {

        return name;
    }
}
