package com.example.app_zzootec.api;

import com.example.app_zzootec.network.RetrofitClient;

public class Apis {
    public static final String URL_001 = "http://192.168.1.11:8080/";

    public static UserAPI getUserService() {
        return RetrofitClient.getClient().create(UserAPI.class);
    }

    public static ProductoAPI getProductoService() {
        return RetrofitClient.getClient().create(ProductoAPI.class);
    }

    public static CategoriaAPI getCategoriaService() {
        return RetrofitClient.getClient().create(CategoriaAPI.class);
    }

    public static Auth getAuthService() {
        return RetrofitClient.getClient().create(Auth.class);
    }
}
