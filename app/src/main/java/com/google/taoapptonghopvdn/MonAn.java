package com.google.taoapptonghopvdn;

public class MonAn {
    private String tenmon;
    private String giatien;
    private String mota;
    private int hinh;

    public MonAn(String tenmon, String giatien, String mota, int hinh) {
        this.tenmon = tenmon;
        this.giatien = giatien;
        this.mota = mota;
        this.hinh = hinh;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public String getGiatien() {
        return giatien;
    }

    public void setGiatien(String giatien) {
        this.giatien = giatien;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
