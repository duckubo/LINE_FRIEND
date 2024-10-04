package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Activity_TaiKhoanNganHang extends AppCompatActivity {

    ImageButton btnBackPayment;
    Button btnAdd, btnMyCard, btnAddCard, btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tai_khoan_ngan_hang);

        linkViews();
        addEvent();
    }

    private void linkViews() {
        btnBackPayment = findViewById(R.id.btnBackPayment);
        btnAdd = findViewById(R.id.btnAdd);
        btnMyCard = findViewById(R.id.btnMyCard);
        btnAddCard = findViewById(R.id.btnAddCard);
        btnFinish = findViewById(R.id.btnFinish);
    }
    private void addEvent() {
        btnBackPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //quay lại màn hình Thanh Toán
                startActivity(new Intent(Activity_TaiKhoanNganHang.this, Activity_ThanhToan_HienThiThongtin.class));
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Thêm thẻ ghi nợ/tín dụng
                startActivity(new Intent(Activity_TaiKhoanNganHang.this, Activity_ThemTheNganHang.class));
            }
        });

        btnAddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //thêm tài ngoản ngân hàng
                startActivity(new Intent(Activity_TaiKhoanNganHang.this, Activity_ThemTheNganHang.class));
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //hoàn thành chọn hình thức thanh toán
                startActivity(new Intent(Activity_TaiKhoanNganHang.this, Activity_ChoLayHang.class));
            }
        });
    }
}