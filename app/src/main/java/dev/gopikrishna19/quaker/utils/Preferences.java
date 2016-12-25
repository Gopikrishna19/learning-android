package dev.gopikrishna19.quaker.utils;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import dev.gopikrishna19.quaker.R;

public class Preferences extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_main);

        Preference minMagnitude = findPreference(getString(R.string.min_magnitude_key));

        bindPreferenceSummary(minMagnitude);
    }

    private void bindPreferenceSummary(Preference preference) {

        preference.setOnPreferenceChangeListener(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
        String summary = preferences.getString(preference.getKey(), getString(R.string.min_magnitude_default));
        preference.setSummary(summary);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {

        preference.setSummary(value.toString());

        return true;
    }
}
