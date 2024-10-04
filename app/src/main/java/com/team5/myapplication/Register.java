package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText edtPhone, edtName, edtPass, edtPassAgain;
    Button btnBackLogin, btnRegister;
    DBHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        linkview();
        addEvent();
    }

    private void linkview() {
        edtPhone = findViewById(R.id.edtPhone);
        edtName = findViewById(R.id.edtName);
        edtPass = findViewById(R.id.edtPass);
        edtPassAgain = findViewById(R.id.edtPassAgain);
        btnBackLogin = findViewById(R.id.btnBackLogin);
        btnRegister = findViewById(R.id.btnRegister);
        myDB = new DBHelper(this);
    }

    private void addEvent() {

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtName.getText().toString();
                String pass = edtPass.getText().toString();
                String repass = edtPassAgain.getText().toString();
                String phone = edtPhone.getText().toString();
                if (user.equals("") || pass.equals("") || repass.equals("") || phone.equals(""))
                {
                    Toast.makeText(Register.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    if (pass.equals(repass))
                    {
                        Boolean checkuser = myDB.checkusername(user);
                        if (checkuser == false)
                        {
                            Boolean insert = myDB.insertData(user,pass);
                            if (insert == true) {
                                Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(), Activity_TrangChu.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(Register.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Register.this, "User already Exists, please login", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Toast.makeText(Register.this, "Pass not maching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        btnBackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent= new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            }
        });
    }
}