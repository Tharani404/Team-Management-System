package com.example.cricketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText txtUser;
    EditText txtPassword;
    Button btnView;

    String userName;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        txtUser = findViewById(R.id.username);
        txtPassword = findViewById(R.id.password);
        btnView = findViewById(R.id.btnLogIn);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = txtUser.getText().toString();
                password = txtPassword.getText().toString();

                if(userName.equals("Tharani")&&password.equals("1234")){

                    Toast.makeText(LoginPage.this,"Login Successful", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(getApplicationContext(),Home.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(LoginPage.this,"Invalid UserName or Password", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}