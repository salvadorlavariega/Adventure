package co.mobilemakers.adventure.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import co.mobilemakers.adventure.R;

/**
 * Created by root on 23/01/15.
 */
public class AlleyFragmentActivity extends Activity {

    Button butonGoLeft;
    Button butonContinue;
    Button butonGoRight;
    private final static int MAX_RANDOM=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alley);

        prepareButtons();
    }

    private void prepareButtons() {
        butonGoLeft = (Button)findViewById(R.id.button_go_left);
        butonContinue = (Button)findViewById(R.id.button_continue);
        butonGoRight = (Button)findViewById(R.id.button_go_right);
        final Random random = new Random();


        butonGoLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*int  randomInt = random.nextInt(MAX_RANDOM);
                if(randomInt%3==0){
                   startActivity( new Intent(AlleyFragmentActivity.this,WinningFragmentActivity.class));

                }else{
                    startActivity( new Intent(AlleyFragmentActivity.this,LossingFragmentActivity.class));
                }*/
                startActivity( new Intent(AlleyFragmentActivity.this,LossingFragmentActivity.class));
            }
        });


        butonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  randomInt = random.nextInt(MAX_RANDOM);
                if(randomInt%2==0){
                    startActivity( new Intent(AlleyFragmentActivity.this,RoomFragmentActivity.class));

                }else{
                    startActivity( new Intent(AlleyFragmentActivity.this,AlleyFragmentActivity.class));
                }

            }
        });


        butonGoRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* int  randomInt = random.nextInt(MAX_RANDOM);
                if(randomInt%3==0){
                    startActivity( new Intent(AlleyFragmentActivity.this,WinningFragmentActivity.class));

                }else{
                    startActivity( new Intent(AlleyFragmentActivity.this,LossingFragmentActivity.class));
                }*/

                startActivity( new Intent(AlleyFragmentActivity.this,WinningFragmentActivity.class));

            }
        });
    }
}
