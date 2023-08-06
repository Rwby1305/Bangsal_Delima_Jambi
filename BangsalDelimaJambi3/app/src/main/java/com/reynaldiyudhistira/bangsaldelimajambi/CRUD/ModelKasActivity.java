package com.reynaldiyudhistira.bangsaldelimajambi.CRUD;

public class ModelKasActivity {
    private String PemasukanKas;
    private String PengeluaranKas;
    private String TanggalKas;
    private String key;

    public ModelKasActivity(){
    }

    public ModelKasActivity(String pemasukanKas, String pengeluaranKas, String tanggalKas) {
        PemasukanKas = pemasukanKas;
        PengeluaranKas = pengeluaranKas;
        TanggalKas = tanggalKas;
    }

    public String getPemasukanKas() {
        return PemasukanKas;
    }

    public void setPemasukanKas(String pemasukanKas) {
        PemasukanKas = pemasukanKas;
    }

    public String getPengeluaranKas() {
        return PengeluaranKas;
    }

    public void setPengeluaranKas(String pengeluaranKas) {
        PengeluaranKas = pengeluaranKas;
    }

    public String getTanggalKas() {
        return TanggalKas;
    }

    public void setTanggalKas(String tanggalKas) {
        TanggalKas = tanggalKas;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}