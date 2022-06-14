package com.example.ta_pam_astore.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ta_pam_astore.DaftarBarang;
import com.example.ta_pam_astore.EditBarang;
import com.example.ta_pam_astore.R;
import com.example.ta_pam_astore.database.Barang;
import com.example.ta_pam_astore.database.DBController;

import java.util.ArrayList;
import java.util.HashMap;

public class BarangAdapter extends RecyclerView.Adapter<BarangAdapter.BarangViewHolder> {
    private ArrayList<Barang> listdata;

    public BarangAdapter(ArrayList<Barang> listdata)
    {
        this.listdata = listdata;
    }
    private Context control;


    @NonNull
    @Override
    public BarangAdapter.BarangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_data_barang,parent,false);
        control = parent.getContext();
            return new BarangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BarangAdapter.BarangViewHolder holder, int position) {
        String id, nm, jenis, jmlh;

        id = listdata.get(position).getId();
        nm = listdata.get(position).getNama_barang();
        jenis = listdata.get(position).getJenis_barang();
        jmlh = listdata.get(position).getJumlah_barang();
        DBController db = new DBController(control);

        holder.namaTxt.setTextSize(20);
        holder.namaTxt.setTextColor(Color.BLUE);
        holder.namaTxt.setText(nm);
        holder.jenisTxt.setTextColor(Color.BLUE);
        holder.jenisTxt.setText(jenis);
        holder.jenisTxt.setTextSize(10);
        holder.jumlahTxt.setTextSize(10);
        holder.jumlahTxt.setTextColor(Color.BLUE);
        holder.jumlahTxt.setText(jmlh);

        holder.cardku.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                PopupMenu popupMenu = new PopupMenu(control, holder.cardku);
                popupMenu.inflate(R.menu.popup_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem Item) {
                        switch (Item.getItemId()){
                            case R.id.mnEdit:
                                Intent i = new Intent(control, EditBarang.class);
                                i.putExtra("id",id);
                                i.putExtra("nama_barang",nm);
                                i.putExtra("jenis_barang",jenis);
                                i.putExtra("jumlah_barang",jmlh);
                                control.startActivity(i);
                                break;
                            case R.id.mnHapus:
                                HashMap<String,String> values = new HashMap<>();
                                values.put("id",id);
                                db.DeleteData(values);
                                Intent j = new Intent(control, DaftarBarang.class);
                                control.startActivity(j);
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (listdata != null)?listdata.size() : 0;
    }

    public class BarangViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cardku;
        private TextView namaTxt, jenisTxt, jumlahTxt;
        public BarangViewHolder(View view)
        {
            super(view);
            cardku = (CardView) view.findViewById(R.id.kartuview);
            namaTxt = (TextView) view.findViewById(R.id.textNama);
            jenisTxt = (TextView) view.findViewById(R.id.textJenis);
            jumlahTxt = (TextView) view.findViewById(R.id.textJumlah);
        }
    }


}
