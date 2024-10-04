package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Activity_TinTuc3 extends AppCompatActivity {

    LinearLayout TinTuc3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc3);

        TinTuc3 = findViewById(R.id.TinTuc2);
        TinTuc3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(Activity_TinTuc3.this, FragmentTinTuc.class);
                startActivity(intent);
                return true;
            }
        });
    }
}