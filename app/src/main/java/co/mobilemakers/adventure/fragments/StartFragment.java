package co.mobilemakers.adventure.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

import co.mobilemakers.adventure.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {


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
        return rootView;
    }

    private void prepareButtonStart(View rootView) {
        buttonStart = (Button)rootView.findViewById(R.id.button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt =0;

                Random randomGenerator = new Random();
                randomInt = randomGenerator.nextInt(MAX_RANDOM);


                if((randomInt%2)==0)
                    startFragment(new AlleyFragment());
                else
                    startFragment(new RoomFragment());

            }
        });
    }


    private void startFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.startFrameLayout ,fragment).commit();
    }


}
