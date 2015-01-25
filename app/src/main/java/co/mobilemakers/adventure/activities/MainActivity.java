package co.mobilemakers.adventure.activities;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.util.Random;

import co.mobilemakers.adventure.R;


public class MainActivity extends ActionBarActivity {

    private final static int MAX_RANDOM=10;
    Button buttonStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareButtonStart();
    }

    private void prepareButtonStart() {
        buttonStart = (Button)findViewById(R.id.button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomInt =0;
                Intent intent;
                Random randomGenerator = new Random();

                    randomInt = randomGenerator.nextInt(MAX_RANDOM);

                if((randomInt%2)==0)
                   intent = new Intent(MainActivity.this,AlleyFragmentActivity.class);
                else
                    intent = new Intent(MainActivity.this,RoomFragmentActivity.class);
                startActivity(intent);
             }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
