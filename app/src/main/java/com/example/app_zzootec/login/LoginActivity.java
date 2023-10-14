package com.example.app_zzootec.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_zzootec.MenuActivity;
import com.example.app_zzootec.R;

public class LoginActivity extends AppCompatActivity {

    Button btn_entrar;
    EditText user,password;

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
                startActivity(new Intent(getApplicationContext(), MenuActivity.class));
            }
        });
    }

    public void login(){
        if(user.equals("admin") && password.equals("1234")){
            startActivity(new Intent(getApplicationContext(), MenuActivity.class));
        }else{
            Toast.makeText(this, "USUARIO O CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();
        }
    }
}