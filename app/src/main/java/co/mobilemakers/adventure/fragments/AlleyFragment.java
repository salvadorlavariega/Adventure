package co.mobilemakers.adventure.fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.util.Log;
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

    private final static String DIFFICULTY_LEVEL = "difficulty_level";

    Button butonGoLeft;
    Button butonContinue;
    Button butonGoRight;
    private int difficulty_options;

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



        butonGoLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isUserWinner()){
                    startFragment(new WinningFragment());
                }else{
                    startFragment(new LosingFragment());
                }
            }
        });


        butonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  randomInt = new Random().nextInt(StartFragment.MAX_RANDOM);
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

                if(isUserWinner()){
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

    private String getDifficultyLevel() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String difficultyLevel= sharedPreferences.getString(DIFFICULTY_LEVEL, getString(R.string.default_level));
        Log.i(AlleyFragment.class.getSimpleName(),"^^^ DIFFICULTY LEVEL:"+difficultyLevel );
        return difficultyLevel;
    }

    public boolean isUserWinner(){
        boolean isWinner = false;
        final Random random = new Random();
        int  randomInt=0;

        switch (getDifficultyLevel()){
            case "Hard":
                randomInt = random.nextInt(StartFragment.MAX_RANDOM_HARD);
                if(randomInt==4 || randomInt == 88 || randomInt == 33){
                    isWinner=true;
                }
                break;
            case "Medium":
                randomInt = random.nextInt(StartFragment.MAX_RANDOM_MEDIUM);
                if(randomInt==10 || randomInt == 20 || randomInt == 33 || randomInt == 40 || randomInt == 49){
                    isWinner=true;
                }
                break;
            case "Easy":
                randomInt = random.nextInt(StartFragment.MAX_RANDOM_EASY);
                if(randomInt%3==0){
                    isWinner=true;
                }
                break;
            default: return false;
        }

        return isWinner;
    }


}
