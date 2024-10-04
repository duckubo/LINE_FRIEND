package com.team5.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.team5.adapter.SanPhamAdapter;
import com.team5.adapter.TinTucAdapter;
import com.team5.model.SanPham;
import com.team5.model.TinTuc;

import java.util.ArrayList;

public class FragmentTinTuc extends Fragment {
    ListView lvTinTuc;

    TinTucAdapter adapter;
    ArrayList<TinTuc> tintuc;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_tin_tuc, container, false);

        lvTinTuc = view.findViewById(R.id.lvTinTuc);

        adapter = new TinTucAdapter(getContext(), R.layout.tintuc_list, iniData());
        lvTinTuc.setAdapter(adapter);
        lvTinTuc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Intent intent = new Intent(getActivity(), Activity_TinTuc1.class);
                    startActivity(intent);
                } else if(i == 1) {
                    Intent intent = new Intent(getActivity(), Activity_TinTuc2.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getActivity(), Activity_TinTuc3.class);
                    startActivity(intent);
                }

            }
        });

        return view;


    }

    private ArrayList<TinTuc> iniData() {
        tintuc = new ArrayList<>();
        tintuc.add(new TinTuc(R.drawable.tintuc1, "Các sản phẩm gấu bông phụ kiện được yêu thích nhất hiện nay", "26/12/2021"));
        tintuc.add(new TinTuc(R.drawable.tintuc2, "Ra mắt bộ sưu tập gấu bông BT21 với nhiều mẫu mã đẹp", "24/12/2021"));
        tintuc.add(new TinTuc(R.drawable.tintuc3, "Ra mắt bộ sưu tập gấu bông BT21 Rainbow cực xinh", "22/12/2021"));

        return tintuc;
    }
}
