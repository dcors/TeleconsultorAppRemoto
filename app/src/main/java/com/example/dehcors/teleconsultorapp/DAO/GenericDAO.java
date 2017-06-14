package com.example.dehcors.teleconsultorapp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by eduardo on 13/06/2017.
 */

public class GenericDAO extends SQLiteOpenHelper {
    public GenericDAO(Context context) {
        super(context, "Teleconsultoria", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        /*
        * Criar todas as tabelas
        *
        * */

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP DATABASE Teleconsultoria;";
        db.execSQL(sql);
        onCreate(db);

    }
}
