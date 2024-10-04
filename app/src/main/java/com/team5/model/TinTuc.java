package com.team5.model;

import android.widget.ImageView;
import android.widget.TextView;

public class TinTuc {
    private int tintucHinh;
    private String tintucTen;
    private String tintucNgay;

    public int getTintucHinh() {
        return tintucHinh;
    }

    public void setTintucHinh(int tintucHinh) {
        this.tintucHinh = tintucHinh;
    }

    public String getTintucTen() {
        return tintucTen;
    }

    public void setTintucTen(String tintucTen) {
        this.tintucTen = tintucTen;
    }

    public String getTintucNgay() {
        return tintucNgay;
    }

    public void setTintucNgay(String tintucNgay) {
        this.tintucNgay = tintucNgay;
    }

    public TinTuc(int tintucHinh, String tintucTen, String tintucNgay) {
        this.tintucHinh = tintucHinh;
        this.tintucTen = tintucTen;
        this.tintucNgay = tintucNgay;
    }
}
