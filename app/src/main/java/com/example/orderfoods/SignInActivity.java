package com.example.orderfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    private EditText phone;
    private EditText password;
    private Button signIn;

    private DataManager dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        dm = new DataManager(this);

        phone = findViewById(R.id.edit_phone);
        password = findViewById(R.id.edit_password);
        signIn = findViewById(R.id.btn_SignIn);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int PN = Integer.parseInt(phone.getText().toString());
                String PASS = password.getText().toString();

                if (Integer.toString(PN).equals("") || PASS.equals("")) {
                    Toast.makeText(SignInActivity.this, "Please enter the all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = dm.checkUser(PN, PASS);
                    if (checkuserpass == true) {
                        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                        Toast.makeText(SignInActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignInActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }


}