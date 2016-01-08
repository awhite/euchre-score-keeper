package io.ustube.euchrescorekeeper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.Gson;

public class SetupActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    Button submit;
    EditText p1, p2, p3, p4;
    TextView scoreText;
    SeekBar scoreSeekBar;

    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        getSupportActionBar().setSubtitle("Setup");
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        submit = (Button) findViewById(R.id.submit);
        scoreText = (TextView) findViewById(R.id.scoreView);
        scoreSeekBar = (SeekBar) findViewById(R.id.scoreSeekBar);
        p1 = (EditText) findViewById(R.id.p1);
        p2 = (EditText) findViewById(R.id.p2);
        p3 = (EditText) findViewById(R.id.p3);
        p4 = (EditText) findViewById(R.id.p4);

        submit.setOnClickListener(this);
        scoreSeekBar.setOnSeekBarChangeListener(this);
        scoreSeekBar.setProgress(preferences.getInt("pointsToWin", -1) == -1 ? 9 : preferences.getInt("pointsToWin", -1));
        p1.setText(preferences.getString("player1", "").equals("") ? "" : preferences.getString("player1", ""));
        p2.setText(preferences.getString("player2", "").equals("") ? "" : preferences.getString("player2", ""));
        p3.setText(preferences.getString("player3", "").equals("") ? "" : preferences.getString("player3", ""));
        p4.setText(preferences.getString("player4", "").equals("") ? "" : preferences.getString("player4", ""));
        scoreText.setText(String.valueOf(scoreSeekBar.getProgress() + 1));

    }

    @Override
    public void onClick(View v) {
        int scoreNum = scoreSeekBar.getProgress() + 1;
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        editor.putString("gameExists", "creating")
                .putString("player1", p1.getText().toString())
                .putString("player2", p2.getText().toString())
                .putString("player3", p3.getText().toString())
                .putString("player4", p4.getText().toString())
                .putInt("pointsToWin", scoreSeekBar.getProgress()).apply();
        startActivity(mainActivityIntent);
        finish();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        scoreText.setText(String.valueOf(progress + 1));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
