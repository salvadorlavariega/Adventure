package co.mobilemakers.adventure.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import co.mobilemakers.adventure.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LosingFragment extends Fragment {


    public LosingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_losing_layout, container, false);
    }


}
