package com.goteam2016.team2016scouting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Teleop extends AppCompatActivity {
    int boilerScore = 0;
    int gearScore = 0;
    Intent oldIntent;
    int teleIsHighGoalCheckBoxButton;
    int teleIsLowGoalCheckBoxButton;
    int teleClimbAirshipCheckBoxButton;
    int teleRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teleop);
        oldIntent = getIntent();
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_teleop);

    }

    public void nextActivity(View view) {
        Intent intent3 = getIntent();
        Intent intent4 = new Intent(this, ExportScreen.class);
        intent4.putExtra("TeleGearNumber", Integer.toString(gearScore));
        intent4.putExtra("TeleIsHighGoal", Integer.toString(teleIsHighGoalCheckBoxButton));
        intent4.putExtra("TeleIsLowGoal", Integer.toString(teleIsLowGoalCheckBoxButton));
        intent4.putExtra("TeleClimbedAirship", Integer.toString(teleClimbAirshipCheckBoxButton));
        intent4.putExtra("TeleShotRadioButton", Integer.toString( teleRadioButton));
        TextView gearNumber = (TextView) findViewById(R.id.gearNumber);
        intent4.putExtra("GearNumber", gearNumber.getText().toString());
        intent4.putExtras(oldIntent);
        startActivity(intent4);
    }

    /*
        public void increaseScoreBoiler(View view) {
            TextView boilerNumber = (TextView) findViewById(R.id.boilerNumber);
            boilerScore++;
            boilerNumber.setText(Integer.toString(boilerScore));
        }

        public void decreaseScoreBoiler(View view) {
            if (boilerScore > 0) {
                TextView boilerNumber = (TextView) findViewById(R.id.boilerNumber);
                boilerScore--;
                boilerNumber.setText(Integer.toString(boilerScore));
            }
        }
    */
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

    public void teleIsHighGoalCheckBoxButton(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox:
                if (!checked) {
                    teleIsHighGoalCheckBoxButton = 0;
                    break;
                } else {
                    teleIsHighGoalCheckBoxButton = 1;
                }
        }
    }

    public void teleIsLowGoalCheckBoxButton(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox2:
                if (!checked) {
                    teleIsHighGoalCheckBoxButton = 0;
                    break;
                } else {
                    teleIsLowGoalCheckBoxButton = 1;
                }
        }
    }

    public void teleIsClimbAirshipCheckBoxButton(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.climbCheckBox:
                if (!checked) {
                    teleClimbAirshipCheckBoxButton = 0;
                    break;
                } else {
                    teleClimbAirshipCheckBoxButton = 1;
                }
        }
    }

    public void radioButtonClicked(View view) {
        //is button now checked?
        boolean isButtonChecked = ((RadioButton) view).isChecked();
        //handles which radio button was clicked
        switch (view.getId()) {
            case R.id.noneRadioButton:
                if (isButtonChecked) {

                    teleRadioButton = 0;
                    break;
                }
            case R.id.fewRadioButton:
                if (isButtonChecked) {

                    teleRadioButton = 1;
                    break;
                }
            case R.id.someRadioButton:
                if (isButtonChecked) {
                    teleRadioButton = 2;
                    break;
                }
            case R.id.manyRadioButton:
                if (isButtonChecked) {
                    teleRadioButton = 3;
                    break;

                }
        }
    }
}




