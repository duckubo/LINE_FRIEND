package com.team5.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.team5.model.SanPham;
import com.team5.myapplication.Activity_Chat;
import com.team5.myapplication.Activity_DetailedProduct;
import com.team5.myapplication.Activity_LikedProducts;
import com.team5.myapplication.Activity_TatCaSanPham;
import com.team5.myapplication.Activity_TrangChu;
import com.team5.myapplication.FragmentGioiThieu;
import com.team5.myapplication.R;

import java.text.DecimalFormat;
import java.util.List;

public class SanPhamAdapter extends BaseAdapter {

    Context context;
    int item_layout;
    List<SanPham> sanpham;

    public SanPhamAdapter(Context context, int item_layout, List<SanPham> sanpham) {
        this.context = context;
        this.item_layout = item_layout;
        this.sanpham = sanpham;
    }


    @Override
    public int getCount() {
        return sanpham.size();
    }

    @Override
    public Object getItem(int i) {
        return sanpham.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null);
            holder.txtTenSanPham = view.findViewById(R.id.txtTenSanPham);
            holder.txtGia = view.findViewById(R.id.txtGia);
            holder.txtGiamGia = view.findViewById(R.id.txtGiamGia);
            holder.imvHinh = view.findViewById(R.id.imvHinh);
//            holder.imvYeuThich = view.findViewById(R.id.im);
//            holder.imvGioHang = view.findViewById(R.id.imvGioHang);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        SanPham s = sanpham.get(i);
        holder.txtTenSanPham.setText(s.getSanphamTen());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtGia.setText(decimalFormat.format(s.getSanphamGia()));
        holder.txtGiamGia.setText(s.getSanphamGiamGia());

        holder.imvHinh.setImageResource(s.getSanphamHinh());

//        holder.imvYeuThich.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //chuyển qua trang yêu thich
//            }
//        });

//        holder.imvGioHang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //chuyển qua trang giỏ hàng
//            }
//        });
        return view;
    }

    private static class ViewHolder {
        ImageView imvHinh, imvYeuThich, imvGioHang;
        TextView txtTenSanPham, txtGia, txtGiamGia;
    }
}
