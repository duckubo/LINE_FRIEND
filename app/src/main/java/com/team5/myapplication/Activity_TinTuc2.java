package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Activity_TinTuc2 extends AppCompatActivity {
    LinearLayout TinTuc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc2);

        TinTuc2 = findViewById(R.id.TinTuc2);
        TinTuc2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Activity_TinTuc2.this, FragmentTinTuc.class);
                startActivity(intent);
                return true;
            }
        });
    }
}