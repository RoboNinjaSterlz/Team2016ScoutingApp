package com.goteam2016.team2016scouting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.os.Environment;
import android.widget.EditText;


import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ExportScreen extends AppCompatActivity {
    String gearNumber;
    String matchNumberText;
    Intent oldIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_export_screen);
        oldIntent = getIntent();
        gearNumber = oldIntent.getStringExtra("GearNumber");
        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_export_screen);
        Intent intent1 = getIntent();
        matchNumberText =  oldIntent.getStringExtra("MatchNumber");
        // Bundle bundle = getIntent().getExtras();
        // String matchNumber = bundle.getString("MatchNumber");

    }

    public void createFile(View view) {
        //Creates new file each time
        try {
            File root = new File(Environment.getExternalStorageDirectory(), "2016Scouting");

            //if file not there, it makes its own
            if (!root.exists()) {
                root.mkdirs();
            }

            File file = new File(root, "T" + (oldIntent.getStringExtra("TeamNumber")) + "M" + (oldIntent.getStringExtra("MatchNumber")) +".txt" );

            FileOutputStream writer = new FileOutputStream(file);

            // File filepath = new File("T" + teamNumber + "M" + matchNumber);
            // FileWriter writer = new FileWriter(filepath);
            OutputStreamWriter osw = new OutputStreamWriter(writer);
            // writer.flush();
           // osw.write("TEAM_NUMBER,MATCH_NUMBER,AUTO_GEAR_NUMBER,AUTO_PROGRAM_CHECKBOX,AUTO_SHOOT_CHECKBOX,AUTO_CROSS_BASELINE,AUTO_RADIO_BUTTON,TELE_GEAR_NUMBER,TELE_IS_HIGH_GOAL,TELE_IS_LOW_GOAL,TELE_RADIO_BUTTON,TELE_CLIMB_AIRSHIP_CHECKBOX_BUTTON\n");
            osw.write(oldIntent.getStringExtra("TeamNumber") + "," + oldIntent.getStringExtra("MatchNumber") + "," + oldIntent.getStringExtra("AutoGearNumber") + "," + oldIntent.getStringExtra("AutoProgramCheckbox") + "," + oldIntent.getStringExtra("AutoShootCheckbox") + "," + oldIntent.getStringExtra("AutoRadioButton") + "," + oldIntent.getStringExtra("TeleGearNumber") + "," + oldIntent.getStringExtra("TeleIsHighGoal") + "," + oldIntent.getStringExtra("TeleIsLowGoal") + "," + oldIntent.getStringExtra("TeleShotRadioButton") + "," + oldIntent.getStringExtra("TeleClimbedAirship") );

            osw.flush();
            osw.close();
            Intent intent = new Intent(this, MatchEntry.class);
            startActivity(intent);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("you really thought lmao");

        }

    }
}
