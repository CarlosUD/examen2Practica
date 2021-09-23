package com.itca.examen2practica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private EditText et1,et2,et3;
    conexionBD admin = new conexionBD((Context) this,"EvalNotas.db",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
    }
    public void GuardarNota(View view){

        SQLiteDatabase db = admin.getWritableDatabase();
        String titulo = et1.getText().toString();
       String Descricion = et2.getText().toString();
       String Autor =et3.getText().toString();
        ContentValues Registros =new ContentValues();
        Registros.put("Titulo",titulo);
        Registros.put("Descripcion",Descricion);
        Registros.put("Autor",Autor);
        db.insert("tb_notas",null,Registros);
        et1.setText("");
        et2.setText("");
        et3.setText("");
            Toast.makeText(this, "Notas Registradas Correctamente", Toast.LENGTH_SHORT).show();
        db.close();
    }

}