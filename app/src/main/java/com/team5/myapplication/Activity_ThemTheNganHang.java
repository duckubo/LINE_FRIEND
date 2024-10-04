package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity_ThemTheNganHang extends AppCompatActivity {

    ImageButton btnBack;

    ImageView imvVisa, imvMasterCard, imvJcb;

    EditText edtName, edtNumberCard, edtLoaiThe, edtNgayHetHan, edtDiaChi, edtMaBuuChinh;

    Button btnFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_the_ngan_hang);

        linkView();
        addEvent();
    }


    private void linkView() {
        btnBack = findViewById(R.id.btnBack);
        btnFinish = findViewById(R.id.btnFinish);

        imvVisa = findViewById(R.id.imvVisa);
        imvMasterCard = findViewById(R.id.imvMasterCard);
        imvJcb = findViewById(R.id.imvJcb);

        edtName = findViewById(R.id.edtName);
        edtNumberCard = findViewById(R.id.edtNumberCard);
        edtLoaiThe = findViewById(R.id.edtLoaiThe);
        edtNgayHetHan = findViewById(R.id.edtNgayHetHan);
        edtDiaChi = findViewById(R.id.edtDiaChi);
        edtMaBuuChinh = findViewById(R.id.edtMaBuuChinh);
    }
    private void addEvent() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThemTheNganHang.this, Activity_TaiKhoanNganHang.class));
            }
        });

        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0)
                    edtName.setError("Bạn chưa nhập tên tài khoản!");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //kiểm tra điều kiện cho Họ và tênn:
                String ten = edtName.getText() + "";
                ten = ten.trim();
                if (ten.length() < 3) {
                    edtName.requestFocus(); //để kiểm tra đủ điều kiện hay chưa
                    edtName.selectAll();
                    Toast.makeText(Activity_ThemTheNganHang.this, "Tên phải chứa từ 3 ký tự trở lên", Toast.LENGTH_SHORT).show();
                    return;
                }

                //kiểm tra điều kiện cho Số thẻ:
                String the = edtNumberCard.getText() + "";
                the = the.trim();
                if (the.length() != 16 ) {
                    edtNumberCard.requestFocus(); //để kiểm tra Số thẻ đủ điều kiện hay chưa
                    edtNumberCard.selectAll();
                    Toast.makeText(Activity_ThemTheNganHang.this, "Số thẻ phải chứa đúng 16 ký tự số!", Toast.LENGTH_SHORT).show();
                    return;
                }


                startActivity(new Intent(Activity_ThemTheNganHang.this, Activity_TaiKhoanNganHang.class));

            }

        });
    }
}