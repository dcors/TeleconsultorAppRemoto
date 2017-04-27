package com.example.dehcors.teleconsultorapp.DAO;

import android.os.AsyncTask;
import android.widget.Toast;

import com.example.dehcors.teleconsultorapp.NovoUsuario;
import com.example.dehcors.teleconsultorapp.Usuario;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Icons4u TI on 26/04/2017.
 */

public class TeleconsultoriaDAO extends AsyncTask<String,Void,String> {

    public TeleconsultoriaDAO() {

    }

    @Override
    protected String doInBackground(String... params) {

        String  user ="";

        try {
            URL url = new URL("http://104.131.181.32:3000/login?email="+params[0]+"&senha="+params[1]);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer("");
            while ((user = br.readLine()) != null){
                sb.append(user);
            }
            user = sb.toString();
            br.close();
            connection.disconnect();
        }catch (Exception execao){
            return execao.toString()+" Caso 1";
        }

        return user;
    }

    public String getLogin(String email, String password) throws MalformedURLException , Exception{
            String resultado= "";

        try {
             resultado = new TeleconsultoriaDAO().execute(email,password).get();
            return resultado;
        }catch (Exception ex){
            return ex.toString()+" Caso 2";
        }

    }


}
