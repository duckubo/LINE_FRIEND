package com.team5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.team5.model.SanPham;
import com.team5.model.TinTuc;
import com.team5.myapplication.R;

import java.util.List;

public class TinTucAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    List<TinTuc> tintuc;

    public TinTucAdapter(Context context, int item_layout, List<TinTuc> tintuc) {
        this.context = context;
        this.item_layout = item_layout;
        this.tintuc = tintuc;
    }

    @Override
    public int getCount() {
        return tintuc.size();
    }

    @Override
    public Object getItem(int i) {
        return tintuc.get(i);
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
            holder.txtTitle = view.findViewById(R.id.txtTitle);
            holder.txtDate = view.findViewById(R.id.txtDate);
            holder.imvTinTuc = view.findViewById(R.id.imvTinTuc);

            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        TinTuc t = tintuc.get(i);
        holder.txtTitle.setText(t.getTintucTen());
        holder.txtDate.setText(t.getTintucNgay());

        holder.imvTinTuc.setImageResource(t.getTintucHinh());
        return view;
    }
    private static class ViewHolder {
        ImageView imvTinTuc;
        TextView txtTitle, txtDate;
    }
}
