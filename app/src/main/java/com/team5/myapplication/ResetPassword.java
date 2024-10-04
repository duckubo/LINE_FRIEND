package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {
EditText edtPass, edtPassAgain, edtName;
Button btnSavePass;
DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
    linkView();
    addEvent();
    }

    private void linkView() {
        edtPass=findViewById(R.id.edtPass);
        edtPassAgain=findViewById(R.id.edtPassAgain);
        btnSavePass=findViewById(R.id.btnSavePass);
        edtName=findViewById(R.id.edtName);
        myDB=new DBHelper(this);

    }

    private void addEvent() {
        Intent intent= getIntent();
        edtName.setText(intent.getStringExtra("username"));
        btnSavePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=edtName.getText().toString();
                String password = edtPass.getText().toString();
                String repass = edtPassAgain.getText().toString();
                if (password.equals(repass)) {


                    Boolean checkpasswordupdate = myDB.updatepassword(user, password);
                    if (checkpasswordupdate == true) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        Toast.makeText(ResetPassword.this, "Password Updated Success", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(ResetPassword.this, "Password not Update", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(ResetPassword.this, "Password Not Maching", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}