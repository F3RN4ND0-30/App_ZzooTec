package com.example.app_zzootec.api;

import com.example.app_zzootec.model.AuthModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Auth {
    public static final String PREFIX = "api/v1";

    @POST(PREFIX + "/auth")
    Call<AuthModel> login(@Body HashMap<String, Object> user);
}
