package com.itca.examen2practica;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class conexionBD extends SQLiteOpenHelper {

    public conexionBD(@Nullable Context context) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
          sqLiteDatabase.execSQL("create table tb_bloc(id integer not null primary key autoincrement, Titulo text, Descripcion text, Autor text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("drop table if exists tb_notas");
    onCreate(db);
    }

}
