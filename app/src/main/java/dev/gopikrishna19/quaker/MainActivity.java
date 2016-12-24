package dev.gopikrishna19.quaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import dev.gopikrishna19.quaker.types.LocationAdapter;
import dev.gopikrishna19.quaker.utils.Locations;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView earthquakeListView = (ListView) findViewById(R.id.lvMain);

        LocationAdapter adapter = new LocationAdapter(this, Locations.getLocations());

        earthquakeListView.setAdapter(adapter);
    }
}
