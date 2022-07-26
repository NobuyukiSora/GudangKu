package com.example.mcs_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailBarang extends AppCompatActivity {

    TextView namabarang;
    Bundle ext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        namabarang = findViewById(R.id.namaitem);

        ext = getIntent().getExtras();
        namabarang.setText("" + ext.getString("linknama").toString());
    }
}