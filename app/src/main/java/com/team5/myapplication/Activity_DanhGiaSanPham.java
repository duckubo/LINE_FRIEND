package com.team5.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity_DanhGiaSanPham extends AppCompatActivity {
    Button btnDang;
    LinearLayout btnCamera, btnVideo;
    ImageView imvHinhDanhia;
    EditText edtDanhGia;
    BottomSheetDialog sheetDialog;
    LinearLayout sheetOpenCamera, sheetOpenGallery;
    ActivityResultLauncher<Intent> activityResultLauncher;
    boolean isCamera;
    MyDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_gia_san_pham);
        linkViews();
        addEvents();
        createBottomSheet();
        db= new MyDataBase(this );
        activityResultLauncher=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode()== RESULT_OK && result.getData() !=null ){
                    if(isCamera){
                    Bitmap bitmap=(Bitmap) result.getData().getExtras().get("data");
                    imvHinhDanhia.setImageBitmap(bitmap);
                    }else{
                        Uri uri=result.getData().getData();
                        if(uri !=null){
                            try {
                                InputStream inputStream= getContentResolver().openInputStream(uri);
                                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                                imvHinhDanhia.setImageBitmap(bitmap);

                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
    }


    private void linkViews() {
        btnDang=findViewById(R.id.btnDang);
        btnCamera=findViewById(R.id.btnCamera);
        edtDanhGia=findViewById(R.id.edtDanhGia);
        btnVideo=findViewById(R.id.btnVideo);
        edtDanhGia=findViewById(R.id.edtDanhGia);
        imvHinhDanhia=findViewById(R.id.imvHinhDanhia);
    }

    private void addEvents() {
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sheetDialog.show();
            }
        });
        btnDang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String des;
                des= edtDanhGia.getText().toString();
                if(!des.equals("")){
                    boolean flag= db.insertData(des, convertPhoto());
                    if(flag){
                        Toast.makeText(Activity_DanhGiaSanPham.this, "Success!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Activity_DanhGiaSanPham.this, Activity_ThongTinDonHang.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Activity_DanhGiaSanPham.this, "Fail!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            private byte[] convertPhoto() {
                BitmapDrawable drawable= (BitmapDrawable) imvHinhDanhia.getDrawable();
                Bitmap bitmap= drawable.getBitmap();
                ByteArrayOutputStream outputStream= new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
                return outputStream.toByteArray();
            }
        });

    }

    private void createBottomSheet() {
        if(sheetDialog == null){
            View view= LayoutInflater.from(this).inflate(R.layout.bottomsheet, null);
            sheetOpenCamera=view.findViewById(R.id.sheetOpenCamera);
            sheetOpenCamera.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();
                }
            });
            sheetOpenGallery=view.findViewById(R.id.sheetOpenGallery);
            sheetOpenGallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    activityResultLauncher.launch(intent);
                    sheetDialog.dismiss();

                }
            });
            sheetDialog= new BottomSheetDialog(this);
            sheetDialog.setContentView(view);
        }
    }


}