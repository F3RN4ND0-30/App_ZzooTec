package com.example.app_zzootec.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoAPI {

    public static final String PREFIX = "api/productos";

    @GET(PREFIX + "/{id}/get")
    Call<Boolean> findById(@Path("id") String id);

}
