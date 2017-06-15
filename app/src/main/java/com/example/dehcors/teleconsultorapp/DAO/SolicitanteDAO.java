package com.example.dehcors.teleconsultorapp.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Icons4u TI on 12/06/2017.
 */

public class SolicitanteDAO extends SQLiteOpenHelper {
    public SolicitanteDAO(Context context) {
        super(context, "Teleconsultoria", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP TABLE IF EXISTS Solicitante;";
        db.execSQL(sql);
        onCreate(db);


    }
}
