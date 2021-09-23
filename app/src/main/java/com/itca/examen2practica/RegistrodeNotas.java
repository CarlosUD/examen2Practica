package com.itca.examen2practica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrodeNotas extends ArrayAdapter<Notas> {
    private Activity activity;
    private ArrayList<Notas> lVenta;
    private static LayoutInflater inflater = null;

    public RegistrodeNotas(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrode_notas);

    }


}