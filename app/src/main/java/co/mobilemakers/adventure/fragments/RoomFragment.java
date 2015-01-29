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
public class RoomFragment extends Fragment {

    Button buttonDoorOne;
    Button buttonDoorTwo;

    public RoomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_room_layout,container,false);
        prepareButtons(rootView);
        return rootView;
    }

    private void prepareButtons(View rootView) {
        buttonDoorOne = (Button)rootView.findViewById(R.id.button_door_one);
        buttonDoorTwo = (Button)rootView.findViewById(R.id.button_door_two);
        final Random random = new Random();

        buttonDoorOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int  randomInt = random.nextInt(StartFragment.MAX_RANDOM);
                if(randomInt%3==0){
                    startFragment(new WinningFragment());
                }else{
                    startFragment(new LosingFragment());
                }

            }
        });

        buttonDoorTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                 int  randomInt = random.nextInt(StartFragment.MAX_RANDOM);
                if(randomInt%3==0){
                    startFragment(new LosingFragment());
                }else{
                    startFragment(new WinningFragment());
                }


            }
        });

    }


    private void startFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.startFrameLayout ,fragment).commit();
    }


}
