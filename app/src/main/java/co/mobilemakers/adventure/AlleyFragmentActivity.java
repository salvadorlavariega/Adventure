package co.mobilemakers.adventure;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by root on 23/01/15.
 */
public class AlleyFragmentActivity extends ActionBarActivity {

    Button butonGoLeft;
    Button butonContinue;
    Button butonGoRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_alley_layout);

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
                int  randomInt = random.nextInt(100);
                if(randomInt%2==0){

                }else{

                }
            }
        });


        butonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  randomInt = random.nextInt(100);
                if(randomInt%2==0){

                }else{

                }

            }
        });


        butonGoRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  randomInt = random.nextInt(100);
                if(randomInt%2==0){

                }else{

                }

            }
        });
    }
}
