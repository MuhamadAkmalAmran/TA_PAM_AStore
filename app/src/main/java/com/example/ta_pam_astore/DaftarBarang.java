package com.example.ta_pam_astore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ta_pam_astore.adapter.BarangAdapter;
import com.example.ta_pam_astore.database.Barang;
import com.example.ta_pam_astore.database.DBController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;

public class DaftarBarang extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BarangAdapter brgadapter;
    private ArrayList<Barang> barangArrayList;
    DBController dbController = new DBController(this);
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_barang);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab_add);
        readData();
        brgadapter = new BarangAdapter(barangArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DaftarBarang.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(brgadapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DaftarBarang.this, TambahBarang.class);
                startActivity(i);
            }
        });
    }

    public void readData()
    {
        ArrayList<HashMap<String, String>> daftarBarang = dbController.getAllBarang();
        barangArrayList = new ArrayList<>();

        for (int i=0; i<daftarBarang.size(); i++){
            Barang barang = new Barang();

            barang.setId(daftarBarang.get(i).get("id").toString());
            barang.setNama_barang(daftarBarang.get(i).get("nama_barang").toString());
            barang.setJenis_barang(daftarBarang.get(i).get("jenis_barang").toString());
            barang.setJumlah_barang(daftarBarang.get(i).get("jumlah_barang").toString());

            barangArrayList.add(barang);
        }

    }
}