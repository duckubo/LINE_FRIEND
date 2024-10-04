package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_ThanhToan_HienThiThongtin extends AppCompatActivity {

    ImageView imvBack, imvGioHang, imvDown;

    ImageButton btnBackVanChuyen;

    TextView txtSumGia, txtDoiSdt, txtDoiDiaChi, txtDoiHinhThucGiaoHang;

    Button btnThanhToan;

    RadioButton radCod, radCredit, radMomo, radDiaChi, radThemDiaChi;
    RadioGroup radPayment, radDiaChiNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan_hien_thi_thongtin);

        linkView();
        addEvent();
    }

    private void linkView() {
        imvBack = findViewById(R.id.imvBack);
        imvGioHang = findViewById(R.id.imvGioHang);
        imvDown = findViewById(R.id.imvDown);

        btnBackVanChuyen = findViewById(R.id.btnBackVanChuyen);

        txtSumGia = findViewById(R.id.txtSumGia);;
        txtDoiSdt = findViewById(R.id.txtDoiSdt);
        txtDoiDiaChi = findViewById(R.id.txtDoiDiaChi);
        txtDoiHinhThucGiaoHang = findViewById(R.id.txtDoiHinhThucGiaoHang);

        btnThanhToan = findViewById(R.id.btnThanhToan);

        radPayment = findViewById(R.id.radPayment);
        radDiaChiNhan = findViewById(R.id.radDiaChiNhan);
        radCod = findViewById(R.id.radCod);
        radCredit = findViewById(R.id.radCredit);
        radMomo = findViewById(R.id.radMomo);
        radDiaChi = findViewById(R.id.radDiaChi);
        radThemDiaChi = findViewById(R.id.radThemDiaChi);
    }

    private void addEvent() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_VanChuyen.class));
            }
        });

        txtDoiSdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_DiaChi.class));
            }
        });

        txtDoiDiaChi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_DiaChi.class));
            }
        });

        txtDoiHinhThucGiaoHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_VanChuyen.class));
            }
        });

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radCod.isChecked())
                    startActivity(new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_ChoXacNhan.class));
                else if (radCredit.isChecked())
                    startActivity(new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_TaiKhoanNganHang.class));
                else if (radMomo.isChecked())
                    startActivity(new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_ThanhToan_Momo.class));
                else
                    Toast.makeText(getApplication(), "Bạn chưa chọn phương thức thanh toán", Toast.LENGTH_SHORT).show();

//                if (radThemDiaChi.isChecked())
//                     startActivity(new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_frag_thanhtoan_chinhsuadonhang.class));
//                else if (radDiaChi.isChecked())
//                    Toast.makeText(getApplication(), "Bạn đã chọn địa chỉ thanh toán!", Toast.LENGTH_SHORT).show();


            }
        });

        btnBackVanChuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_VanChuyen.class));
            }
        });
//        btnBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Activity_ThanhToan_HienThiThongtin.this, Activity_VanChuyen.class);
//                startActivity(intent);
//            }
//        });

    }
}