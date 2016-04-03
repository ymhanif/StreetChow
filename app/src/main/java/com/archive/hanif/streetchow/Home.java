package com.archive.hanif.streetchow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    Button call_police;
    Button call_fire;
    Button call_ambulance;
    String police = "0201987769";
    String ambulance = "0244608418";
    String fire = "0207453058";
    String emergency_num = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button call_police = (Button)findViewById(R.id.btn_police);
        Button call_fire = (Button)findViewById(R.id.btn_fire);
        Button call_ambulance = (Button)findViewById(R.id.btn_ambulance);

    }

    public void call_emergency(View button){

        if (button == call_police){
            emergency_num = police;
        }
        else if(button == call_fire){
            emergency_num = fire;
        }
        else if(button == call_ambulance){
            emergency_num = ambulance;
        }

        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse(emergency_num));
        try{
            startActivity(in);
        }
        catch (android.content.ActivityNotFoundException ex){
            Log.i("INFO: Number called:", emergency_num);
            Log.e("ERROR is", ex.toString());
            Toast.makeText(getApplicationContext(), "There was an error.", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
