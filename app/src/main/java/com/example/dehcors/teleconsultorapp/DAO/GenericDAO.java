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

        String sql = "CREATE TABLE Anexo(idAnexo INTEGER,urlAnexo TEXT);" +
                     "CREATE TABLE Paciente( cpf TEXT,nomePaciente TEXT,nascimento TEXT,sexo TEXT);" +
                     "CREATE TABLE Consulta(tipoConsulta INTEGER, idConsulta INTEGER,cpfPaciente TEXT,especialidade TEXT,prontuario TEXT, cpfUsuario TEXT,idParecer INTEGER);" +
                     "CREATE TABLE Parecer(idParecer INTEGER, idAnexo INTEGER,textoParecer TEXT);" +
                     "CREATE TABLE TipoDuvida(idTipoDuvida INTEGER,nomeTipoDuvida TEXT);" +
                     "CREATE TABLE Usuario(idTipo INTEGER,nomeUsuario TEXT, cpfUsuario TEXT,telefoneUsuario TEXT,emailUsuario TEXT,registroProfissional TEXT,unidadeUsuario,orgaoUFRegistro TEXT,senha TEXT,idArea INTEGE);" +
                     "CREATE TABLE TipoUsuario(idTipo INTEGER, nomeTipo INTEGER);";

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
