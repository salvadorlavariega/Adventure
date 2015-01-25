package co.mobilemakers.adventure.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import java.util.Random;

import co.mobilemakers.adventure.R;

/**
 * Created by root on 23/01/15.
 */
public class RoomFragmentActivity extends Activity {

    Button buttonDoorOne;
    Button buttonDoorTwo;
    private final static int MAX_RANDOM=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        prepareButtons();

    }

    private void prepareButtons() {
        buttonDoorOne = (Button)findViewById(R.id.button_door_one);
        buttonDoorTwo = (Button)findViewById(R.id.button_door_two);
        final Random random = new Random();

        buttonDoorOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int  randomInt = random.nextInt(MAX_RANDOM);
                if(randomInt%3==0){
                    startActivity( new Intent(RoomFragmentActivity.this,WinningFragmentActivity.class));
                }else{
                    startActivity( new Intent(RoomFragmentActivity.this,LossingFragmentActivity.class));
                }*/
                startActivity( new Intent(RoomFragmentActivity.this,WinningFragmentActivity.class));
            }
        });

        buttonDoorTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*int  randomInt = random.nextInt(MAX_RANDOM);
                if(randomInt%3==0){
                    startActivity( new Intent(RoomFragmentActivity.this,LossingFragmentActivity.class));
                }else{
                    startActivity( new Intent(RoomFragmentActivity.this,WinningFragmentActivity.class));
                }*/

                startActivity( new Intent(RoomFragmentActivity.this,LossingFragmentActivity.class));
            }
        });

    }
}
