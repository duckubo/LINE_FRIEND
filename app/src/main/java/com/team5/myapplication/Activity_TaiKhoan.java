package com.team5.myapplication;

//import androidx.appcompat.app.ActionBar;
//import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//import android.app.Activity;
//import android.content.DialogInterface;
import android.content.Intent;
//import android.content.SharedPreferences;
//import android.content.res.Configuration;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Locale;

//import java.util.Locale;

public class Activity_TaiKhoan extends AppCompatActivity {
    LinearLayout btnDonHang, btnVoucher, btnThongBao;

    TableRow btnTaiKhoanCuaToi, btnDiaChi, btnTaiKhoanNganHang, btnDoiMatKhau,btnDoiNgonNgu;

    Button btnDangXuat;

    TextView txtXemThem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnTaiKhoanCuaToi = findViewById(R.id.btnTaiKhoanCuaToi);
        btnDiaChi = findViewById(R.id.btnDiaChi);
        btnTaiKhoanNganHang = findViewById(R.id.btnTaiKhoanNganHang);
        btnDoiMatKhau = findViewById(R.id.btnDoiMatKhau);
        btnDangXuat = findViewById(R.id.btnDangXuat);
        btnThongBao = findViewById(R.id.btnThongBao);
        btnVoucher = findViewById(R.id.btnVoucher);
        btnDonHang = findViewById(R.id.btnDonHang);
        txtXemThem = findViewById(R.id.txtXemThem);
        btnDoiNgonNgu=findViewById(R.id.btnDoiNgonNgu);
    }
    public void ganNgonNgu(String language){
        Locale locale= new Locale(language);
        Configuration config = new Configuration();
        config.locale= locale;
        getBaseContext().getResources().updateConfiguration(
                config,
                getBaseContext().getResources().getDisplayMetrics()
        );
        Intent intent= new Intent(Activity_TaiKhoan.this,Activity_TaiKhoan.class);
        startActivity(intent);
    }
    private void addEvents() {
        btnTaiKhoanCuaToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Activity_TaiKhoanCuaToi.class);
                startActivity(intent);
            }
        });
        btnDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Activity_DiaChi.class);
                startActivity(intent);
            }
        });

        btnTaiKhoanNganHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Activity_TaiKhoanNganHang.class);
                startActivity(intent);
            }
        });
        btnDoiMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Activity_DoiMatKhau.class);
                startActivity(intent);
            }
        });
        btnDoiNgonNgu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Activity_DoiNgonNgu.class);
                startActivity(intent);
            }
        });
        btnDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Activity_DangGiao.class);
                startActivity(intent);
            }
        });
        btnThongBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Fragment_TaiKhoan_ThongBao.class);
                startActivity(intent);

            }
        });
        btnVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Fragment_TaiKhoan_Voucher.class);
                startActivity(intent);

            }
        });
        txtXemThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Activity_TatCaSanPham.class);
                startActivity(intent);
            }
        });
        btnDangXuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_TaiKhoan.this, Login.class);
                startActivity(intent);

            }
        });

    }

    public void trangchu(MenuItem item) {
        Intent intent = new Intent(Activity_TaiKhoan.this, com.team5.myapplication.Activity_TrangChu.class);
        startActivity(intent);
    }

    public void yeuthich(MenuItem item) {
        Intent intent = new Intent(Activity_TaiKhoan.this, com.team5.myapplication.Activity_LikedProducts.class);
        startActivity(intent);
    }

    public void muasam(MenuItem item) {
        Intent intent = new Intent(Activity_TaiKhoan.this, com.team5.myapplication.Activity_GioHang.class);
        startActivity(intent);
    }

    public void timkiem(MenuItem item) {
        Intent intent = new Intent(Activity_TaiKhoan.this, com.team5.myapplication.Activity_TimKiem.class);
        startActivity(intent);
    }

    public void taikhoan(MenuItem item) {
        Intent intent = new Intent(Activity_TaiKhoan.this, com.team5.myapplication.Activity_TaiKhoan.class);
        startActivity(intent);
    }
}

