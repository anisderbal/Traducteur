package com.translator.mytraduction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.translator.mytraduction.model.User;*/

public class email extends AppCompatActivity {
    Toolbar toolbar;

     EditText  editText1, editText2;
       Button  btnconnexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        toolbar=findViewById(R.id.toolbar2);
        toolbar.setTitle("Connexion");

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

         editText1=(EditText) findViewById(R.id.editTexteamil);
         editText2=(EditText)findViewById(R.id.editTextpassword);

         btnconnexion=(Button) findViewById(R.id.btnconnexion1);
///  init  datebase
        //final FirebaseDatabase  database = FirebaseDatabase.getInstance();
        //final DatabaseReference  table_user = database.getReference("User");


          /* btnconnexion.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 final ProgressDialog mDialog=  new ProgressDialog(email.this);
                   mDialog.setMessage("Veuillez patienter....");
                   mDialog.show();

                 table_user.addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                         //check  if  user   not  exist  in  database

                         if (dataSnapshot.child(editText1.getText().toString()).exists()){

                             //get user information

                             mDialog.dismiss();

                         User user = dataSnapshot.child(editText1.getText().toString()).getValue(User.class);


                              if (user.getPassword().equals(editText2.getText().toString())) {
                                  Toast.makeText(email.this, "Connexion correct", Toast.LENGTH_SHORT).show();

                              }
                               else{
                                  Toast.makeText(email.this, "Connexion   incorrect", Toast.LENGTH_SHORT).show();

                               }



                     }
                     else {
                             mDialog.dismiss();
                             Toast.makeText(email.this, "compte ne exist pas ", Toast.LENGTH_SHORT).show();
                         }

                     }

                     @Override
                     public void onCancelled(@NonNull DatabaseError databaseError) {

                     }
                 });
             }
         });*/






    }

    ///  pour  button  de  inscription (nouvel utilisateur)
    public  void inscription(View view){

        Button btn=(Button)findViewById(R.id.btnInscri1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(email.this,nouvel_utilisateur.class);
                startActivity(intent);

            }
        });


    }






}
