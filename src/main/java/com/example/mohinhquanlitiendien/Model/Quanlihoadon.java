package com.example.mohinhquanlitiendien.Model;

public class Quanlihoadon {

    private String makh;
    private String hoten;
    private String mathang;
    private int ldtt;
    private int tien;

    public Quanlihoadon(String makh, String hoten, String mathang, int ldtt, int tien) {
        this.makh = makh;
        this.hoten = hoten;
        this.mathang = mathang;
        this.ldtt = ldtt;
        this.tien = tien;
    }
    SoDien soDien=new SoDien();

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getMathang() {
        return mathang;
    }

    public void setMathang(String mathang) {
        this.mathang = mathang;
    }

    public double getLdtt() {
        return ldtt;
    }

    public void setLdtt(int ldtt) {
        this.ldtt = ldtt;
    }

    public double getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }
}
