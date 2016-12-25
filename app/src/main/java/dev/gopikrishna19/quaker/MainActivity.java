package dev.gopikrishna19.quaker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
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
        final TextView txtQuakesStatus = (TextView) findViewById(R.id.txtQuakesStatus);
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

        LocationsLoaderManager loaderManager = new LocationsLoaderManager(
                this,
                getSupportLoaderManager(),
                new ILocationsStatus() {
                    @Override
                    public void onEmpty() {

                        txtQuakesStatus.setText(getString(R.string.no_quakes_found));
                        txtQuakesStatus.setVisibility(View.VISIBLE);
                        pbLoader.setVisibility(View.GONE);
                    }

                    @Override
                    public void onFinish(ArrayList<Location> locations) {

                        adapter.addAll(locations);
                        pbLoader.setVisibility(View.GONE);
                        txtQuakesStatus.setVisibility(View.GONE);
                    }

                    @Override
                    public void onNoConnectivity() {

                        txtQuakesStatus.setText(getString(R.string.no_internet_connection));
                        txtQuakesStatus.setVisibility(View.VISIBLE);
                        pbLoader.setVisibility(View.GONE);
                    }

                    @Override
                    public void onStart() {

                        adapter.clear();
                        txtQuakesStatus.setVisibility(View.GONE);
                        pbLoader.setVisibility(View.VISIBLE);
                    }
                }
        );
        loaderManager.load();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent settingsIntent = new Intent(this, SettingsActivity.class);
                startActivity(settingsIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
