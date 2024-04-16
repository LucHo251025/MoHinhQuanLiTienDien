package com.example.mohinhquanlitiendien.Model;

public class SoDien {

    private String makh;
    private String mathang;
    private int chisocu;
    private int chisomoi;
    private double ldtt;
    private double tien;

    public SoDien(){

    }

    public SoDien(String makh, String mathang, int chisocu, int chisomoi) {
        this.makh = makh;
        this.mathang = mathang;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }



    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMathang() {
        return mathang;
    }

    public void setMathang(String mathang) {
        this.mathang = mathang;
    }

    public int getChisocu() {
        return chisocu;
    }

    public void setChisocu(int chisocu) {
        this.chisocu = chisocu;
    }

    public int getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(int chisomoi) {
        this.chisomoi = chisomoi;
    }
}
