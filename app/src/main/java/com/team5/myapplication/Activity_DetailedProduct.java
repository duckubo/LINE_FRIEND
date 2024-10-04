package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.team5.adapter.SanPhamAdapter;
import com.team5.model.GioHang;
import com.team5.model.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Activity_DetailedProduct extends AppCompatActivity {

    GridView gvSanPham;
    ImageView imvHinh;
    TextView txtTenSanPham, txtGia, txtGiamGia;

    Button btnThemGioHang, btnMuaHang, btnAddLikedProduct;

    Spinner spPhanLoai, spSoLuong;
        ArrayList<String> phanloai;
    ArrayAdapter<String> adapter;

    ArrayList<SanPham> sanpham;
    SanPhamAdapter sanPhamAdapter;

    int id = 0;
    String tensanpham = "";
    double giasanpham = 0;
    String giamgia = "";
    int hinhanh = 0;
    int sanphamId = 0;

    SanPham sanPham;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_product);
        linkViews();
        initData();
        loadData();
        getData();
        addEvents();

    }

    private void linkViews() {
        spPhanLoai = findViewById(R.id.spPhanLoai);
        spSoLuong = findViewById(R.id.spSoLuong);
        gvSanPham = findViewById(R.id.gvSanPham);

        imvHinh = findViewById(R.id.imvHinh);

        txtGia = findViewById(R.id.txtGia);
        txtGiamGia = findViewById(R.id.txtGiamGia);
        txtTenSanPham = findViewById(R.id.txtTenSanPham);

        btnMuaHang = findViewById(R.id.btnMuaHang);
        btnThemGioHang = findViewById(R.id.btnThemGioHang);
        btnAddLikedProduct = findViewById(R.id.btnAddLikedProduct);

    }

    public void getData() {
//
//        String tensanpham = "";
//        double giasanpham = 0;
//        String giamgia = "";
//        int hinhanh = 0;

        SanPham sanPham = (SanPham) getIntent().getSerializableExtra("thongtinsanpham");

        id = sanPham.getId();
        tensanpham = sanPham.getSanphamTen();
        giasanpham = sanPham.getSanphamGia();
        giamgia = sanPham.getSanphamGiamGia();
        hinhanh = sanPham.getSanphamHinh();
        sanphamId = sanPham.getSanphamId();
        Intent intent = getIntent();


        txtTenSanPham.setText(tensanpham);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        txtGia.setText(decimalFormat.format(giasanpham));
        txtGiamGia.setText(giamgia);
        imvHinh.setImageResource(hinhanh);


    }

    private void initData() {
        sanpham = new ArrayList<SanPham>();
        sanpham.add(new SanPham(1, R.drawable.mockhoagaubrown, "Móc khóa hình Gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(2, R.drawable.butbihinhtraitim, "Bút bi hình trái tim", 50000, "Giảm 10000"));

        phanloai = new ArrayList<String>();
        phanloai.add("Size lớn");
        phanloai.add("Size vừa");
        phanloai.add("Size nhỏ");

        //spinner
        Integer[] soluong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        ArrayAdapter<Integer> soluongAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, soluong);
        spSoLuong.setAdapter(soluongAdapter);

        String[] phanloai = new String[]{"Size lớn", "Size vừa", "Size nhỏ"};
        ArrayAdapter<String> phanloaiAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, phanloai);
        spPhanLoai.setAdapter(phanloaiAdapter);


    }

    private void loadData() {
        sanPhamAdapter = new SanPhamAdapter(Activity_DetailedProduct.this, R.layout.item_list, sanpham);
        gvSanPham.setAdapter(sanPhamAdapter);
    }

    private void addEvents() {

        btnThemGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_TatCaSanPham.class);
                startActivity(intent);
            }
        });

        btnMuaHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( Activity_TrangChu.mangGioHang.size() > 0){
                    int sl = Integer.parseInt(spSoLuong.getSelectedItem().toString());
                    boolean exists = false;
                    for (int i = 0; i < Activity_TrangChu.mangGioHang.size(); i++){
                        if( Activity_TrangChu.mangGioHang.get(i).getId() == id){
                            Activity_TrangChu.mangGioHang.get(i).setSoluongSP(Activity_TrangChu.mangGioHang.get(i).getSoluongSP() + sl);
                            if (Activity_TrangChu.mangGioHang.get(i).getSoluongSP() >= 10){
                                Activity_TrangChu.mangGioHang.get(i).setSoluongSP(10);
                            }
                            Activity_TrangChu.mangGioHang.get(i).setSanphamGia(giasanpham * Activity_TrangChu.mangGioHang.get(i).getSoluongSP());
                            exists = true;
                        }
                    }
                    if( exists == false){
                        int soluong = Integer.parseInt(spSoLuong.getSelectedItem().toString());
                        long giaMoi = (long) (soluong * giasanpham);
                        Activity_TrangChu.mangGioHang.add(new GioHang(id, hinhanh, tensanpham, giaMoi, giamgia, soluong));
                    }
                }else {
                    int soluong = Integer.parseInt(spSoLuong.getSelectedItem().toString());
                    long giaMoi = (long) (soluong * giasanpham);
                    Activity_TrangChu.mangGioHang.add(new GioHang(id, hinhanh, tensanpham, giaMoi, giamgia, soluong));
                }
                Intent intent = new Intent(getApplicationContext(), Activity_GioHang.class);
                startActivity(intent);
            }
        });
        btnAddLikedProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentGioiThieu.sanpham.add(new SanPham(hinhanh, tensanpham, giasanpham, giamgia));
                Intent intent = new Intent(Activity_DetailedProduct.this, Activity_LikedProducts.class);
                startActivity(intent);
            }
        });
    }
}