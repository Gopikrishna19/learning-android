package dev.gopikrishna19.quaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import dev.gopikrishna19.quaker.types.Location;
import dev.gopikrishna19.quaker.types.LocationAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Location> locations = new ArrayList<>(
                Arrays.asList(
                        new Location("San Francisco", 4.5, 1482534399),
                        new Location("London", 4.5, 1482534399),
                        new Location("Tokyo", 4.5, 1482534399),
                        new Location("Mexico City", 4.5, 1482534399),
                        new Location("Moscow", 4.5, 1482534399),
                        new Location("Rio de Janeiro", 4.5, 1482534399),
                        new Location("Paris", 4.5, 1482534399)
                )
        );

        ListView earthquakeListView = (ListView) findViewById(R.id.lvMain);

        LocationAdapter adapter = new LocationAdapter(this, locations);

        earthquakeListView.setAdapter(adapter);
    }
}
