package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;

public class UserDashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.userDash_Sair);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Clique para retornar à tela inicial", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                inicio();
            }
        });

        ImageButton contentDash_newConsulta = (ImageButton)findViewById(R.id.contentDash_newConsulta);
        contentDash_newConsulta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nova_consulta();
            }
        });

        ImageButton contentDash_verConsultas = (ImageButton)findViewById(R.id.contentDash_verConsultas);
        contentDash_verConsultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listar_consultas();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.user__dashboard, menu);
        return true;
    }
    */
//tentar tirar este item
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navHeader_altDados) {
       // mostrar dados do usuário ativo
        } else if (id == R.id.navHeader_logOut) {
        //inserir método para deslogar da conta ativa
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void nova_consulta(){
        Intent nc = new Intent(UserDashboard.this, NovaConsulta.class);
        startActivity(nc);
    }

    public void listar_consultas(){
        Intent lc = new Intent(UserDashboard.this, ConsultListView.class);
        startActivity(lc);
    }

    public void inicio(){
        Intent ini = new Intent(UserDashboard.this, MainActivity.class);
        startActivity(ini);
    }
}
