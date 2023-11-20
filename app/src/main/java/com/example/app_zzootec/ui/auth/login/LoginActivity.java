package com.example.app_zzootec.ui.auth.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_zzootec.api.Apis;
import com.example.app_zzootec.api.Auth;
import com.example.app_zzootec.model.AuthModel;
import com.example.app_zzootec.model.Usuario;
import com.example.app_zzootec.network.RetrofitClient;
import com.example.app_zzootec.ui.fragment.MenuActivity;
import com.example.app_zzootec.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btn_entrar;
    EditText user,password;

    private Auth authService = Apis.getAuthService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.user);
        password = findViewById(R.id.password);
        btn_entrar = findViewById(R.id.btn_entrar);

        btn_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login(){

        HashMap<String,Object> user=new HashMap<>();
        user.put("username",this.user.getText().toString());
        user.put("password",this.password.getText().toString());
        Log.d("login",user.toString());
        Call<AuthModel> response = authService.login(user);
        Log.d("login",response.toString());
        response.enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                Log.d("login",response.message());
                if(response.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "logeado", Toast.LENGTH_SHORT).show();
                    AuthModel credentials = response.body();
                    RetrofitClient.setAuthToken(credentials.getToken().toString());
                    Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<AuthModel> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Error al logearse", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

}
