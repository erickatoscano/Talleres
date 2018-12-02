package com.example.administrador.talleres;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class taller_2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner enfermedadesSpinner;
    String enfermedadGuardada;
    private Toolbar toolbar2;

    private TimePicker time_Picker;
    private ImageButton mostrarHora;
    private TextView textHora;

    private  WebView webView;


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_2);

        toolbar2 = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar2);

        mostrarSpinner();
        hora();
        navegador();
    }

    private void navegador() {
        WebView browser =(WebView) findViewById(R.id.webView);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl("https://www.youtube.com/");
        browser.setVerticalScrollBarEnabled(true);
        browser.setHorizontalScrollBarEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        WebView mWebView;
        mWebView = (WebView) findViewById(R.id.webView);
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack()) {
                        mWebView.goBack();
                    } else {
                        finish();
                    }
                    return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
    private void hora() {
        mostrarHora = (ImageButton) findViewById(R.id.btn_hora);
        textHora = (TextView) findViewById(R.id.mostrar_hora);

        mostrarHora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTime();
            }
        });
    }

    private void mostrarSpinner() {
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

    private void showTime() {

        final Calendar calendar = Calendar.getInstance();

        final int hour=calendar.get(Calendar.HOUR_OF_DAY);
        final int min=calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                textHora.setText(hourOfDay+":"+minute);
            }
        },hour,min,true);
        timePickerDialog.show();

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
