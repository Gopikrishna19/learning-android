package dev.gopikrishna19.quaker.interfaces;

import java.util.ArrayList;

import dev.gopikrishna19.quaker.types.Location;

public interface ILocationsStatus {

    void onFinish(ArrayList<Location> locations);

    void onStart();
}
