package dev.gopikrishna19.quaker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

import dev.gopikrishna19.quaker.interfaces.ILocationsStatus;
import dev.gopikrishna19.quaker.types.Location;
import dev.gopikrishna19.quaker.types.LocationAdapter;
import dev.gopikrishna19.quaker.utils.LocationsLoaderManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lvQuakes = (ListView) findViewById(R.id.lvQuakes);
        final ProgressBar pbLoader = (ProgressBar) findViewById(R.id.pbLoader);
        final TextView txtNoQuakesFound = (TextView) findViewById(R.id.txtNoQuakesFound);
        final LocationAdapter adapter = new LocationAdapter(this, new ArrayList<Location>());

        lvQuakes.setAdapter(adapter);
        lvQuakes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Location location = adapter.getItem(position);
                assert location != null;

                Intent reportIntent = new Intent(Intent.ACTION_VIEW);
                reportIntent.setData(Uri.parse(location.getReportUrl()));

                startActivity(reportIntent);
            }
        });

        LocationsLoaderManager loaderManager = new LocationsLoaderManager(this, getSupportLoaderManager());
        loaderManager.setILocationsStatus(new ILocationsStatus() {
            @Override
            public void onEmpty() {

                txtNoQuakesFound.setVisibility(View.VISIBLE);
                pbLoader.setVisibility(View.GONE);
            }

            @Override
            public void onFinish(ArrayList<Location> locations) {

                adapter.addAll(locations);
                pbLoader.setVisibility(View.GONE);
                txtNoQuakesFound.setVisibility(View.GONE);
            }

            @Override
            public void onStart() {

                adapter.clear();
                txtNoQuakesFound.setVisibility(View.GONE);
                pbLoader.setVisibility(View.VISIBLE);
            }
        });
        loaderManager.load();
    }
}
