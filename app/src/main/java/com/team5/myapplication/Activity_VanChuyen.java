package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_VanChuyen extends AppCompatActivity {

    ImageView imvBackDonHang, imvBackDonHang2;
    Button btnThanhToan;
    TextView txtLienHe, txtDiaChi;
    RadioGroup radVanChuyen;
    RadioButton radVCNhanh, radVCSieuToc, radVCTieuChuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_chuyen);

        linkViews();
        addEvents();
    }
    private void linkViews() {
        imvBackDonHang = findViewById(R.id.imvBackDonHang);
        imvBackDonHang2 = findViewById(R.id.imvBackDonHang2);

        btnThanhToan = findViewById(R.id.btnThanhToan);

        txtLienHe = findViewById(R.id.txtLienHe);
        txtDiaChi = findViewById(R.id.txtDiaChi);

        radVanChuyen = findViewById(R.id.radVanChuyen);
        radVCNhanh = findViewById(R.id.radVCNhanh);
        radVCSieuToc = findViewById(R.id.radVCSieuToc);
        radVCTieuChuan = findViewById(R.id.radVCTieuChuan);

        radVCNhanh.setChecked(true);
    }

    private void addEvents() {
        imvBackDonHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_VanChuyen.this, Activity_GioHang.class));
            }
        });

        imvBackDonHang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_VanChuyen.this, Activity_GioHang.class));
            }
        });

        txtLienHe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_VanChuyen.this, Activity_DiaChi.class));
            }
        });

        txtDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_VanChuyen.this, Activity_DiaChi.class));
            }
        });

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedId = radVanChuyen.getCheckedRadioButtonId();
                //kiểm tra xem RadioButton đã được checked hay chưa?
                if (radVCNhanh.isChecked())
                    Toast.makeText(getApplication(), "Bạn đã chọn hình thức vận chuyển nhanh", Toast.LENGTH_SHORT).show();
                else if (radVCSieuToc.isChecked())
                    Toast.makeText(getApplication(), "Bạn đã chọn hình thức vận chuyển siêu tốc", Toast.LENGTH_SHORT).show();
                else if (radVCTieuChuan.isChecked())
                    Toast.makeText(getApplication(), "Bạn đã chọn hình thức vận chuyển tiêu chuẩn", Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Activity_VanChuyen.this, Activity_ThanhToan_HienThiThongtin.class));
            }
        });
    }

}