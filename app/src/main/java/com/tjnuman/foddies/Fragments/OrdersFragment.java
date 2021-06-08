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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.tjnuman.foddies.R;


public class OrdersFragment extends Fragment implements View.OnClickListener {


    public OrdersFragment() {
        // Required empty public constructor
    }
    DrawerLayout drawerLayout;
    ImageView navigationBar;
    NavigationView navigationView;
    View  view;
    RelativeLayout LoginSingup,bookmarks;
    TextView yourOrder,yourfavorite,addressbook,onlineHelp,feedBack,Report,Rateus;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_orders, container, false);
        onSetNavigationDrawerEvents();
        return view;
    }

    private void onSetNavigationDrawerEvents() {
        drawerLayout =  view.findViewById(R.id.drawerLayout);
        navigationView = view.findViewById(R.id.navigationView);
        navigationBar = (ImageView) view.findViewById(R.id.navigationBar);
        LoginSingup = view.findViewById(R.id.relativeLayout2);
        bookmarks = view.findViewById(R.id.relativeLayout3);
        yourOrder = view.findViewById(R.id.YourOrder);
        yourfavorite = view.findViewById(R.id.yourFavorite);
        addressbook = view.findViewById(R.id.addressBook);
        onlineHelp = view.findViewById(R.id.OnlineHelp);
        feedBack = view.findViewById(R.id.feedback);
        Report = view.findViewById(R.id.Report);
        Rateus = view.findViewById(R.id.RateUs);

        navigationBar.setOnClickListener(this);
        LoginSingup.setOnClickListener(this);
        bookmarks.setOnClickListener(this);
        yourfavorite.setOnClickListener(this);
        yourOrder.setOnClickListener(this);
        addressbook.setOnClickListener(this);
        onlineHelp.setOnClickListener(this);
        feedBack.setOnClickListener(this);
        Report.setOnClickListener(this);
        Rateus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigationBar:
                drawerLayout.openDrawer(navigationView, true);
                break;

//            case R.id.tv_one:
//                Toast.makeText(getContext(), "One", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tv_two:
//                Toast.makeText(getContext(), "Two", Toast.LENGTH_SHORT).show();
//                break;
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