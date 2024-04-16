package com.example.mohinhquanlitiendien.Model;

import java.util.Date;

public class NguoiDung {
    private String makh;
    private String hoten;
    private String soCccd;
    private String diachi;

    private String gioitinh;
    private Date ngaysinh;
    private String sdt;


    private Date ngayDk;


    public NguoiDung(String makh, String hoten, String soCccd, String diachi, String gioitinh, Date ngaysinh, String sdt, Date ngayDk) {
        this.makh = makh;
        this.hoten = hoten;
        this.soCccd = soCccd;
        this.diachi = diachi;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
        this.ngayDk = ngayDk;
    }

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

    public String getSoCccd() {
        return soCccd;
    }

    public void setSoCccd(String soCccd) {
        this.soCccd = soCccd;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgayDk() {
        return ngayDk;
    }

    public void setNgayDk(Date ngayDk) {
        this.ngayDk = ngayDk;
    }
}
