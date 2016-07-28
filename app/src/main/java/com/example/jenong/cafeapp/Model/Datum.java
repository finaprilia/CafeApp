package com.example.jenong.cafeapp.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Datum implements Parcelable
{
    public String id;
    public String rating;
    public String nama;
    public String jenis;
    public String alamat;
    public String url_foto;

    protected Datum(Parcel in) {
        id = in.readString();
        rating = in.readString();
        nama = in.readString();
        jenis = in.readString();
        alamat = in.readString();
        url_foto = in.readString();
    }

    public static final Creator<Datum> CREATOR = new Creator<Datum>() {
        @Override
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        @Override
        public Datum[] newArray(int size) {
            return new Datum[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location location;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(rating);
        parcel.writeString(nama);
        parcel.writeString(jenis);
        parcel.writeString(alamat);
        parcel.writeString(url_foto);
    }
}