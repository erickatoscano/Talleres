package com.example.administrador.talleres;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class taller3 extends AppCompatActivity {

    private Toolbar toolbar2;

    Button btn_mostrar3;
    private String[] enfermedades;

    private ProgressBar progressBar;
    private int progressStatus=0;
    Button btnStart;
    private TextView txtProgeso;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller3);

        toolbar2 = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar2);

        seleccion();

        barraProgreso();
    }

    private void seleccion() {
        enfermedades=getResources().getStringArray(R.array.enfermedades);

        btn_mostrar3=(Button)findViewById(R.id.btn_mostrar3);
        btn_mostrar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(taller3.this);
                builder.setTitle("Seleccione la enfermedad que padece");
                builder.setItems(R.array.enfermedades, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(
                                taller3.this,
                                String.format("Enfermedad: %s",enfermedades[which]),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                });
                Dialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    private void barraProgreso() {
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtProgeso=(TextView) findViewById(R.id.txtProgreso);
        btnStart=(Button) findViewById(R.id.btn_StartPB);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus += 1;
                            // Update the progress bar and display the
                            //current value in the text view
                            handler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    txtProgeso.setText(progressStatus+"/"+progressBar.getMax());
                                }
                            });
                            try {
                                // Sleep for 200 milliseconds.
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();

            }
        });

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
