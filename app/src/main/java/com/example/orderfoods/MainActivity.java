package com.example.orderfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity{

    private MaterialButton SignIn, SignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SignIn = findViewById(R.id.btn_SignIn);
        SignUp = findViewById(R.id.btn_SignUp);
    }

    public void onClick(View view) {

        if(view == SignIn){
            //Intent intent = new Intent(this, AnotherActivity.class);
            //intent.putExtra("Name", "Computer");
            Toast.makeText(getApplicationContext(),"SignIn",Toast.LENGTH_SHORT).show();
            //startActivity(intent);

        }else if(view == SignUp){
            //Intent intent = new Intent(this, AnotherActivity.class);
            //intent.putExtra("Name", "Player");
            Toast.makeText(getApplicationContext(),"SignUp",Toast.LENGTH_SHORT).show();
            //startActivity(intent);
        }

    }
}