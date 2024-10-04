package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import com.team5.adapter.SanPhamAdapter;
import com.team5.model.GioHang;
import com.team5.model.Product;
import com.team5.model.SanPham;

import java.util.ArrayList;

public class Activity_TatCaSanPham extends AppCompatActivity {

    GridView gvTatCaSanPham;
    ImageView imvBack;

    SanPhamAdapter adapter;
    ArrayList<SanPham> sanpham;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tat_ca_san_pham);

        linkViews();
        initData();
        initAdapter();
        addEvents();

    }

    private void linkViews() {
        gvTatCaSanPham = findViewById(R.id.gvTatCaSanPham);
        imvBack = findViewById(R.id.imvBack);


    }

    private void initData() {
        sanpham = new ArrayList<SanPham>();
        sanpham.add(new SanPham(1, R.drawable.mockhoagaubrown, "Móc khóa hình Gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(2, R.drawable.butbihinhtraitim, "Bút bi hình trái tim", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(3, R.drawable.gaubong, "Thú nhồi bông Gấu Brown", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(4, R.drawable.tuixach, "Túi xách thỏ Cony", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(5, R.drawable.mockhoatho, "Móc khóa hình Thỏ Cony", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(6, R.drawable.giadodt, "Giá đỡ điện thoại Thỏ Cony", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(7, R.drawable.mockhoavitvang, "Móc khóa hình vịt vàng", 50000, "Giảm 10000"));
        sanpham.add(new SanPham(8, R.drawable.gaubonghinhtraitim, "Thú nhồi bông hình trái tim", 50000, "Giảm 10000"));

    }

    private void initAdapter() {
        adapter = new SanPhamAdapter(Activity_TatCaSanPham.this, R.layout.item_list, sanpham);
        gvTatCaSanPham.setAdapter(adapter);
    }

    public void addEvents() {
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_TatCaSanPham.this, Activity_TrangChu.class);
                startActivity(intent);
            }
        });

        gvTatCaSanPham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Activity_DetailedProduct.class);
                intent.putExtra("thongtinsanpham", sanpham.get(i));
                startActivity(intent);
            }
        });
    }

}