package com.example.app_zzootec.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app_zzootec.R;
import com.example.app_zzootec.api.Apis;
import com.example.app_zzootec.api.Auth;
import com.example.app_zzootec.api.UserAPI;
import com.example.app_zzootec.model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private EditText nombre;
    private EditText apellido;
    private EditText codigo;
    private EditText generoCli;

    private SearchView buscar_cliente;

    private UserAPI userService = Apis.getUserService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombre = (EditText) view.findViewById(R.id.nombreCli);
        apellido = (EditText) view.findViewById(R.id.apellidoCli);
        codigo = (EditText) view.findViewById(R.id.codigoCli);
        generoCli = (EditText) view.findViewById(R.id.generoCli);
        buscar_cliente = (SearchView) view.findViewById(R.id.buscar_cliente);

        Cliente();

        Buscar_cliente();
    }

    public void Buscar_cliente(){
        buscar_cliente.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Call<Usuario>usuario = userService.obtenerUsuarioPorId(Long.parseLong(s.toString()));
                usuario.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        if(response.isSuccessful()){
                            Log.d("usuario",response.body().toString());
                            Usuario usuario = response.body();
                            nombre.setText(usuario.getFirstName());
                            apellido.setText(usuario.getLastName());
                            codigo.setText(usuario.getId().toString());
                            generoCli.setText(usuario.getGenre());
                        }
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.d("usuario",t.getMessage());
                    }
                });
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    public void Cliente(){
        Call<Usuario>usuario = userService.obtenerUsuarioPorId(1l);
        usuario.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.isSuccessful()){
                    Log.d("usuario",response.body().toString());
                    Usuario usuario = response.body();
                    nombre.setText(usuario.getFirstName());
                    apellido.setText(usuario.getLastName());
                    codigo.setText(usuario.getId().toString());
                    generoCli.setText(usuario.getGenre());
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