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
public class AlleyFragment extends Fragment {


    Button butonGoLeft;
    Button butonContinue;
    Button butonGoRight;

    public AlleyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_alley_layout, container, false);
        prepareButtons(rootView);
        return rootView;
    }

    private void prepareButtons( final View rootView) {
        butonGoLeft = (Button)rootView.findViewById(R.id.button_go_left);
        butonContinue = (Button)rootView.findViewById(R.id.button_continue);
        butonGoRight = (Button)rootView.findViewById(R.id.button_go_right);
        final Random random = new Random();


        butonGoLeft.setOnClickListener(new View.OnClickListener() {
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


        butonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  randomInt = random.nextInt(StartFragment.MAX_RANDOM);
                if(randomInt%2==0){
                    startFragment(new RoomFragment());
                }else{
                    startFragment(new AlleyFragment());
                }

            }
        });


        butonGoRight.setOnClickListener(new View.OnClickListener() {
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
    }

    private void startFragment(Fragment fragment){
        getFragmentManager().beginTransaction().replace(R.id.startFrameLayout ,fragment).commit();
    }


}
