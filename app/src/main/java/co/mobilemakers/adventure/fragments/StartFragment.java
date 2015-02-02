package co.mobilemakers.adventure.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import co.mobilemakers.adventure.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {

    private final static String USERNAME_PREFERENCE = "username_preference";



    public final static int MAX_RANDOM_EASY=10;
    public final static int MAX_RANDOM_HARD=100;
    public final static int MAX_RANDOM_MEDIUM=50;
    public final static int MAX_RANDOM=10;
    Button buttonStart;
    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_start_layout,container,false);
        prepareButtonStart(rootView);
        prepareWelcomeMsg(rootView);
        return rootView;
    }

    private void prepareWelcomeMsg(View rootView) {
        TextView textViewStartScreen = (TextView)rootView.findViewById(R.id.text_view_start_screen);
        textViewStartScreen.setText("Hello "+getUsername()+" Start an Adventure");
    }

    private void prepareButtonStart(View rootView) {
        buttonStart = (Button)rootView.findViewById(R.id.button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt =0;

                Random randomGenerator = new Random();
                randomInt = randomGenerator.nextInt(MAX_RANDOM);

                //if random is even
                if((randomInt%2)==0)
                    startFragment(new AlleyFragment());
                else // if is odd
                    startFragment(new RoomFragment());

            }
        });
    }


    private void startFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.startFrameLayout ,fragment).commit();
    }

    private String getUsername() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        return sharedPreferences.getString(USERNAME_PREFERENCE, getString(R.string.default_username));
    }






}
