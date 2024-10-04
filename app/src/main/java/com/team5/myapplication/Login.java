package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class Login extends AppCompatActivity {
    EditText edtName, edtPass;
    Button btnLogin, btnForgotPass, btnRegister, btnSkip ;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        linkView();
        addEvent();
    }

    private void linkView() {
        edtName=findViewById(R.id.edtName);
        edtPass=findViewById(R.id.edtPass);
        btnLogin=findViewById(R.id.btnLogin);
        btnForgotPass=findViewById(R.id.btnForgotPass);
        btnRegister=findViewById(R.id.btnRegister);
        btnSkip = findViewById(R.id.btnSkip);

        myDB= new DBHelper(this);
    }
    private void addEvent() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String user= edtName.getText().toString();
        String pass=edtPass.getText().toString();
        if (user.equals("") || pass.equals("") )
        {
            Toast.makeText(Login.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean checkuserpass=myDB.checkusernamePassword(user,pass);
           if(checkuserpass==true){
               Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(getApplicationContext(), Activity_TrangChu.class);
               startActivity(intent);
           }else{
               Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
           }
        }
    }

});

    btnForgotPass.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getApplicationContext(), ForgotPassword.class);
        startActivity(intent);
        }
    });

    btnSkip.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Login.this, Activity_TrangChu.class));
        }
    });

    btnRegister.setOnClickListener((new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(getApplicationContext(), Register.class);
            startActivity(intent);
            }
        }));
    }

}