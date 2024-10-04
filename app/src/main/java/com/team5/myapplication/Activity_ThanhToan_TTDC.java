package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class Activity_ThanhToan_TTDC extends AppCompatActivity {

    ImageView imvBack, imvSuaTTLH, imvSuaDC1, imvSuaDC2, imvBackCart;

    CheckBox chkThongTin;
    RadioButton radDiaChi1, radDiaChi2;

    LinearLayout btnThemDC;

    Button btnHinhThucVanChuyen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_ttdc);

        linkViews();
        addEvents();
    }

    private void linkViews() {
        imvBack = findViewById(R.id.imvBack);
        imvSuaTTLH = findViewById(R.id.imvSuaTTLH);
        imvSuaDC1 = findViewById(R.id.imvSuaDC1);
        imvSuaDC2 = findViewById(R.id.imvSuaDC2);
        imvBackCart = findViewById(R.id.imvBackCart);

        chkThongTin = findViewById(R.id.chkThongTin);
        radDiaChi1 = findViewById(R.id.radDiaChi1);
        radDiaChi2 = findViewById(R.id.radDiaChi2);

        btnThemDC = findViewById(R.id.btnThemDC);
        btnHinhThucVanChuyen = findViewById(R.id.btnHinhThucVanChuyen);
    }
    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_TTDC.this, Activity_GioHang.class));
            }
        });

        imvSuaDC1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_TTDC.this, Activity_frag_thanhtoan_chinhsuadonhang.class));
            }
        });

        imvSuaDC2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_TTDC.this, Activity_frag_thanhtoan_chinhsuadonhang.class));
            }
        });

        imvSuaTTLH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_TTDC.this, Activity_TaiKhoanCuaToi.class));
            }
        });

        btnThemDC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_TTDC.this, Activity_frag_thanhtoan_chinhsuadonhang.class));
            }
        });

        btnHinhThucVanChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_TTDC.this, Activity_VanChuyen.class));

            }
        });

        imvBackCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_TTDC.this, Activity_GioHang.class));
            }
        });
    }
}