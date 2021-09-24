package com.itca.examen2practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private EditText et1,et2,et3;
    private Button btnenable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
    }
    public void GuardarNota(View view){
        btnenable.setEnable=true;
    try {
            ConexionSQLite conexion = new ConexionSQLite(this);
            SQLiteDatabase bd = conexion.getWritableDatabase();
            String t = titulo.getText().toString();
            String d = desc.getText().toString();
            String a = autor.getText().toString();

            ContentValues registro = new ContentValues();
            registro.put("id", (Integer) null);
            registro.put("titulo", t);
            registro.put("descripcion", d);
            registro.put("autor", a);

            int result = (int) bd.insert("tb_notas", null, registro);
            bd.close();

            if (result > 0) {
                Toast.makeText(this, "Se guardo el registro", Toast.LENGTH_SHORT).show();
                titulo.setText("");
                desc.setText("");
                autor.setText("");
            } else {
                Toast.makeText(this, "No Se guardo el registro", Toast.LENGTH_SHORT).show();
            }



        } catch (Exception e) {
            String msg = e.toString();
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }


    }

    public void change(View view) {
        Intent intent = new Intent(this, registerNotes.class);
        startActivity(intent);
    }
}
