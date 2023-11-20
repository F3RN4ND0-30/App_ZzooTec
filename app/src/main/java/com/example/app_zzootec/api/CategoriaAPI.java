package com.example.app_zzootec.api;

import com.example.app_zzootec.model.Categoria;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.GET;


public interface CategoriaAPI {

    public static final String PREFIX = "api/categorias";

    @GET(PREFIX + "/listar")
    Call<List<Categoria>> listar();


}
