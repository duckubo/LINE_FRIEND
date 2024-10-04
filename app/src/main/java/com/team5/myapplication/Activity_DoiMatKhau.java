
package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_DoiMatKhau extends AppCompatActivity {

    EditText edtMKCu,edtMKMoi,edtNhapLaiMKMoi;
    Button btnLuuMK;
    ImageButton btnBack;
    TextView txtQuenMK;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        linkViews();
        addEvents();
    }

    private void linkViews() {
        edtMKCu=findViewById(R.id.edtMKCu);
        edtMKMoi=findViewById(R.id.edtMKMoi);
        edtNhapLaiMKMoi=findViewById(R.id.edtNhapLaiMKMoi);
        btnLuuMK=findViewById(R.id.btnLuuMK);
        btnBack=findViewById(R.id.btnBack);
        txtQuenMK=findViewById(R.id.txtQuenMK);
        myDB= new DBHelper(this);
    }
    private void addEvents() {
        btnLuuMK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password=edtMKCu.getText().toString();
                String MKMoi=edtMKMoi.getText().toString();
                String NhapLaiMKMoi=edtNhapLaiMKMoi.getText().toString();
                Boolean checkpassword=myDB.checkuserpassword(password);
                if (checkpassword)
                {
                    if (MKMoi.equals(NhapLaiMKMoi))
                    {
                        Boolean checkpasswordupdate = myDB.updatenewpassword(MKMoi);
                        if (checkpasswordupdate == true)
                        {
                            Toast.makeText(Activity_DoiMatKhau.this, "Password Updated Success", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(Activity_DoiMatKhau.this, "Mật khẩu không trùng nhau", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Activity_DoiMatKhau.this, "Sai mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_DoiMatKhau.this, Activity_TaiKhoan.class));
            }
        });
    }
}