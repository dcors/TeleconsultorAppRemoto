package com.example.dehcors.teleconsultorapp.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.widget.TextView;

import com.example.dehcors.teleconsultorapp.Usuario;
import com.example.dehcors.teleconsultorapp.models.Consulta;
import com.example.dehcors.teleconsultorapp.models.Diagnostico;
import com.example.dehcors.teleconsultorapp.models.Especialista;
import com.example.dehcors.teleconsultorapp.models.Solicitante;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eduardo on 13/06/2017.
 */

public class GenericDAO extends SQLiteOpenHelper {
    public GenericDAO(Context context) {
        super(context, "Teleconsultoria", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql1 = "CREATE TABLE Anexo(idAnexo INTEGER,urlAnexo TEXT);" ;
        String sql2 = "CREATE TABLE Paciente( cpf TEXT,nomePaciente TEXT,nascimento TEXT,sexo TEXT);" ;
        String sql3 = "CREATE TABLE Consulta(idConsulta INTEGER PRIMARY KEY AUTOINCREMENT,atendida int,cpfUsuario TEXT,caso TEXT,cpfPaciente TEXT,especialidade TEXT,prontuario TEXT, tipo TEXT);";
        String sql4 = "CREATE TABLE Parecer(idParecer INTEGER PRIMARY KEY AUTOINCREMENT, idAnexo INTEGER,textoParecer TEXT,idConsulta INTEGER);";
        String sql5 = "CREATE TABLE TipoDuvida(idTipoDuvida INTEGER,nomeTipoDuvida TEXT);";
        String sql6 = "CREATE TABLE Usuario(idTipo INTEGER,nomeUsuario TEXT,unidadeUsuario, cpfUsuario TEXT,telefoneUsuario TEXT,emailUsuario TEXT,profissao TEXT,senha TEXT);";
        String sql7 = "CREATE TABLE TipoUsuario(idTipo INTEGER, nomeTipo TEXT);";

        /*
        * Criar todas as tabelas
        *
        * */
        db.execSQL(sql1);
        db.execSQL(sql2);
        db.execSQL(sql3);
        db.execSQL(sql4);
        db.execSQL(sql5);
        db.execSQL(sql6);
        db.execSQL(sql7);

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
        dados.put("idTipo",1);
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
        dados.put("idTipo",2);
        dados.put("nomeUsuario",especialista.getEspecialistaNome());
        dados.put("cpfUsuario",especialista.getEspecialistaCPF());
        dados.put("profissao",especialista.getEspecialistaProfissao());
        dados.put("senha",especialista.getEspecialistaSennha());
        dados.put("emailUsuario",especialista.getEspecialistaEmail());
        db.insert("Usuario",null,dados);
    }

    public void insereConsulta(Consulta consulta) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("caso",consulta.getTxCaso());
        dados.put("cpfPaciente",consulta.getCpfPaciente());
        dados.put("especialidade",consulta.getEspecialidade());
        dados.put("tipo","Consultoria");
        dados.put("atendida",0);
        dados.put("cpfUsuario",consulta.getCpfUsuario());
        db.insert("Consulta",null,dados);
    }


    public void insereDiagnostico(Diagnostico diagnostico) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("caso",diagnostico.getCaso());
        dados.put("prontuario",diagnostico.getProntuario());
        dados.put("especialidade",diagnostico.getEspecialidade());
        dados.put("tipo","Diagnóstico");
        dados.put("atendida",0);
        dados.put("cpfUsuario",diagnostico.getCpfUsuario());
        db.insert("Consulta",null,dados);
    }

    public List<Consulta> getConsultas(String cpfUsuario) {

        String[]params ={cpfUsuario};
        String sql = "SELECT * FROM Consulta where cpfUsuario=?;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,params);
        List<Consulta> consultas = new ArrayList<Consulta>();
        while (c.moveToNext()){
            Consulta consulta = new Consulta();
            consulta.setTxCaso(c.getString(c.getColumnIndex("caso")));
            consulta.setCpfPaciente(c.getString(c.getColumnIndex("cpfPaciente")));
            consulta.setEspecialidade(c.getString(c.getColumnIndex("especialidade")));
            consulta.setTipoConsulta(c.getString(c.getColumnIndex("tipo")));
            consulta.setAtendida(c.getInt(c.getColumnIndex("atendida")));
            consulta.setCpfUsuario(c.getString(c.getColumnIndex("cpfUsuario")));
            consulta.setIdConsulta(c.getInt(c.getColumnIndex("idConsulta")));
            consultas.add(consulta);
        }
        c.close();
        return consultas;
    }

    public String verificaUsuario(String email, String senha) {
        SQLiteDatabase db = getWritableDatabase();
        String cpf =null;
        String [] params ={email,senha};
        String sql = "SELECT cpfUsuario FROM Usuario where emailUsuario =? AND senha =?;";
        Cursor c = db.rawQuery(sql,params);
        if(c.moveToNext()){

             cpf = c.getString(c.getColumnIndex("cpfUsuario")).toString();
        }

        c.close();
        return cpf;

    }

    public int verificaTipo(String cpfUsuario) {
        int idTipo =0;
        SQLiteDatabase db = getWritableDatabase();
        String [] params ={cpfUsuario};
        String sql = "SELECT idTipo FROM Usuario where cpfUsuario =?;";
        Cursor c = db.rawQuery(sql,params);
        if(c.moveToNext()){
            idTipo = c.getInt(c.getColumnIndex("idTipo"));
            c.close();

        }

    c.close();
        return idTipo;
    }

    public List<Consulta> getConsultasEspecialista() {


        String sql = "SELECT * FROM Consulta where atendida = 0;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,null);
        List<Consulta> consultas = new ArrayList<Consulta>();
        while (c.moveToNext()){
            Consulta consulta = new Consulta();
            consulta.setTxCaso(c.getString(c.getColumnIndex("caso")));
            consulta.setCpfPaciente(c.getString(c.getColumnIndex("cpfPaciente")));
            consulta.setEspecialidade(c.getString(c.getColumnIndex("especialidade")));
            consulta.setTipoConsulta(c.getString(c.getColumnIndex("tipo")));
            consulta.setAtendida(c.getInt(c.getColumnIndex("atendida")));
            consulta.setCpfUsuario(c.getString(c.getColumnIndex("cpfUsuario")));
            consulta.setIdConsulta(c.getInt(c.getColumnIndex("idConsulta")));
            consultas.add(consulta);
        }
        c.close();
        return consultas;
    }

    public Consulta getConsultaPorId(int idConsulta) {


        String[]params ={Integer.toString(idConsulta)};
        String sql = "SELECT * FROM Consulta where idConsulta=?;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql,params);

            c.moveToNext();
            Consulta consulta = new Consulta();
            consulta.setTxCaso(c.getString(c.getColumnIndex("caso")));
            consulta.setCpfPaciente(c.getString(c.getColumnIndex("cpfPaciente")));
            consulta.setEspecialidade(c.getString(c.getColumnIndex("especialidade")));
            consulta.setTipoConsulta(c.getString(c.getColumnIndex("tipo")));
            consulta.setAtendida(c.getInt(c.getColumnIndex("atendida")));
            consulta.setCpfUsuario(c.getString(c.getColumnIndex("cpfUsuario")));
            consulta.setIdConsulta(c.getInt(c.getColumnIndex("idConsulta")));

        c.close();
        return consulta;


    }


    public void insereParecer(int idConsulta, String parecer) {

        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = new ContentValues();
        dados.put("idConsulta",idConsulta);
        dados.put("textoParecer",parecer);
        db.insert("Parecer",null,dados);
    }

    public void atualizaAtendida(int idConsulta) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = {Integer.toString(idConsulta)};
        ContentValues dados = new ContentValues();
        dados.put("atendida",1);
        db.update("Consulta",dados,"idConsulta =?",params);

    }

    public String getTextoParecer(int idConsulta) {
        String textoParecer ="";

        SQLiteDatabase db = getWritableDatabase();
        String [] params = {Integer.toString(idConsulta)};
        String sql = "SELECT textoParecer FROM Parecer WHERE idConsulta=?;";
        Cursor c = db.rawQuery(sql,params);

        if(c.moveToNext()){
            textoParecer = c.getString(c.getColumnIndex("textoParecer"));
            c.close();
        }else {
            return null;
        }

        c.close();
        return textoParecer;

    }

    public void alteraUsuario(Solicitante solicitante) {

        SQLiteDatabase db = getWritableDatabase();
        String [] params = {solicitante.getAgenteCPF()};
        ContentValues dados = new ContentValues();
        dados.put("telefoneUsuario",solicitante.getAgenteTelefone());
        dados.put("unidadeUsuario",solicitante.getAgenteUnidade());
        dados.put("emailUsuario",solicitante.getAgenteEmail());
        dados.put("senha",solicitante.getAgenteSenha());
        db.update("Usuario",dados,"cpfUsuario=?",params);

    }

    public Solicitante buscaUsuario(String cpfUsuario) {

        SQLiteDatabase db = getWritableDatabase();
        String [] params = {cpfUsuario};
        String sql = "SELECT * FROM Usuario WHERE cpfUsuario =?";

        Cursor c = db.rawQuery(sql,params);

        c.moveToNext();
        Solicitante solicitante = new Solicitante();
        solicitante.setIdTipo(c.getInt(c.getColumnIndex("idTipo")));
        solicitante.setAgenteTelefone(c.getString(c.getColumnIndex("telefoneUsuario")));
        solicitante.setAgenteProfissao(c.getString(c.getColumnIndex("profissao")));
        solicitante.setAgenteUnidade(c.getString(c.getColumnIndex("unidadeUsuario")));
        solicitante.setAgenteNome(c.getString(c.getColumnIndex("nomeUsuario")));
        solicitante.setAgenteEmail(c.getString(c.getColumnIndex("emailUsuario")));
        solicitante.setAgenteCPF(c.getString(c.getColumnIndex("cpfUsuario")));

    c.close();
    return solicitante;
    }
}
