package com.example.orderfoods;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText phone;
    private EditText password;

    // This is our DataManager instance
    private DataManager dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dm = new DataManager(this);

        phone = findViewById(R.id.edit_phone);
        password = findViewById(R.id.edit_password);
    }

    // Output the cursor contents to the log
    public void showData(Cursor c){
        while (c.moveToNext())
        {
            Log.i("info", c.getString(1)+ " " +c.getString(2));
        }
    }

    public void signUpClicked(View view){
        dm.SignUp(Integer.parseInt(phone.getText().toString()),password.getText().toString());
        Toast.makeText(this, "Sign up successfully", Toast.LENGTH_SHORT).show();
    }

    public void selectAllClicked(View view){
        showData(dm.selectAll());
    }

}