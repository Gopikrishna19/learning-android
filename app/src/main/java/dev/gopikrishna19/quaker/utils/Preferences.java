package dev.gopikrishna19.quaker.utils;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
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
        Preference orderBy = findPreference(getString(R.string.order_by_key));

        bindPreferenceSummary(minMagnitude);
        bindPreferenceSummary(orderBy);
    }

    private void bindPreferenceSummary(Preference preference) {

        preference.setOnPreferenceChangeListener(this);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
        String summary = preferences.getString(preference.getKey(), getString(R.string.min_magnitude_default));

        onPreferenceChange(preference, summary);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value) {

        String summary = value.toString();

        if (preference instanceof ListPreference) {
            ListPreference listPreference = (ListPreference) preference;
            int prefIndex = listPreference.findIndexOfValue(summary);

            if (prefIndex >= 0) {
                CharSequence[] labels = listPreference.getEntries();
                summary = String.valueOf(labels[prefIndex]);
            }
        }

        preference.setSummary(summary);

        return true;
    }
}
