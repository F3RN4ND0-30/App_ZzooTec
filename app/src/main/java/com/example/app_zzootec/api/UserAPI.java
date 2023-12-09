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
    public static final String PREFIX = "api/v1/users";

    @GET(PREFIX + "/list")
    Call<List<Usuario>> listar();

    @GET(PREFIX + "/{id}")
    Call<Usuario> obtenerUsuarioPorId(@Path("id") Long id);

    @PUT(PREFIX + "/{id}")
    Call<Usuario> editarUsuario(@Path("id") Long id, @Body Usuario user);

    @GET(PREFIX + "/userInfo")
    Call<Usuario> obtenerUsuarioActual();

}
