package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_DaGiao extends AppCompatActivity {

    ImageView btnBack, btnSearch, imvHinh;
    TextView txtTenSanPham,txtChoXacNhan, txtChoLayHang, txtDangGiao, txtDaGiao, txtSumGia, txtSoLuong;
    Button btnDanhGia, btnMuaLai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_giao);
        linkViews();
        addEvent();
    }

    private void linkViews() {
        btnBack = findViewById(R.id.btnBack);
        btnSearch = findViewById(R.id.btnSearch);
        txtChoXacNhan = findViewById(R.id.txtChoXacNhan);
        txtChoLayHang = findViewById(R.id.txtChoLayHang);
        txtDangGiao = findViewById(R.id.txtDangGiao);
        txtDaGiao = findViewById(R.id.txtDaGiao);
        txtSumGia = findViewById(R.id.txtSumGia);
        txtSoLuong = findViewById(R.id.txtSoLuong);
        btnDanhGia = findViewById(R.id.btnDanhGia);
        btnMuaLai = findViewById(R.id.btnMuaLai);

        imvHinh =findViewById(R.id.imvHinh);
    }

    private void addEvent() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_TrangChu.class));
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_TimKiem.class));
            }
        });

        btnDanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_DanhGiaSanPham.class));
            }
        });

        btnMuaLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_TatCaSanPham.class));
            }
        });

        txtChoXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_ChoLayHang.class));
            }
        });

        txtChoLayHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_ChoLayHang.class));
            }
        });

        txtDangGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_DangGiao.class));
            }
        });

        txtDaGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DaGiao.this, Activity_DaGiao.class));
            }
        });
    }
}