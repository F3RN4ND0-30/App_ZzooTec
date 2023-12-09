package com.example.app_zzootec.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.app_zzootec.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    MaterialToolbar materialToolbar;
    FrameLayout frameLayout;
    NavigationView navigationView;

    TextView textView;

    View navitga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        drawerLayout = findViewById(R.id.drawerlayout);
        materialToolbar = findViewById(R.id.materialtoolbar);
        frameLayout = findViewById(R.id.framlayout);
        navigationView = findViewById(R.id.navigationview);
        navitga = navigationView.getHeaderView(0);
        textView = navitga.findViewById(R.id.textview);

        textView.setText("ZzooTec");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MenuActivity.this, drawerLayout,materialToolbar,R.string.close,R.string.open);
        drawerLayout.addDrawerListener(toggle);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.Home){
                    textView.setText("ZzooTec");
                    Fragment(new HomeFragment());
                    Toast.makeText(MenuActivity.this, "Clientes", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if(item.getItemId()==R.id.Bus){
                    textView.setText("ZzooTec");
                    Fragment(new PerfilEditFragment());
                    Toast.makeText(MenuActivity.this, "Editar Perfil", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if(item.getItemId()==R.id.Product){
                    textView.setText("ZzooTec");
                    Fragment(new ProductFragment());
                    Toast.makeText(MenuActivity.this, "Productos", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if(item.getItemId()==R.id.Rating){
                    textView.setText("ZzooTec");
                    Fragment(new AttendanceFragment());
                    Toast.makeText(MenuActivity.this, "Asistencia", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }
                else if(item.getItemId()==R.id.sucursales){
                    textView.setText("ZzooTec");
                    Fragment(new BranchesFragment());
                    Toast.makeText(MenuActivity.this, "Sucursales", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                return true;
            }
        });
        materialToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                if(item.getItemId()==R.id.home1){
                    startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                    Toast.makeText(MenuActivity.this, "Menu", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
    }

    private void Fragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.framlayout, fragment);
        ft.commit();
    }
}