package com.tjnuman.foddies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.tjnuman.foddies.RetrofitAPI.APiInterface;
import com.tjnuman.foddies.RetrofitAPI.ApiClient;
import com.tjnuman.foddies.RetrofitAPI.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailRegistrationActivity extends AppCompatActivity {
    EditText userName, userPassword, userEmail, retypepassword;
    Button signupbtn;
    APiInterface aPiInterface;
    LottieAnimationView progressbar;

    String name,password, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        userName = findViewById(R.id.fullname);
        userEmail = findViewById(R.id.email);
        userPassword = findViewById(R.id.password);
        signupbtn = findViewById(R.id.continueButton);
        retypepassword = findViewById(R.id.retypepassword);
        progressbar = findViewById(R.id.progresslogin);


        aPiInterface = ApiClient.getApiClient().create(APiInterface.class);
        CreateAccount();
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthenticateUser();
            }
        });

    }


    private void CreateAccount() {
         name = userName.getText().toString();
         password = userPassword.getText().toString();
         email = userEmail.getText().toString();
        if(name.isEmpty())
        {
            userName.setError("Full Name is required");
            userName.requestFocus();
            return;
        }

        else if(email.isEmpty())
        {
            userEmail.setError("Email address required");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            userEmail.setError("Please provide valid  email");
            userEmail.requestFocus();
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
            userEmail.setEnabled(false);

        }


    }

    private void AuthenticateUser() {
        Call<User> call = aPiInterface.performEmailRegistration(name, email,password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body().getResponse().equals("ok")){
                    Toast.makeText(EmailRegistrationActivity.this, "Successfully Registerd ", Toast.LENGTH_SHORT).show();
                }
                else if(response.body().getResponse().equals("failed")){
                    Toast.makeText(EmailRegistrationActivity.this, "Something went wrong, please try again", Toast.LENGTH_SHORT).show();
                }
                else if(response.body().getResponse().equals("already")){
                    Toast.makeText(EmailRegistrationActivity.this, "An account with this email already registerd", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

}