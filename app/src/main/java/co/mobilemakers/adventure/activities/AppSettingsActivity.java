package co.mobilemakers.adventure.activities;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import co.mobilemakers.adventure.R;

/**
 * Created by salvador on 01/02/15.
 */
public class AppSettingsActivity extends  Activity {
    public static class AppSettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        getFragmentManager().beginTransaction().
                add(R.id.settings, new AppSettingsFragment()).
                commit();
    }
}
