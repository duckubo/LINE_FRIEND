package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.team5.adapter.viewTrangChu;
import com.team5.model.GioHang;

import java.util.ArrayList;

public class Activity_TrangChu extends AppCompatActivity {

    ImageView imvChat, imvGioHang;

    private TabLayout mTabLayouttrangchu;
    private ViewPager2 mViewPagertrangchu;

    private com.team5.adapter.viewTrangChu viewTrangChu;
    public static ArrayList<GioHang> mangGioHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        mTabLayouttrangchu = findViewById(R.id.tab_layouttrangchu);
        mViewPagertrangchu = findViewById(R.id.View_pagertrangchu);

        viewTrangChu = new viewTrangChu(this);
        mViewPagertrangchu.setAdapter(viewTrangChu);

        new TabLayoutMediator(mTabLayouttrangchu, mViewPagertrangchu, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Trang chủ");
                    break;

                case 1:
                    tab.setText("Sản phẩm hot");
                    break;

                case 2:
                    tab.setText("Tin tức");
                    break;
            }
        }).attach();

        linkViews();
        addEvents();

    }

    private void linkViews() {
        imvChat = findViewById(R.id.imvChat);
        imvGioHang = findViewById(R.id.imvGioHang);
        if(mangGioHang != null){

        }else {
            mangGioHang = new ArrayList<>();
        }
    }

    private void addEvents() {
        imvChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_TrangChu.this, Activity_Chat.class);
                startActivity(intent);
            }
        });

        imvGioHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_TrangChu.this, Activity_GioHang.class);
                startActivity(intent);
            }
        });

    }

    public void trangchu(MenuItem item) {
        Intent intent = new Intent(com.team5.myapplication.Activity_TrangChu.this, com.team5.myapplication.Activity_TrangChu.class);
        startActivity(intent);
    }

    public void yeuthich(MenuItem item) {
        Intent intent = new Intent(com.team5.myapplication.Activity_TrangChu.this, com.team5.myapplication.Activity_LikedProducts.class);
        startActivity(intent);
    }

    public void muasam(MenuItem item) {
        Intent intent = new Intent(com.team5.myapplication.Activity_TrangChu.this, com.team5.myapplication.Activity_GioHang.class);
        startActivity(intent);
    }

    public void timkiem(MenuItem item) {
        Intent intent = new Intent(com.team5.myapplication.Activity_TrangChu.this, com.team5.myapplication.Activity_TimKiem.class);
        startActivity(intent);
    }

    public void taikhoan(MenuItem item) {
        Intent intent = new Intent(com.team5.myapplication.Activity_TrangChu.this, com.team5.myapplication.Activity_TaiKhoan.class);
        startActivity(intent);
    }



}