package com.translator.mytraduction;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.translator.mytraduction.model.User;

public class nouvel_utilisateur extends AppCompatActivity {

Toolbar toolbar3;

EditText editTextemail,editTextpassword;
Button inscrire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvel_utilisateur);
        toolbar3 = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        editTextemail=(EditText)findViewById(R.id.editTextinscri_email);
        editTextpassword=(EditText)findViewById(R.id.editTextinscri_password);
          inscrire=(Button)findViewById(R.id.btninscri);


          //inti firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

         inscrire.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 final ProgressDialog mDialog=  new ProgressDialog(nouvel_utilisateur.this);
                 mDialog.setMessage("Veuillez patienter....");
                 mDialog.show();


                 table_user.addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                         if(dataSnapshot.child(editTextemail.getText().toString()).exists()){

                             mDialog.dismiss();
                             Toast.makeText(nouvel_utilisateur.this," votre email est correct",Toast.LENGTH_SHORT).show();


                         }
                         else {
                             mDialog.dismiss();
                             User user=new User(editTextemail.getText().toString(),editTextpassword.getText().toString());

                             table_user.child(editTextemail.getText().toString()).setValue(user);

                             Toast.makeText(nouvel_utilisateur.this," inscription est correct",Toast.LENGTH_SHORT).show();
                             finish();
                         }


                     }
                     @Override
                     public void onCancelled(@NonNull DatabaseError databaseError) {

                     }
                 });
             }
         });



    }


}