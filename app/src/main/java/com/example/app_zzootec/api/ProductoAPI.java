package com.example.app_zzootec.api;

import com.example.app_zzootec.model.Productos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ProductoAPI {

    public static final String PREFIX = "api/v1/products";

    @GET(PREFIX + "/{id}")
    Call<Productos> findById(@Path("id") Long id);

}
