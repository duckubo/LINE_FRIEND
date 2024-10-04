package com.team5.adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.team5.model.GioHang;
import com.team5.myapplication.Activity_GioHang;
import com.team5.myapplication.Activity_TatCaSanPham;
import com.team5.myapplication.Activity_TrangChu;
import com.team5.myapplication.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GioHangAdapter extends BaseAdapter {

    Context context;
    ArrayList<GioHang> gioHangs;

    public GioHangAdapter(Context context, ArrayList<GioHang> gioHangs) {
        this.context = context;
        this.gioHangs = gioHangs;
    }

    @Override
    public int getCount() {
        return gioHangs.size();
    }

    @Override
    public Object getItem(int i) {
        return gioHangs.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public class ViewHolder{

        public ImageView imvHinh;
        public TextView  txtTenSanPham,txtGia, txtGiamGia, btnSoLuong;
        public Button btnGiam, btnTang;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_giohang, null);

            viewHolder.imvHinh = view.findViewById(R.id.imvHinh);
            viewHolder.txtTenSanPham = view.findViewById(R.id.txtTenSanPham);
            viewHolder.txtGia = view.findViewById(R.id.txtGia);
            viewHolder.txtGiamGia = view.findViewById(R.id.txtGiamGia);
            viewHolder.btnSoLuong = view.findViewById(R.id.btnSoLuong);
            viewHolder.btnGiam = view.findViewById(R.id.btnGiam);
            viewHolder.btnTang = view.findViewById(R.id.btnTang);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        GioHang gioHang = (GioHang) getItem(i);

        viewHolder.imvHinh.setImageResource(gioHang.getSanphamHinh());
        viewHolder.txtTenSanPham.setText(gioHang.getSanphamTen());

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGia.setText(decimalFormat.format(gioHang.getSanphamGia()) + "Đ");
        viewHolder.txtGiamGia.setText(gioHang.getSanphamGiamGia());
        viewHolder.btnSoLuong.setText(gioHang.getSoluongSP() + "");

        int sl = Integer.parseInt(viewHolder.btnSoLuong.getText().toString());
        if (sl >= 10){
            viewHolder.btnTang.setVisibility(View.INVISIBLE);
            viewHolder.btnGiam.setVisibility(View.VISIBLE);
        }else  if(sl <= 1){
            viewHolder.btnGiam.setVisibility(View.INVISIBLE);
        } else if (sl >=1 ){
            viewHolder.btnGiam.setVisibility(View.VISIBLE);
            viewHolder.btnTang.setVisibility(View.VISIBLE);
        }

        ViewHolder finalViewHolder = viewHolder;
        viewHolder.btnTang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoinhat = Integer.parseInt(finalViewHolder.btnSoLuong.getText().toString()) +1;
                int slhientai = Activity_TrangChu.mangGioHang.get(i).getSoluongSP();
                long giaht = (long) Activity_TrangChu.mangGioHang.get(i).getSanphamGia();

                Activity_TrangChu.mangGioHang.get(i).setSoluongSP(slmoinhat);
                long giamoinhat = (giaht * slmoinhat) / slhientai;
                Activity_TrangChu.mangGioHang.get(i).setSanphamGia(giamoinhat);

                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtGia.setText(decimalFormat.format(giamoinhat) + "Đ");

                //gọi lại sumgia
                Activity_GioHang.getData();
                if(slmoinhat > 9){
                    finalViewHolder.btnTang.setVisibility(View.INVISIBLE);
                    finalViewHolder.btnGiam.setVisibility(View.VISIBLE);
                    finalViewHolder.btnSoLuong.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder.btnGiam.setVisibility(View.VISIBLE);
                    finalViewHolder.btnTang.setVisibility(View.VISIBLE);
                    finalViewHolder.btnSoLuong.setText(String.valueOf(slmoinhat));
                }
            }
        });

        viewHolder.btnGiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int slmoinhat = Integer.parseInt(finalViewHolder.btnSoLuong.getText().toString()) -1;
                int slhientai = Activity_TrangChu.mangGioHang.get(i).getSoluongSP();
                long giaht = (long) Activity_TrangChu.mangGioHang.get(i).getSanphamGia();

                Activity_TrangChu.mangGioHang.get(i).setSoluongSP(slmoinhat);
                long giamoinhat = (giaht * slmoinhat) / slhientai;
                Activity_TrangChu.mangGioHang.get(i).setSanphamGia(giamoinhat);

                DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
                finalViewHolder.txtGia.setText(decimalFormat.format(giamoinhat) + "Đ");

                //gọi lại sumgia
                Activity_GioHang.getData();
                if(slmoinhat < 2){
                    finalViewHolder.btnGiam.setVisibility(View.INVISIBLE);
                    finalViewHolder.btnTang.setVisibility(View.VISIBLE);
                    finalViewHolder.btnSoLuong.setText(String.valueOf(slmoinhat));
                }else {
                    finalViewHolder.btnGiam.setVisibility(View.VISIBLE);
                    finalViewHolder.btnTang.setVisibility(View.VISIBLE);
                    finalViewHolder.btnSoLuong.setText(String.valueOf(slmoinhat));
                }
            }
        });

        return view;
    }
}
