package dev.gopikrishna19.scorer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int teamAScore = 0;
    private int teamBScore = 0;
    private TextView txtTeamAScore;
    private TextView txtTeamBScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTeamAScore = (TextView) findViewById(R.id.teamAScore);
        txtTeamBScore = (TextView) findViewById(R.id.teamBScore);

        resetScore(null);
    }

    private void setTeamAScore(int teamAScore) {

        txtTeamAScore.setText(String.valueOf(teamAScore));
    }

    private void setTeamBScore(int teamBScore) {

        txtTeamBScore.setText(String.valueOf(teamBScore));
    }

    public void addTeamAFreeThrow(View view) {

        setTeamAScore(teamAScore += 1);
    }

    public void addTeamAThreePoints(View view) {

        setTeamAScore(teamAScore += 3);
    }

    public void addTeamATwoPoints(View view) {

        setTeamAScore(teamAScore += 2);
    }

    public void addTeamBFreeThrow(View view) {

        setTeamBScore(teamBScore += 1);
    }

    public void addTeamBThreePoints(View view) {

        setTeamBScore(teamBScore += 3);
    }

    public void addTeamBTwoPoints(View view) {

        setTeamBScore(teamBScore += 2);
    }

    public void resetScore(View view) {

        setTeamAScore(teamAScore = 0);
        setTeamBScore(teamBScore = 0);
    }
}
