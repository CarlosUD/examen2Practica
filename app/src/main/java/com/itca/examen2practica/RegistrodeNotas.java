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
     public ListView list;
    public TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrode_notas);
              list = findViewById(R.id.notesList);
        text = findViewById(R.id.texView);
    
        ArrayList<String> valor = new ArrayList<>();


        ConexionSQLite conexion = new ConexionSQLite(this);
        SQLiteDatabase bd = conexion.getWritableDatabase();

        Cursor fila = bd.rawQuery("select titulo from tb_notas", null);
        if (fila.moveToFirst()) {
            do {
                valor.add(fila.getString(0));
            } while (fila.moveToNext());
        }
        bd.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, valor);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(view.getContext(), update.class);
                //String t = valor.get(position);
                String t = (String) list.getItemAtPosition(position);

                intent.putExtra("valorTitle", t);
                startActivity(intent);
            }
        });

    }


}
