package com.example.jenong.cafeapp.Model;

import java.util.List;

public class DATA {
    public String nama;
    public Location location;
    public String alamat;
    public String deskripsi;
    public List<Fasilita> fasilitas;


    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public List<Fasilita> getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(List<Fasilita> fasilitas) {
        this.fasilitas = fasilitas;
    }
}