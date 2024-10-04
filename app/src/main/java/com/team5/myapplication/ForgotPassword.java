package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class ForgotPassword extends AppCompatActivity {
EditText edtName;
Button btnContinue;
ImageButton btnBack;
DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        linkView();
        addEvent();
    }

    private void linkView() {
        edtName=findViewById(R.id.edtName);
        btnContinue=findViewById(R.id.btnContinue);
        btnBack=findViewById(R.id.btnBack);
        myDB=new DBHelper(this);
    }

    private void addEvent() {
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user= edtName.getText().toString();
                Boolean checkuser= myDB.checkusername(user);
                if(checkuser==true)
                {
                    Intent intent= new Intent(getApplicationContext(), ResetPassword.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ForgotPassword.this, "user does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }
        });

    }
}