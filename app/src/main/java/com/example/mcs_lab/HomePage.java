package com.example.mcs_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Vector;

public class HomePage extends AppCompatActivity implements BarangAdapter.ItemClickListener{

    private RecyclerView rv;
    BarangAdapter BA;
    DatabaseReference DB;
    FirebaseFirestore db;
//    FirebaseFirestore DB;
    Barang b;
    Database dbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ////////////////////////////////////////////////////

        db = FirebaseFirestore.getInstance();
        Vector<Barang> products = new Vector<Barang>();

        db.collection("Barang").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot doc : task.getResult()){
                        Log.d("getName", doc.get("nama").toString());
                        String nama = doc.get("nama").toString();
                        String id = doc.get("id").toString();
                        String harga = doc.get("harga").toString();

                        dbb.getDatabarang().add(new Barang(nama, id, harga));
                    }
                }
            }
        });

        ///////////////////////////////////////////////////


//        DB = FirebaseDatabase.getInstance().getReference();
        rv = findViewById(R.id.list_barang_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

//        FirebaseRecyclerOptions<Barang> options = new FirebaseRecyclerOptions.Builder<Barang>().setQuery(DB, Barang.class).build();

        BA = new BarangAdapter(Database.getDatabarang());
        BA.setICL(this);
        rv.setAdapter(BA);
    }

    @Override
    public void onItemClick(View view, int position) {
        String linkname = BA.getItem(position).getNamabarang().toString();
        String linkid = BA.getItem(position).getIdbarang().toString();

        Log.d("getNameLink", linkname);
        Intent i = new Intent(HomePage.this, DetailBarang.class);
        i.putExtra("linknama",linkname);
        i.putExtra("linkid",linkid);

        startActivity(i);
//        Toast.makeText(this, "You clicked " + BA.getItem(position).getNamabarang(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

//    @Override
//    public void onItemClick(View view, int position) {
//        Log.d("getNameeee", BA.getItem(position).getNamabarang().toString());
//        Toast.makeText(this, "You clicked " + BA.getItem(position).getNamabarang(), Toast.LENGTH_SHORT).show();
//    }


//    @Override
//    protected void onStart() {
//        super.onStart();
//        BA.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        BA.stopListening();
//    }
}