package com.example.app_zzootec.api;

import com.example.app_zzootec.model.Usuario;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserAPI {
    public static final String PREFIX = "api/usuarios";

    @GET(PREFIX + "/list")
    Call<List<Usuario>> listar();

    @GET(PREFIX + "/{id}/get")
    Call<List<Usuario>> obtenerUsuarioPorId(@Path("id") String id);

    @PUT(PREFIX + "/{id}/update")
    Call<List<Usuario>> editarUsuario(@Path("id") String id, @Body HashMap<String, Object> user);

}
