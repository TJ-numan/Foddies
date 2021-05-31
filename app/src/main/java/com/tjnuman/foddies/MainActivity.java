package com.tjnuman.foddies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.tjnuman.foddies.Adapter.PlateAdapter;
import com.tjnuman.foddies.Model.PlateModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<PlateModel> plateModelList;
    PlateAdapter plateAdapter;
    LinearLayout linearLayoutEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.recyclerview);
        linearLayoutEmail =  findViewById(R.id.linearLayoutEmail);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this){
            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView,RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(MainActivity.this) {
                    private static final float SPEED = 10000f;// Change this value (default=25f)
                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }

        };
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setKeepScreenOn(true);
        recyclerView.setHasFixedSize(true);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
                return true;
            }

            @Override
            public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        plateModelList  = new ArrayList<>();
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));
        plateModelList.add(new PlateModel(R.drawable.categories));

        plateAdapter = new PlateAdapter(this,plateModelList);
        recyclerView.setAdapter(plateAdapter);
        plateAdapter.notifyDataSetChanged();
        autoScroll();

        linearLayoutEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,EmailRegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void autoScroll(){
        final int speedScroll = 40;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;
            @Override
            public void run() {
                if(count == plateAdapter.getItemCount())
                    count = 0;
                if(count < plateAdapter.getItemCount()){
                    recyclerView.smoothScrollToPosition(++count);
                    handler.postDelayed(this,speedScroll);
                }
            }
        };
        handler.postDelayed(runnable,speedScroll);
    }

}

