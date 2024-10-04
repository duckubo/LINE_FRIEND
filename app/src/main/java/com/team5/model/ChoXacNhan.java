package com.team5.model;

public class ChoXacNhan {
    public int id;
    public int sanphamHinh;
    public String sanphamTen;
    public double sanphamGia;
    public String sanphamGiamGia;
    public int soluongSP;
    public int sanphamId;

    public ChoXacNhan(int id, int sanphamHinh, String sanphamTen, double sanphamGia, String sanphamGiamGia, int soluongSP, int sanphamId) {
        this.id = id;
        this.sanphamHinh = sanphamHinh;
        this.sanphamTen = sanphamTen;
        this.sanphamGia = sanphamGia;
        this.sanphamGiamGia = sanphamGiamGia;
        this.soluongSP = soluongSP;
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

    public int getSoluongSP() {
        return soluongSP;
    }

    public void setSoluongSP(int soluongSP) {
        this.soluongSP = soluongSP;
    }

    public int getSanphamId() {
        return sanphamId;
    }

    public void setSanphamId(int sanphamId) {
        this.sanphamId = sanphamId;
    }
}
