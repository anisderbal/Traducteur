package com.translator.mytraduction;

import android.app.ListActivity;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private Button btnsynchron;
    private EditText editTextOut;
    private  EditText editTextIn;
    private TextToSpeech toSpeech;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

         editTextIn = (EditText) findViewById(R.id.inputtxt);
        final Spinner spinnerIn = (Spinner) findViewById(R.id.spinnerleft);
        final Spinner spinnerOut = (Spinner) findViewById(R.id.spinnerrighte);
        final TextView txtInt = (TextView) findViewById(R.id.selectionspinner1);
        final TextView txtOut = (TextView) findViewById(R.id.selectionspinner2);
        final List<String> spinnerArry = new ArrayList<String>();
        spinnerArry.add("Anglais");
        spinnerArry.add("Français");
        spinnerArry.add("Arabe");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spinnerArry);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerIn.setAdapter(adapter);
        spinnerOut.setAdapter(adapter);
        spinnerIn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtInt.setText("" + spinnerArry.get(position));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerIn.setSelection(0);
            }
        });
        spinnerOut.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txtOut.setText("" + spinnerArry.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerOut.setSelection(0);

            }
        });

        ///  pout  button  de  synchronisation
        btnsynchron = (Button) findViewById(R.id.btnsyncronisation);
        btnsynchron.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramAnonymousView) {
                int i = spinnerIn.getSelectedItemPosition();
                int j = spinnerOut.getSelectedItemPosition();
                spinnerIn.setSelection(j);
                spinnerOut.setSelection(i);
            }
        });


        //// partage txt par
        Button btnsearch = (Button) findViewById(R.id.btnsearch);
        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                share();
            }
        });

        Button btn_speecheText=(Button)findViewById(R.id.btnspeakerin);
        toSpeech =new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if (status!=TextToSpeech.ERROR){

                    toSpeech.setLanguage(Locale.FRANCE);



                }


            }
        });
        btn_speecheText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSpeech.speak(editTextIn.getText().toString(),TextToSpeech.QUEUE_FLUSH, null);
            }
        });







        //////  pour toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        /////pour bottom  bar

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom1);
        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item1) {
    /*  switch (item1.getItemId()) {
          case R.id.btn_nav_camera:
              Intent intent8 = new Intent(home.this, historique.class);
              startActivity(intent8);
          case R.id.btn_nav_fav:
              Intent intent9 = new Intent(home.this,favorite.class);
              startActivity(intent9);
              break;


      }*/
                int id = item1.getItemId();

                if (id == R.id.btn_nav_fav) {
                    Intent intent = new Intent(home.this, favorite.class);
                    startActivity(intent);


                } else if (id == R.id.btn_nav_camera) {


                    Intent intent1 = new Intent(home.this, connexion.class);
                    startActivity(intent1);


                } else if (id == R.id.btn_nav_microphone) {
                    speak();



////////////////////////////////////////////
                }

            }
        });

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nav_bottom, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.btn_nav_fav) {
            Intent intent = new Intent(home.this, home.class);
            startActivity(intent);


        } else if (id == R.id.btn_nav_camera) {


            Intent intent1 = new Intent(home.this, connexion.class);
            startActivity(intent1);


        } else if (id == R.id.btn_nav_microphone) {
            Intent intent2 = new Intent(home.this, historique.class);
            startActivity(intent2);


        }
        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.btn_nav_rechercher) {
            Intent intent = new Intent(home.this, home.class);
            startActivity(intent);


        } else if (id == R.id.btn_nav_connexion) {


            Intent intent1 = new Intent(home.this, connexion.class);
            startActivity(intent1);


        } else if (id == R.id.btn_nav_historique) {
            Intent intent2 = new Intent(home.this, historique.class);
            startActivity(intent2);


        } else if (id == R.id.btn_nav_favorite) {
            Intent intent3 = new Intent(home.this, favorite.class);
            startActivity(intent3);

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /// pour  btn clear(supprimer le text de traduction
    public void supprimer(View view) {
        /// pour  btn clear(supprimer le text de traduction
        final EditText et = (EditText) findViewById(R.id.inputtxt);

        Button btn1 = (Button) findViewById(R.id.btnclear);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");


            }


        });


    }

    //  pour   copie  le  txtde  edtitxt2 (outputtxt)
    private EditText editText;

    public void copy(View view) {

        editText = (EditText) findViewById(R.id.outputtxt);
        Button btn_copy_text = (Button) findViewById(R.id.btncopie);

        btn_copy_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getstring = editText.getText().toString();
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

                clipboard.setText(getstring);


            }
        });


    }

    ////// pour button share
    private void share() {
        editTextOut = (EditText) findViewById(R.id.outputtxt);
        String str = editTextOut.getText().toString();
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.SEND");
        localIntent.putExtra("android.intent.extra.TEXT", str);
        localIntent.setType("text/plain");
        startActivity(Intent.createChooser(localIntent, "Share via..."));
    }


    private void speak() {
        //intenet  to show speech  text dailog

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Dites quelque chose..");
        //start intent
        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);

        } catch (Exception e) {

            //get message  of error and  show
            Toast.makeText(this, "je  n'ai pas compris" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK &&null!=data ){
                    ///  get  text  array  from  voice intent
                    ArrayList<String> result=  data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    editTextIn.setText(result.get(0));



                }
                break;

            }


        }
    }
}