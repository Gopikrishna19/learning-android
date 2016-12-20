package dev.gopikrishna19.quaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> locations = new ArrayList<>();
        locations.add("San Francisco");
        locations.add("London");
        locations.add("Tokyo");
        locations.add("Mexico City");
        locations.add("Moscow");
        locations.add("Rio de Janeiro");
        locations.add("Paris");

        ListView earthquakeListView = (ListView) findViewById(R.id.lvMain);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, locations);

        earthquakeListView.setAdapter(adapter);
    }
}
