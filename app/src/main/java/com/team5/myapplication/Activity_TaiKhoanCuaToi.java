package com.team5.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Activity_TaiKhoanCuaToi extends AppCompatActivity {

    EditText edtTen,edtEmail,edtGioiTinh,edtNgaySinh,edtSoDienThoai;
    Button btnLuuThayDoi;
    ImageView imvHinhDaiDien,imvLich,imvBack;
    TextView txtTenTaiKhoan;
    DatabaseHelper_TaiKhoan db;
    BottomSheetDialog sheetDialog=null;
    LinearLayout sheetOpenCamera, sheetOpenGallery;
    ActivityResultLauncher<Intent> activityResultLauncher;
    boolean isCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_taikhoan_taikhoancuatoi);
        linkViews();
        addEvents();
        createBottomSheet();
        db=new DatabaseHelper_TaiKhoan(this);
        activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                    if (isCamera){
                        Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                        imvHinhDaiDien.setImageBitmap(bitmap);
                    } else {
                        Uri uri = result.getData().getData();
                        if (uri != null)
                            try {
                                InputStream inputStream = getContentResolver().openInputStream(uri);
                                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                                imvHinhDaiDien.setImageBitmap(bitmap);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                    }

                }
            }
        });
    }

    private void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(Activity_TaiKhoanCuaToi.this, Activity_TaiKhoan.class));
            }
        });
        //insert data
        imvHinhDaiDien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sheetDialog.show();
            }
        });

        btnLuuThayDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert data
                String Ten, Email, GioiTinh, NgaySinh, SoDienThoai;
                Ten = edtTen.getText().toString();
                Email = edtEmail.getText().toString();
                GioiTinh= edtGioiTinh.getText().toString();
                NgaySinh = edtNgaySinh.getText().toString();
                SoDienThoai= edtSoDienThoai.getText().toString();

                Boolean checkinsertdata=db.insertData(Ten,Email,GioiTinh,NgaySinh,SoDienThoai);

                if (checkinsertdata==true) {
                        Toast.makeText(Activity_TaiKhoanCuaToi.this, "Success!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Activity_TaiKhoanCuaToi.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                txtTenTaiKhoan.setText(edtTen.getText().toString());
                }

            });
        //Chon ngay sinh
        imvLich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonNgay();
            }
        });
    }
    private void ChonNgay(){
        Calendar calendar=Calendar.getInstance();
        int ngay=calendar.get(Calendar.DATE);
        int thang=calendar.get(Calendar.MONTH);
        int nam=calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year,month,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
                edtNgaySinh.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },2021,12,20);
        datePickerDialog.show();
    }


    private void linkViews() {
        edtTen=findViewById(R.id.edtTen);
        edtEmail=findViewById(R.id.edtEmail);
        edtGioiTinh=findViewById(R.id.edtGioiTinh);
        edtNgaySinh=findViewById(R.id.edtNgaySinh);
        edtSoDienThoai=findViewById(R.id.edtSoDienThoai);
        btnLuuThayDoi=findViewById(R.id.btnLuuThayDoi);
        txtTenTaiKhoan=findViewById(R.id.txtTenTaiKhoan);
        imvHinhDaiDien=findViewById(R.id.imvHinhDaiDien);
        imvLich=findViewById(R.id.imvLich);
        imvBack=findViewById(R.id.imvBack);

    }
    private void createBottomSheet() {
        if(sheetDialog == null){
            View view = LayoutInflater.from(this).inflate(R.layout.bottomsheet, null);
            sheetOpenCamera = view.findViewById(R.id.sheetOpenCamera);
            sheetOpenCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Mở
                    isCamera = true;
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();
                }
            });
            sheetOpenGallery = view.findViewById(R.id.sheetOpenGallery);
            sheetOpenGallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Mở thư viện ảnh
                    isCamera=false;
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();
                }
            });
            sheetDialog = new BottomSheetDialog(this);
            sheetDialog.setContentView(view);


        }
    }
    private byte[] convertPhoto() {
        BitmapDrawable drawable= (BitmapDrawable) imvHinhDaiDien.getDrawable();
        Bitmap bitmap=drawable.getBitmap();
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, outputStream);
        return outputStream.toByteArray();
    }
}