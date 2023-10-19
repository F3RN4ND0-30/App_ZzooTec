package com.example.app_zzootec;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AttendanceFragment extends Fragment {

    FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        fab = view.findViewById(R.id.FAB_btn1);

        fab.setOnClickListener(v -> redirigir());
        return view;
    }

    public void redirigir(){
        Intent telegram = new Intent(Intent.ACTION_VIEW , Uri.parse("https://t.me/+SGxLHRA4P-piZjNh"));
        startActivity(telegram);
    }
}