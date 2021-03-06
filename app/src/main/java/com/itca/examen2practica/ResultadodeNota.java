package com.itca.examen2practica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ResultadodeNota extends AppCompatActivity {
public String x;
    public EditText v;
    public EditText titulo, desc, autor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultadode_nota);
        titulo = findViewById(R.id.txtTitle);
        desc = findViewById(R.id.txtDescription);
        autor = findViewById(R.id.txtAutor);
    Bundle bundle = new Bundle();

        String dato = getIntent().getStringExtra("valorTitle");

        v = findViewById(R.id.txtTitle);
        v.setText(dato);

        x = v.getText().toString();


        try {

            ConexionSQLite conexion = new ConexionSQLite(this);
            SQLiteDatabase bd = conexion.getWritableDatabase();

            Cursor fila = bd.rawQuery("select Descripcion, Autor from tb_notas where Titulo = '" + x + "'"  , null);
            if(fila.moveToFirst()) {
                desc.setText(fila.getString(0));
                autor.setText(fila.getString(1));
            }


        } catch (Exception e) {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }


    }


    public void update(View view) {
        ConexionSQLite conexion = new ConexionSQLite(this);
        SQLiteDatabase bd = conexion.getWritableDatabase();
        String t = titulo.getText().toString();
        String d = desc.getText().toString();
        String a = autor.getText().toString();


        ContentValues registro = new ContentValues();
        registro.put("titulo", t);
        registro.put("descripcion", d);
        registro.put("autor", a);

        int cant = bd.update("tb_notas", registro, "titulo = '" + x + "'", null);
        bd.close();
        if (cant == 1) {
            Toast.makeText(this, "Nota Actualizada Correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Nota no se Actualiz?? Correctamente", Toast.LENGTH_SHORT).show();
        }
    }


    public void deleteNote(View view) {
        ConexionSQLite conexion = new ConexionSQLite(this);
        SQLiteDatabase bd = conexion.getWritableDatabase();
        String t = titulo.getText().toString();
        int cant = bd.delete("tb_notas", "titulo = '" + x + "'", null);
        bd.close();
        titulo.setText("");
        desc.setText("");
        autor.setText("");

        Toast.makeText(this, "Notas Elinadas Correctamente", Toast.LENGTH_SHORT).show();
    }

}
