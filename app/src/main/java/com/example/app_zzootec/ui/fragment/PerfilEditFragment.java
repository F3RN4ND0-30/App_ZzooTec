package com.example.app_zzootec.ui.fragment;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.app_zzootec.R;
import com.example.app_zzootec.api.Apis;
import com.example.app_zzootec.api.UserAPI;
import com.example.app_zzootec.model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilEditFragment extends Fragment {

    EditText usuarios;
    EditText correo;
    EditText telefono;

    EditText contratoPer;

    private UserAPI userService = Apis.getUserService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perfil_edit, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        correo = (EditText) view.findViewById(R.id.CorreoPer);
        usuarios = (EditText) view.findViewById(R.id.UsuarioPer);
        telefono = (EditText) view.findViewById(R.id.telefonoPer);
        contratoPer = (EditText) view.findViewById(R.id.contratoPer);

        Perfil();

    }

    public void Perfil(){
        Call<Usuario>usuario = userService.obtenerUsuarioActual();
        usuario.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Log.d("usuario",response.body().toString());
                    Usuario usuario = response.body();
                    correo.setText(usuario.getEmail());
                    usuarios.setText(usuario.getUsername());
                    telefono.setText(usuario.getPhone());
                    contratoPer.setText(usuario.getContract());
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("usuario",t.getMessage());
            }
        });
    }
}