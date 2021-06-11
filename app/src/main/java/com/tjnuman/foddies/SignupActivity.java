package com.tjnuman.foddies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.airbnb.lottie.LottieAnimationView;

public class SignupActivity extends AppCompatActivity {
    EditText userName, userPassword, userPhone, retypepassword;
    Button signupbtn;
    LottieAnimationView progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        userName = findViewById(R.id.fullname);
        userPhone = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        signupbtn = findViewById(R.id.continueButton);
        retypepassword = findViewById(R.id.retypepassword);
        progressbar = findViewById(R.id.progresslogin);


        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });

    }




    private void CreateAccount() {
        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String phone = userPhone.getText().toString();
        if(name.isEmpty())
        {
            userName.setError("Full Name is required");
            userName.requestFocus();
            return;
        }

        else if(phone.isEmpty())
        {
            userPhone.setError("Email address required");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(phone).matches())
        {
            userPhone.setError("Please provide valid  email");
            userPhone.requestFocus();
            return;
        }

        else if(password.isEmpty())
        {
            userPassword.setError("Password can't be empty");
            userPassword.requestFocus();
            return;
        }
        else if(password.length()<6)
        {
            userPassword.setError("Password length should be 6 charectars!");
            userPassword.requestFocus();
            return;
        }
        else if(retypepassword.equals(password))
        {
            retypepassword.setError("Password didn't match");
            userPassword.requestFocus();
            return;
        }
        else
        {
            progressbar.setVisibility(View.VISIBLE);
            userName.setEnabled(false);
            userPassword.setEnabled(false);
            userPhone.setEnabled(false);
            //ValidatephoneNumber(name,phone,password);
        }


    }
}