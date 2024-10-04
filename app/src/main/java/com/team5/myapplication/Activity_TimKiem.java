package com.team5.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toolbar;


import com.team5.adapter.SanPhamAdapter;
import com.team5.model.SanPham;

import java.text.DecimalFormat;
import com.team5.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class Activity_TimKiem extends AppCompatActivity {

    GridView gvSearch;
    CustomAdapter customAdapter;

    int[] sanphamId = {1 ,2,2,4,5,6,7,8};
    int[] sanphamHinhs = {R.drawable.mockhoagaubrown,R.drawable.butbihinhtraitim, R.drawable.gaubong, R.drawable.tuixach,
            R.drawable.mockhoatho, R.drawable.giadodt, R.drawable.mockhoavitvang, R.drawable.gaubonghinhtraitim};
    String[] sanphamTens = {"Móc khóa hình Gấu Brown", "Bút bi hình trái tim", "Thú nhồi bông Gấu Brown", "Túi xách thỏ Cony",
            "Móc khóa hình Thỏ Cony", "Giá đỡ điện thoại Thỏ Cony", "Móc khóa hình vịt vàng", "Thú nhồi bông hình trái tim"};
    double[] sanphamGia = { 50000, 50000,  50000, 50000, 50000,50000, 50000, 50000};
    String[] sanphamGiamGia = {"Giảm 10000", "Giảm 10000", "Giảm 10000","Giảm 10000","Giảm 10000","Giảm 10000","Giảm 10000","Giảm 10000"};

    List<SanPham> sanPhamList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);

        gvSearch = findViewById(R.id.gvSearch);

        for(int i = 0; i < sanphamTens.length; i++ ){
            SanPham sanPham = new SanPham(sanphamId[i], sanphamHinhs[i], sanphamTens[i], sanphamGia[i], sanphamGiamGia[i]);
            sanPhamList.add(sanPham);
        }

        customAdapter = new CustomAdapter(sanPhamList, this);

        gvSearch.setAdapter(customAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.btnSearch);
        SearchView btnSearch = (SearchView) menuItem.getActionView();
        btnSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapter.getFilter().filter(newText);
                return true;
            }
        });

        //open camera
        if( ContextCompat.checkSelfPermission(Activity_TimKiem.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Activity_TimKiem.this, new String[]{Manifest.permission.CAMERA}, 101);

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.btnSearch){
            return  true;
        } else if( id == R.id.btnBack){
            startActivity(new Intent(Activity_TimKiem.this, Activity_TrangChu.class));
        } else if( id == R.id.btnSearchCamera){
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 101);
        }
        return super.onOptionsItemSelected(item);

    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<SanPham> sanPhamList;
        private List<SanPham> sanphamListFiltered;
        private Context context;

        public CustomAdapter(List<SanPham> sanPhamList, Context context) {
            this.sanPhamList = sanPhamList;
            this.sanphamListFiltered = sanPhamList;
            this.context = context;
        }

        @Override
        public int getCount() {
            return sanphamListFiltered.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.item_list_search, null);
            ImageView imvHinh = view.findViewById(R.id.imvHinh);
            TextView txtTenSanPham = view.findViewById(R.id.txtTenSanPham);
            TextView txtGia = view.findViewById(R.id.txtGia);
            TextView txtGiamGia = view.findViewById(R.id.txtGiamGia);

            imvHinh.setImageResource(sanphamListFiltered.get(position).getSanphamHinh());
            txtTenSanPham.setText(sanphamListFiltered.get(position).getSanphamTen());

            txtGiamGia.setText(sanphamListFiltered.get(position).getSanphamGiamGia());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Activity_TimKiem.this, Activity_DetailedProduct.class).putExtra("thongtinsanpham", sanphamListFiltered.get(position)));
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if(constraint == null || constraint.length() == 0){
                        filterResults.count = sanPhamList.size();
                        filterResults.values = sanPhamList;
                    }else {
                        String searchCtr = constraint.toString().toLowerCase();
                        List<SanPham> resultData = new ArrayList<>();
                        for(SanPham sanPham: sanPhamList){
                            if(sanPham.getSanphamTen().contains(searchCtr)){
                                resultData.add(sanPham);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }
                    return null;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {

                    sanphamListFiltered = (List<SanPham>) results.values;
                    notifyDataSetChanged();
                }
            };
            return null;
        }
    }
    public void trangchu(MenuItem item) {
        Intent intent = new Intent(Activity_TimKiem.this, com.team5.myapplication.Activity_TrangChu.class);
        startActivity(intent);
    }

    public void yeuthich(MenuItem item) {
        Intent intent = new Intent(Activity_TimKiem.this, com.team5.myapplication.Activity_LikedProducts.class);
        startActivity(intent);
    }

    public void muasam(MenuItem item) {
        Intent intent = new Intent(Activity_TimKiem.this, com.team5.myapplication.Activity_GioHang.class);
        startActivity(intent);
    }

    public void timkiem(MenuItem item) {
        Intent intent = new Intent(Activity_TimKiem.this, com.team5.myapplication.Activity_TimKiem.class);
        startActivity(intent);
    }

    public void taikhoan(MenuItem item) {
        Intent intent = new Intent(Activity_TimKiem.this, com.team5.myapplication.Activity_TaiKhoan.class);
        startActivity(intent);
    }
}