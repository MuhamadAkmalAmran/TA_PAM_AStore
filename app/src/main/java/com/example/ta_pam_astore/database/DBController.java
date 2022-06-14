package com.example.ta_pam_astore.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DBController extends SQLiteOpenHelper {
    //Membuat contructor database
    public  DBController(Context context)
    {
        super(context, "AStore",null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table barang(id integer primary key, nama_barang text, jenis_barang text, jumlah_barang text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists barang");
        onCreate(db);
    }

    public void insertData(HashMap<String, String> queryValues)
    {
        SQLiteDatabase basisdata = this.getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama_barang", queryValues.get("nama_barang"));
        nilai.put("jenis_barang", queryValues.get("jenis_barang"));
        nilai.put("jumlah_barang", queryValues.get("jumlah_barang"));
        basisdata.insert("barang",null, nilai);
        basisdata.close();
    }

    public void UpdateData(HashMap<String, String> queryValues)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues nilai = new ContentValues();
        nilai.put("nama_barang", queryValues.get("nama_barang"));
        nilai.put("jenis_barang", queryValues.get("jenis_barang"));
        nilai.put("jumlah_barang", queryValues.get("jumlah_barang"));
        db.update("barang", nilai,"id=?", new String[]{queryValues.get("id")});
        db.close();
    }

    public void DeleteData(HashMap<String, String> queryValues)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("barang", "id=?", new String[]{queryValues.get("id")});
        db.close();
    }



    public ArrayList<HashMap<String,String>> getAllBarang()
    {
        ArrayList<HashMap<String,String>> daftarBarang;
        daftarBarang = new ArrayList<HashMap<String,String>>();
        String selectQuery = "Select * from barang";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if (cursor.moveToFirst())
        {
            do {
                HashMap<String,String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("nama_barang", cursor.getString(1));
                map.put("jenis_barang",cursor.getString(2));
                map.put("jumlah_barang",cursor.getString(3));
                daftarBarang.add(map);
            }
            while (cursor.moveToNext());
        }
        db.close();
        return daftarBarang;
    }


}
