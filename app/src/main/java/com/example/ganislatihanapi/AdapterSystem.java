package com.example.ganislatihanapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ganislatihanapi.model.DataSystem;

import java.util.ArrayList;
public class AdapterSystem extends ArrayAdapter {
    ArrayList<DataSystem> dataSystems;
    LayoutInflater layoutInflater;
    Context context;

    public AdapterSystem(Context context, ArrayList<DataSystem> datasystem) {
        super(context, R.layout.activity_daftar, datasystem);
        this.dataSystems = datasystem;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.activity_daftar, parent, false);
        DataSystem dataSystem = this.dataSystems.get(position);

        TextView titleListview = convertView.findViewById(R.id.name_system);
        ImageView imageView = convertView.findViewById(R.id.logo_system);

        Glide
                .with(context)
                .load(dataSystem.getLogo())
                .into(imageView);

        titleListview.setText(dataSystem.getNameSystem());

        return convertView;
    }
}

