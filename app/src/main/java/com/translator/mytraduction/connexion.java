package com.translator.mytraduction;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class connexion extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        toolbar = findViewById(R.id.toolbar1);
        toolbar.setTitle("Connexion");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

   public void email(View view) {
        final Button btn;
        btn = (Button) findViewById(R.id.btnEmail);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(connexion.this, email.class));

            }
        });


    }

    ///  pour  button  de  inscription (nouvel utilisateur)
    public  void inscription(View view){

        Button btn=(Button)findViewById(R.id.btnInscri);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(connexion.this,nouvel_utilisateur.class);
                startActivity(intent);

            }
        });


    }


}