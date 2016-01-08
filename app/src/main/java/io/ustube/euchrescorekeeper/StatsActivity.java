package io.ustube.euchrescorekeeper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

public class StatsActivity extends AppCompatActivity {

    TextView p1t1g, p2t1g, p4t1g, p1t2g, p2t2g, p4t2g;
    TextView p1t1m, p2t1m, p4t1m, p1t2m, p2t2m, p4t2m;
    Team team1, team2;
    TextView team1Players, team2Players, team1Wins, team2Wins;
    Gson gson = new Gson();
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
        getSupportActionBar().setSubtitle("Stats");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        team1 = gson.fromJson(preferences.getString("team1", ""), Team.class);
        team2 = gson.fromJson(preferences.getString("team2", ""), Team.class);
        team1Players = (TextView) findViewById(R.id.team_1_section);
        team2Players = (TextView) findViewById(R.id.team_2_section);
        team1Wins = (TextView) findViewById(R.id.team_1_wins);
        team2Wins = (TextView) findViewById(R.id.team_2_wins);

        team1Players.setText(String.format(getString(R.string.player_heading), team1.getPlayer1(), team1.getPlayer2()));
        team2Players.setText(String.format(getString(R.string.player_heading), team2.getPlayer1(), team2.getPlayer2()));
        team1Wins.setText(String.format(getString(R.string.team_wins), team1.getWins()));
        team2Wins.setText(String.format(getString(R.string.team_wins), team2.getWins()));

        p1t1g = (TextView) findViewById(R.id.one_pt_game_1);
        p2t1g = (TextView) findViewById(R.id.two_pt_game_1);
        p4t1g = (TextView) findViewById(R.id.four_pt_game_1);
        p1t2g = (TextView) findViewById(R.id.one_pt_game_2);
        p2t2g = (TextView) findViewById(R.id.two_pt_game_2);
        p4t2g = (TextView) findViewById(R.id.four_pt_game_2);
        p1t1m = (TextView) findViewById(R.id.one_pt_match_1);
        p2t1m = (TextView) findViewById(R.id.two_pt_match_1);
        p4t1m = (TextView) findViewById(R.id.four_pt_match_1);
        p1t2m = (TextView) findViewById(R.id.one_pt_match_2);
        p2t2m = (TextView) findViewById(R.id.two_pt_match_2);
        p4t2m = (TextView) findViewById(R.id.four_pt_match_2);

        p1t1g.setText(String.valueOf(team1.getGameOnes()));
        p2t1g.setText(String.valueOf(team1.getGameTwos()));
        p4t1g.setText(String.valueOf(team1.getGameFours()));
        p1t1m.setText(String.valueOf(team1.getMatchOnes()));
        p2t1m.setText(String.valueOf(team1.getMatchTwos()));
        p4t1m.setText(String.valueOf(team1.getMatchFours()));

        p1t2g.setText(String.valueOf(team2.getGameOnes()));
        p2t2g.setText(String.valueOf(team2.getGameTwos()));
        p4t2g.setText(String.valueOf(team2.getGameFours()));
        p1t2m.setText(String.valueOf(team2.getMatchOnes()));
        p2t2m.setText(String.valueOf(team2.getMatchTwos()));
        p4t2m.setText(String.valueOf(team2.getMatchFours()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return true;
        }
    }
}
