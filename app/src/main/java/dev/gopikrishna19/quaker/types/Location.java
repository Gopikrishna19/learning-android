package dev.gopikrishna19.quaker.types;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Location {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.0");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("h:mm a", Locale.getDefault());

    private long dateTime;
    private double magnitude;
    private String name;
    private String reportUrl;

    public Location(String name, double magnitude, long dateTime, String reportUrl) {

        this.dateTime = dateTime;
        this.magnitude = magnitude;
        this.name = name;
        this.reportUrl = reportUrl;
    }

    String getDateString() {

        return DATE_FORMAT.format(new Date(dateTime));
    }

    String getTimeString() {

        return TIME_FORMAT.format(new Date(dateTime));
    }

    double getMagnitude() {

        return magnitude;
    }

    String getMagnitudeString() {

        return DECIMAL_FORMAT.format(magnitude);
    }

    String getName() {

        return name;
    }

    public String getReportUrl() {

        return reportUrl;
    }
}
