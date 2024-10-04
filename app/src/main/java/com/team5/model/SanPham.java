package com.team5.model;

import java.io.Serializable;

public class SanPham implements Serializable {
    private int id;
    private int sanphamHinh;
    private String sanphamTen;
    private double sanphamGia;
    private String sanphamGiamGia;
    private int sanphamId;

    public SanPham(int id, int sanphamHinh, String sanphamTen, double sanphamGia, String sanphamGiamGia) {
        this.id = id;
        this.sanphamHinh = sanphamHinh;
        this.sanphamTen = sanphamTen;
        this.sanphamGia = sanphamGia;
        this.sanphamGiamGia = sanphamGiamGia;
        this.sanphamId = sanphamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSanphamHinh() {
        return sanphamHinh;
    }

    public void setSanphamHinh(int sanphamHinh) {
        this.sanphamHinh = sanphamHinh;
    }

    public String getSanphamTen() {
        return sanphamTen;
    }

    public void setSanphamTen(String sanphamTen) {
        this.sanphamTen = sanphamTen;
    }

    public double getSanphamGia() {
        return sanphamGia;
    }

    public void setSanphamGia(double sanphamGia) {
        this.sanphamGia = sanphamGia;
    }

    public String getSanphamGiamGia() {
        return sanphamGiamGia;
    }

    public void setSanphamGiamGia(String sanphamGiamGia) {
        this.sanphamGiamGia = sanphamGiamGia;
    }

    public int getSanphamId() {
        return sanphamId;
    }

    public void setSanphamId(int sanphamId) {
        this.sanphamId = sanphamId;
    }
}
