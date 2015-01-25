package co.mobilemakers.adventure.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.apache.http.impl.conn.LoggingSessionInputBuffer;

import co.mobilemakers.adventure.R;


/**
 * Created by salvador on 24/01/15.
 */
public class LossingFragmentActivity extends Activity {

    Button restartButton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing);

        restartButton2 = (Button)findViewById(R.id.button_restart_2);
        restartButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LossingFragmentActivity.this, MainActivity.class));
            }
        });
    }

}
