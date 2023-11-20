package com.example.app_zzootec.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_zzootec.R;
import com.example.app_zzootec.api.Apis;
import com.example.app_zzootec.api.ProductoAPI;
import com.example.app_zzootec.api.UserAPI;
import com.example.app_zzootec.model.Productos;
import com.example.app_zzootec.model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductFragment extends Fragment {

    private EditText nombreProd;
    private EditText codigoProd;
    private EditText stockProd;
    private EditText categoriaProd;
    private ProductoAPI productoAPI = Apis.getProductoService();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombreProd = (EditText) view.findViewById(R.id.nombreProd);
        codigoProd = (EditText) view.findViewById(R.id.codigoProd);
        stockProd = (EditText) view.findViewById(R.id.stockProd);
        categoriaProd = (EditText) view.findViewById(R.id.categoriaProd);

        Productos();
    }

    public void Productos(){
        Call<Productos> producto = productoAPI.findById(2l);
        producto.enqueue(new Callback<Productos>() {
            @Override
            public void onResponse(Call<Productos> call, Response<Productos> response) {
                if(response.isSuccessful()){
                    Log.d("usuario",response.body().toString());
                    Productos productos = response.body();
                    nombreProd.setText(productos.getName());
                    codigoProd.setText(productos.getId().toString());
                    stockProd.setText(productos.getStock());
                    categoriaProd.setText(productos.getCategory().toString());
                }
            }

            @Override
            public void onFailure(Call<Productos> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("usuario",t.getMessage());
            }
        });
    }
}