package co.mobilemakers.adventure.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.mobilemakers.adventure.R;
import co.mobilemakers.adventure.activities.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class WinningFragment extends Fragment {


    private final static String WINNER_MSG_PREFERENCE = "win_msg_preference";
    Button restartButton;
    public WinningFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_winning_layout, container, false);
        setPersonalizedMessage(rootView);
        prepareButton(rootView);
        return rootView;

    }

    private void prepareButton(View rootView) {
        restartButton = (Button)rootView.findViewById(R.id.button_restart);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new StartFragment());
            }
        });
    }

    private void startFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.startFrameLayout ,fragment).commit();
    }


    private void setPersonalizedMessage(View rootView) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String message= sharedPreferences.getString(WINNER_MSG_PREFERENCE, getString(R.string.text_view_win));
        Log.i(RoomFragment.class.getSimpleName(), "^^^ LOSER MSG LEVEL:" + message);

        ((TextView)rootView.findViewById(R.id.text_view_msg_winner)).setText(message);

    }

}
