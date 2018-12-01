package com.example.administrador.talleres;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class taller_1 extends AppCompatActivity {


    private Toolbar toolbar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taller_1);

        toolbar2 = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar2);

        final RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);
        Button mostrar1 = (Button) findViewById(R.id.btn_mostrar1);
        final TextView comentario1 = (TextView)findViewById(R.id.commentbox);
        final TextView text1 = (TextView) findViewById(R.id.mostrar_1);

        mostrar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Calificación: " + ratingBar.getRating() + "\nComentario: " +comentario1.getText());
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
