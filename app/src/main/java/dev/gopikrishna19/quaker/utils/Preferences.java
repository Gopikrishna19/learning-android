package dev.gopikrishna19.quaker.utils;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import dev.gopikrishna19.quaker.R;

public class Preferences extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_main);
    }
}
