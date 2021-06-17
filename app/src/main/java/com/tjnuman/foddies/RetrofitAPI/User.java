package com.tjnuman.foddies.RetrofitAPI;
import com.google.gson.annotations.SerializedName;
public class User {
    @SerializedName("response")
    String Response;

    @SerializedName("user_id")
    String UserId;

    public String getResponse() {
        return Response;
    }

    public String getUserId() {
        return UserId;
    }
}

// video link: https://www.youtube.com/watch?v=c2jlbwUaBPs&list=PLMVu3arCmkR6Wpt5LBuMlOZEkZxjE1Xkb&index=15
// video was in 2:03 mnt