package com.example.administrador.talleres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class taller_2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner enfermedadesSpinner;
    String enfermedadGuardada;
    private Toolbar toolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_2);

        toolbar2 = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar2);

        enfermedadesSpinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.enfermedades,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enfermedadesSpinner.setOnItemSelectedListener(this);


        Button mostrar2 = (Button) findViewById(R.id.btn_mostrar2);
        final TextView text2 = (TextView) findViewById(R.id.mostrar_2);

        mostrar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setText("Selección " + enfermedadGuardada);
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        enfermedadGuardada=parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.out:
                Intent intent1 = new Intent(this, MainActivity.class);
                startActivity(intent1);
                break;
        }
        return true;
    }
}
