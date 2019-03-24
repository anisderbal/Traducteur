package com.translator.mytraduction;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends  AppCompatActivity {
   Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




                btn = findViewById(R.id.btn1);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  startActivities(new Intent(MainActivity.this,Mainconnexion.class));
                Intent intent = new Intent(MainActivity.this, home.class);

                startActivity(intent);
            }
        });








    }






}
