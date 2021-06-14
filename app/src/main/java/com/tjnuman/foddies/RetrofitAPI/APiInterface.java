package com.tjnuman.foddies.RetrofitAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public class APiInterface {
    @GET("email_registration.php")
    Call<User> performEmailRegistration(

    )
}
