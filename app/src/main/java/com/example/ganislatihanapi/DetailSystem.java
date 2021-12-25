package com.example.ganislatihanapi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.ganislatihanapi.model.DataSystem;
public class DetailSystem extends AppCompatActivity {
    DataSystem system;
    ImageView logo;
    TextView namaSystem, versi,  description,developer,website,smodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_system);

        Intent intent = getIntent();
        system = (DataSystem) intent.getSerializableExtra("System");
        inisialisasiView();
    }

    void inisialisasiView() {
        logo = findViewById(R.id.logo);
        namaSystem = findViewById(R.id.jenisSistem);
        description = findViewById(R.id.deskripsi);
        versi = findViewById(R.id.versi);
        developer = findViewById(R.id.developer);
        website = findViewById(R.id.link);
        smodel = findViewById(R.id.model);

        namaSystem.setText(system.getNamaSystem());
        description.setText(system.getDescription());
        versi.setText(system.getVersi());
        developer.setText(system.getDeveloper());
        website.setText(system.getWebsite());
        smodel.setText(system.getSmodel());

        Glide
                .with(this)
                .load(system.getLogo())
                .into(logo);
    }

    public void clikToDetail(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(system.getWebsite()));
        startActivity(intent);
    }
}

