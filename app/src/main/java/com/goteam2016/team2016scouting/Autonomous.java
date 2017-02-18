package com.goteam2016.team2016scouting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

//import static com.goteam2016.team2016scouting.R.id.boilerNumber;


public class Autonomous extends AppCompatActivity {
    String matchNumberText;
    int autoRadioButton;
    String teamNumber;
    int boilerScore = 0;
    int gearScore = 0;
    int autoProgramCheckBoxButton;
    int autoShootCheckBoxButton;
    int autoBaselineCheckBoxButton;
    Intent oldIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autonomous);
        oldIntent = getIntent();
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_autonomous);
        teamNumber = oldIntent.getStringExtra("TeamNumber");
    }

    public void nextActivity(View view) {
        TextView gearNumber = (TextView) findViewById(R.id.gearNumber);
        Intent intent3 = new Intent(this, Teleop.class);
        intent3.putExtra("AutoRadioButton", Integer.toString(autoRadioButton));
        intent3.putExtra("AutoProgramCheckbox", Integer.toString(autoProgramCheckBoxButton));
        intent3.putExtra("AutoShootCheckbox", Integer.toString(autoShootCheckBoxButton));
        intent3.putExtra("AutoCrossBaseline", Integer.toString(autoBaselineCheckBoxButton));
        intent3.putExtras(oldIntent);
        intent3.putExtra("AutoGearNumber", gearNumber.getText().toString());
        // Intent matchNumber = new Intent(this, ExportScreen.class);
      //  matchNumber.putExtra("MatchNumber", matchNumberText);
        startActivity(intent3);
      //  int totalGearScore = gearNumber;
     //   int totalBoilerScore = boilerNumber;

    }
/*
    public void increaseScoreBoiler(View view) {
        TextView boilerNumber = (TextView) findViewById(R.id.boilerNumber);
        boilerScore++;
        boilerNumber.setText(Integer.toString(boilerScore));
    }
/*
   /* public void decreaseScoreBoiler(View view) {
        if (boilerScore > 0) {
            TextView boilerNumber = (TextView) findViewById(R.id.boilerNumber);
            boilerScore--;
            boilerNumber.setText(Integer.toString(boilerScore));
        } */
//    }

    public void increaseScoreGear(View view) {
        TextView gearNumber = (TextView) findViewById(R.id.gearNumber);

        gearScore++;
        gearNumber.setText(Integer.toString(gearScore));
    }

    public void decreaseScoreGear(View view) {
        if (gearScore > 0) {

            TextView gearNumber = (TextView) findViewById(R.id.gearNumber);
            gearScore--;
            gearNumber.setText(Integer.toString(gearScore));
        }
    }
    public void autoProgramCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.autoProgramCheckbox:
                if (!checked) {
                    autoProgramCheckBoxButton = 0;
                    break;
                } else {
                    autoProgramCheckBoxButton = 1;
                }
        }
    }

    public void autoBaselineCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.autoShootCheckbox:
                if (!checked) {
                    autoBaselineCheckBoxButton = 0;
                    break;
                } else {
                    autoBaselineCheckBoxButton = 1;
                }
        }
    }

    public void autoShootCheckBoxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.autoShootCheckbox:
            if(!checked) {
                autoShootCheckBoxButton = 0;
                break;
            }
            else {
                autoShootCheckBoxButton = 1;
            }
        }
    }
    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.moreRadioButton:
                if (checked) {
                    autoRadioButton = 1;
                    break;
                }
            case R.id.lessRadioButton:
                if (checked) {
                    autoRadioButton = 0;
                    break;
                }
            }
        }
    }

