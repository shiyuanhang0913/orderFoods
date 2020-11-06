package com.example.orderfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity{

    private MaterialButton SignInPage, SignUpPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignInPage = findViewById(R.id.btn_SignIn_Page);
        SignUpPage = findViewById(R.id.btn_SignUp_Page);
    }

    public void onClick(View view) {

        if(view == SignInPage){
            Intent intent = new Intent(this, SignInActivity.class);
            Toast.makeText(getApplicationContext(),"SignIn",Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }else if(view == SignUpPage){
            Intent intent = new Intent(this, SignUpActivity.class);
            Toast.makeText(getApplicationContext(),"SignUp",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

    }
}