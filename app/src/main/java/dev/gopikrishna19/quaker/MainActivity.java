package dev.gopikrishna19.quaker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.ArrayList;

import dev.gopikrishna19.quaker.interfaces.OnLocationsLoaded;
import dev.gopikrishna19.quaker.types.Location;
import dev.gopikrishna19.quaker.types.LocationAdapter;
import dev.gopikrishna19.quaker.utils.Locations;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lvQuakes = (ListView) findViewById(R.id.lvQuakes);
        final ProgressBar pbLoader = (ProgressBar) findViewById(R.id.pbLoader);
        final LocationAdapter adapter = new LocationAdapter(this, new ArrayList<Location>());

        lvQuakes.setAdapter(adapter);

        Locations asyncLocations = new Locations();
        asyncLocations.setOnLocationsLoaded(new OnLocationsLoaded() {
            @Override
            public void onLoad(final ArrayList<Location> locations) {

                adapter.addAll(locations);
                pbLoader.setVisibility(View.GONE);

                lvQuakes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        Location location = locations.get(position);

                        Intent reportIntent = new Intent(Intent.ACTION_VIEW);
                        reportIntent.setData(Uri.parse(location.getReportUrl()));

                        startActivity(reportIntent);
                    }
                });
            }

            @Override
            public void onStart() {

                adapter.clear();
                pbLoader.setVisibility(View.VISIBLE);
            }
        });
        asyncLocations.execute();
    }
}
