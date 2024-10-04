package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class Activity_TinTuc1 extends AppCompatActivity {

    LinearLayout TinTuc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc1);

        TinTuc1 = findViewById(R.id.TinTuc1);
        TinTuc1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Activity_TinTuc1.this, FragmentTinTuc.class);
                startActivity(intent);
                return true;
            }
        });
    }
}