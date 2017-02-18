package com.goteam2016.team2016scouting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import static com.goteam2016.team2016scouting.R.id.matchText;

public class TeamEntry extends AppCompatActivity {
    String teamNumber;
    String text;
    String matchNumberText;
    Intent oldIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_entry);
        oldIntent = getIntent();
        // String message = intent.getStringExtra(MatchEntry.EXTRA_MESSAGE);
       /* TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);
        */
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_team_entry);
        text = oldIntent.getStringExtra("MatchNumber");
        //layout.addView(textView);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Awesome, Match " + text + "! And what team are we scouting?");
        Intent matchNumber = getIntent();
        matchNumberText = matchNumber.getStringExtra("MatchNumber");
    }

    public void nextActivity(View view) {
        EditText teamText = (EditText) findViewById(R.id.teamText);

        if (teamText.length() > 0) {
            Intent intent2 = new Intent(this, Autonomous.class);
            intent2.putExtras(oldIntent);
            intent2.putExtra("TeamNumber", teamText.getText().toString());
            startActivity(intent2);
        }
    }
}