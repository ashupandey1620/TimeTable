package com.ashu.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    CoveredFragment coveredFragment = new CoveredFragment();
    ThisWeekFragment thisWeekFragment = new ThisWeekFragment();
    todayFragment todayFragment = new todayFragment();
    fragment_weekend weekendFragment = new fragment_weekend();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.navigation_bar);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, todayFragment).commit();




        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.today:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, todayFragment).commit();
                        return true;
                    case R.id.thisWeek:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, thisWeekFragment).commit();
                        return true;
                    case R.id.covered:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, coveredFragment).commit();
                        return true;
                    case R.id.weekend:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, weekendFragment).commit();
                        return true;

                }

                return false;
            }
        });






    }
}