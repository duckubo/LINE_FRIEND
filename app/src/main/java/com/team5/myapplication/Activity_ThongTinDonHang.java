package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Activity_ThongTinDonHang extends AppCompatActivity {

    ImageView btnBack;
    Button btnLienHeShop, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_don_hang);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        btnBack = findViewById(R.id.btnBack);
        btnLienHeShop = findViewById(R.id.btnLienHeShop);
        btnAdd = findViewById(R.id.btnAdd);
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_ThongTinDonHang.this, Activity_TrangChu.class);
                startActivity(intent);
            }
        });
        btnLienHeShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThongTinDonHang.this, Activity_Chat.class));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThongTinDonHang.this, Activity_TatCaSanPham.class));
            }
        });
    }
}