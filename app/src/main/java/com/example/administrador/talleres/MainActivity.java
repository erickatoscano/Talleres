package com.example.administrador.talleres;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;


    private int[]tabIcons={R.drawable.happy,
            R.drawable.ic_sentiment_satisfied_black_24dp,
            R.drawable.ic_sentiment_very_satisfied_black_24dp};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);

        tabIcons();
        iconColor(tabLayout.getTabAt(tabLayout.getSelectedTabPosition()),"#FFFFFF");
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                iconColor(tab,"#FFFFFF");

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                iconColor(tab,"#5273AF");

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void iconColor(TabLayout.Tab tab, String color){
        tab.getIcon().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_IN);
    }


    private void tabIcons(){
        for(int i=0; i<3;i++){
            tabLayout.addTab(tabLayout.newTab().setIcon(tabIcons[i]));
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.taller1:
                Intent intent1 = new Intent(this, taller_1.class);
                startActivity(intent1);
                break;
            case R.id.taller2:
                Intent intent2 = new Intent(this, taller_2.class);
                startActivity(intent2);
                break;

            case R.id.taller3:
                Intent intent3 = new Intent(this, taller3.class);
                startActivity(intent3);
                break;
        }
        return true;
    }
}
