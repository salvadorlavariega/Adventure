package co.mobilemakers.adventure.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import co.mobilemakers.adventure.R;

/**
 * Created by salvador on 24/01/15.
 */
public class WinningFragmentActivity extends Activity {

    Button  restartButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning);

        restartButton = (Button)findViewById(R.id.button_restart);
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(WinningFragmentActivity.this,MainActivity.class));
            }
        });
    }
}
