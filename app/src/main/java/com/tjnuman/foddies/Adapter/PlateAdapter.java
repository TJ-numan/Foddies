package com.tjnuman.foddies.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tjnuman.foddies.Model.PlateModel;
import com.tjnuman.foddies.R;

import java.util.List;
import java.util.PrimitiveIterator;

public class PlateAdapter extends RecyclerView.Adapter<PlateAdapter.myViewHolder> {
    Context context;
    List<PlateModel> list;

    public PlateAdapter(Context context, List<PlateModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plate,parent,false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        PlateModel plateModel = list.get(position);
        Glide.with(context).load(plateModel.getPlateImage()).into(holder.plateImage);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView plateImage;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            plateImage = itemView.findViewById(R.id.itemImage);
        }
    }
}
