package co.mobilemakers.adventure.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
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
public class LosingFragment extends Fragment {


    Button restartButton2;

    public LosingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_losing_layout, container, false);
        prepareButton(rootView);
        return rootView;
    }


    private void prepareButton(View rootView) {
        restartButton2 = (Button)rootView.findViewById(R.id.button_restart_2);
        restartButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(new StartFragment());
            }
        });
    }

    private void startFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.startFrameLayout ,fragment).commit();
    }

}
