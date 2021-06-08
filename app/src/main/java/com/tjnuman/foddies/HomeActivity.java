package com.tjnuman.foddies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tjnuman.foddies.Fragments.FavoriteFragment;
import com.tjnuman.foddies.Fragments.GoOutFragment;
import com.tjnuman.foddies.Fragments.OrdersFragment;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomnavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId())
                {
                    case R.id.order:
                        selectedFragment = new OrdersFragment();
                        break;

                    case R.id.Favorite:
                        selectedFragment = new FavoriteFragment();
                        break;

                    case R.id.go_out:
                        selectedFragment = new GoOutFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,
                        selectedFragment).commit();
                return true;
            }
        });
    }
}