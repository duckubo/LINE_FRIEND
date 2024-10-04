package com.team5.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.team5.myapplication.FragmentGioiThieu;
import com.team5.myapplication.FragmentSanPhamHot;
import com.team5.myapplication.FragmentTinTuc;

public class viewTrangChu extends FragmentStateAdapter {
    public viewTrangChu(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch ( position) {
            case 0:
                return new FragmentGioiThieu();
            case 1:
                return new FragmentSanPhamHot();
            case 2:
                return new FragmentTinTuc() ;


            default:
                return new FragmentGioiThieu();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
