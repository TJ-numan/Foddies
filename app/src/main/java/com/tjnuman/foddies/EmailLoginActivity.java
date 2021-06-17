package com.tjnuman.foddies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tjnuman.foddies.RetrofitAPI.APiInterface;
import com.tjnuman.foddies.RetrofitAPI.ApiClient;
import com.tjnuman.foddies.RetrofitAPI.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmailLoginActivity extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button continueButton;
    public static APiInterface aPiInterface;
    String email,password;
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
        continueButton = findViewById(R.id.continueButton);

        aPiInterface = ApiClient.getApiClient().create(APiInterface.class);

        newAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmailLoginActivity.this, EmailRegistrationActivity.class);
                startActivity(intent);
            }
        });

        CheckCredentials();

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthenticateUser();
            }
        });



    }

    private void CheckCredentials() {
        password = passwordEditText.getText().toString();
        email = emailEditText.getText().toString();

        if(email.isEmpty())
        {
            emailEditText.setError("Email address required");
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            emailEditText.setError("Please provide valid  email");
            emailEditText.requestFocus();
            return;
        }

        else if(password.isEmpty())
        {
            passwordEditText.setError("Password can't be empty");
            passwordEditText.requestFocus();
            return;
        }
        else if(password.length()<6)
        {
            passwordEditText.setError("Password length should be 6 charectars!");
            passwordEditText.requestFocus();
            return;
        }
    }

    private void AuthenticateUser() {
        Call<User> call = aPiInterface.performEmailLogin(email,password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.body().getResponse().equals("ok"))
                {
                    Toast.makeText(EmailLoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EmailLoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if(response.body().getResponse().equals("no_account")){
                    Toast.makeText(EmailLoginActivity.this, "no account with this email", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {


            }
        });


    }


}