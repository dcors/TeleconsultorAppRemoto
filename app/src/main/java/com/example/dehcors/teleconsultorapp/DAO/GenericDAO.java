package com.example.dehcors.teleconsultorapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.dehcors.teleconsultorapp.models.Consulta;
import com.example.dehcors.teleconsultorapp.models.Diagnostico;
import com.example.dehcors.teleconsultorapp.models.Especialista;
import com.example.dehcors.teleconsultorapp.models.Solicitante;

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
                     "CREATE TABLE Consulta(caso TEXT,tipoConsulta INTEGER, idConsulta INTEGER,cpfPaciente TEXT,especialidade TEXT,prontuario TEXT, cpfUsuario TEXT,idParecer INTEGER);" +
                     "CREATE TABLE Parecer(idParecer INTEGER, idAnexo INTEGER,textoParecer TEXT);" +
                     "CREATE TABLE TipoDuvida(idTipoDuvida INTEGER,nomeTipoDuvida TEXT);" +
                     "CREATE TABLE Usuario(idTipo INTEGER,nomeUsuario TEXT, cpfUsuario TEXT,telefoneUsuario TEXT,emailUsuario TEXT,profissao TEXT,senha TEXT);" +
                     "CREATE TABLE TipoUsuario(idTipo INTEGER, nomeTipo INTEGER);";

        /*
        * Criar todas as tabelas
        *
        * */
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String sql = "DROP DATABASE Teleconsultoria;";
        db.execSQL(sql);
        onCreate(db);

    }


    public void insereSolicitante(Solicitante solicitante) {
        SQLiteDatabase db = getWritableDatabase();


        ContentValues dados = new ContentValues();
        dados.put("idTipo",solicitante.getIdTipo());
        dados.put("nomeUsuario",solicitante.getAgenteNome());
        dados.put("cpfUsuario",solicitante.getAgenteCPF());
        dados.put("telefoneUsuario",solicitante.getAgenteTelefone());
        dados.put("emailUsuario",solicitante.getAgenteEmail());
        dados.put("profissao",solicitante.getAgenteProfissao());
        dados.put("senha",solicitante.getAgenteSenha());

        db.insert("Usuario",null,dados);

    }


    public void insereEspecialista(Especialista especialista) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = new ContentValues();
        dados.put("idTipo",especialista.getIdTipo());
        dados.put("nomeUsuario",especialista.getEspecialistaNome());
        dados.put("cpfUsuario",especialista.getEspecialistaCPF());
        dados.put("profissao",especialista.getEspecialistaProfissao());
        dados.put("senha",especialista.getEspecialistaSennha());
        db.insert("Usuario",null,dados);
    }

    public void insereConsulta(Consulta consulta) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("caso",consulta.getTxCaso());
        dados.put("cpfPaciente",consulta.getCpfPaciente());
        dados.put("especialidade",consulta.getEspecialidade());
        db.insert("Consulta",null,dados);
    }


    public void insereDiagnostico(Diagnostico diagnostico) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("caso",diagnostico.getCaso());
        dados.put("prontuario",diagnostico.getProntuario());
        dados.put("especialidade",diagnostico.getEspecialidade());
        db.insert("Consulta",null,dados);
    }
}
