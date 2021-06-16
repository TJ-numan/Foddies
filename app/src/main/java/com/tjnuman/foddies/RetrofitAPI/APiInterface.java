package com.tjnuman.foddies.RetrofitAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APiInterface {
    @GET("email_registration.php")
    Call<User> performEmailRegistration(
            @Query("user_name") String user_name,
            @Query("user_email") String user_email,
            @Query("user_password") String user_password
            );
    @GET("email_login.php")
    Call<User> performEmailLogin(
            @Query("user_email") String user_email,
            @Query("user_password") String user_password
    );

    @GET("phone_registration.php")
    Call<User> performPhoneRegistration(
            @Query("user_phone") String user_phone
    );

    @GET("phone_login.php")
    Call<User> performPhoneLogin(
            @Query("user_phone") String user_phone
    );
}
