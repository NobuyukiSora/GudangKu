package com.example.mcs_lab;

public class Barang {
    private String namabarang;
    private String idbarang;
    private String hargabarang;

    public Barang(String namabarang, String idbarang, String hargabarang) {
        this.namabarang = namabarang;
        this.idbarang = idbarang;
        this.hargabarang = hargabarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getHargabarang() {
        return hargabarang;
    }

    public void setHargabarang(String hargabarang) {
        this.hargabarang = hargabarang;
    }
}
