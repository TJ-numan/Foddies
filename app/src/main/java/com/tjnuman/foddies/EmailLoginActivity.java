package com.tjnuman.foddies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tjnuman.foddies.RetrofitAPI.APiInterface;
import com.tjnuman.foddies.RetrofitAPI.ApiClient;

public class EmailLoginActivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button continueButton;

    TextView newAccount,changePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        newAccount = findViewById(R.id.newaccount);
        changePassword = findViewById(R.id.changepassword);



        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailLoginActivity.this, EmailRegistrationActivity.class);
                startActivity(intent);
            }
        });

    }
}