package com.example.ta_pam_astore.database;

public class Barang {

    String id;
    String nama_barang;
    String jenis_barang;
    String jumlah_barang;

    public Barang()
    {

    }

    public Barang(String id, String nama_barang, String jenis_barang, String jumlah_barang)
    {
        this.id = id;
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
        this.jumlah_barang = jumlah_barang;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNama_barang()
    {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang)
    {
        this.nama_barang = nama_barang;
    }

    public String getJenis_barang()
    {
        return jenis_barang;
    }

    public void setJenis_barang(String jenis_barang)
    {
        this.jenis_barang = jenis_barang;
    }

    public String getJumlah_barang()
    {
        return jumlah_barang;
    }

    public void setJumlah_barang(String jumlah_barang)
    {
        this.jumlah_barang = jumlah_barang;
    }

}
