package com.tjnuman.foddies.Fragments;

import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.tjnuman.foddies.R;


public class OrdersFragment extends Fragment implements View.OnClickListener {


    public OrdersFragment() {
        // Required empty public constructor
    }
    DrawerLayout drawerLayout;
    ImageView navigationBar,iv_logout;
    LinearLayout ll_First, ll_Second,ll_Third, ll_Fourth,ll_Fifth,ll_Sixth,ll_Seventh;
    NavigationView navigationView;
    TextView tv_logout;
    View  view;





// video was in 18:48 second.




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onSetNavigationDrawerEvents();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_orders, container, false);

    }

    private void onSetNavigationDrawerEvents() {
        drawerLayout = (DrawerLayout) view.findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) view.findViewById(R.id.navigationView);
        drawerLayout.openDrawer(GravityCompat.START);
        navigationBar = (ImageView) view.findViewById(R.id.navigationBar);
        iv_logout = (ImageView) view.findViewById(R.id.iv_logout);
        tv_logout = (TextView) view.findViewById(R.id.tv_logout);

        navigationBar.setOnClickListener(this);
        ll_First.setOnClickListener(this);
        ll_Second.setOnClickListener(this);
        ll_Third.setOnClickListener(this);
        ll_Fourth.setOnClickListener(this);
        ll_Fifth.setOnClickListener(this);
        ll_Sixth.setOnClickListener(this);
        ll_Seventh.setOnClickListener(this);
        iv_logout.setOnClickListener(this);
        tv_logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigationBar:
                drawerLayout.openDrawer(navigationView, true);
                break;

            case R.id.iv_logout:
                showToast("iv_logout");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            case R.id.tv_logout:
                showToast("tv_logout");
                drawerLayout.closeDrawer(navigationView, true);
                break;
            default:
                showToast("Default");
                drawerLayout.closeDrawer(navigationView, true);
                break;

        }
    }

    private void showToast(String message){
        //Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}