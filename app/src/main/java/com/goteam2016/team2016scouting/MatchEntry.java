package com.goteam2016.team2016scouting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import static android.R.attr.id;

public class MatchEntry extends AppCompatActivity {
    // public final static String EXTRA_MESSAGE = "Sup my dude";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_entry);
        Intent intent = getIntent();
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_team_entry);

    }

    public void nextActivity(View view) {
        EditText matchText = (EditText) findViewById(R.id.matchText);
        //matchText.getText();
        if (matchText.length() > 0) {


            Intent intent1 = new Intent(this, TeamEntry.class);
            intent1.putExtra("MatchNumber", matchText.getText().toString());
            Intent matchNumber = new Intent(this, ExportScreen.class);
            matchNumber.putExtra("MatchNumber", matchText.getText().toString());

            intent1.putExtra("MatchNumber", matchText.getText().toString());

        /*EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        */
            startActivity(intent1);

        }


    }
}
