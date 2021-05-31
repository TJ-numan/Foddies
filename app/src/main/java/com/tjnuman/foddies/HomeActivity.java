package com.tjnuman.foddies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.order:
                        Toast.makeText(HomeActivity.this, "Order", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.Favorite:
                        Toast.makeText(HomeActivity.this, "Favorite", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.go_out:
                        Toast.makeText(HomeActivity.this, "Go Out", Toast.LENGTH_SHORT).show();
                        break;

                }

                return true;
            }
        });
    }
}