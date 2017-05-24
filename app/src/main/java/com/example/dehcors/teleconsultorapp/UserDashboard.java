package com.example.dehcors.teleconsultorapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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
                finishAffinity();
            }
        });

       ImageButton userDash_newConsulta = (ImageButton)findViewById(R.id.userDash_newConsul);
        userDash_newConsulta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                nova_consulta();
            }
        });

        ImageButton userDash_verConsulta = (ImageButton)findViewById(R.id.userDash_verConsulta);
        userDash_verConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listar_consultas();
            }
        });

        ImageButton userDash_rotas = (ImageButton)findViewById(R.id.userDash_rotas);
        userDash_rotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historico_rotas();
            }
        });

        ImageButton userDash_relatorios = (ImageButton)findViewById(R.id.userDash_relatorios);
        userDash_relatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irelat = new Intent(UserDashboard.this, RelatoriosActivity.class);
                startActivity(irelat);
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



//tentar tirar este item


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

    public void historico_rotas(){
        Intent ir = new Intent(UserDashboard.this, RotaActivity.class);
        startActivity(ir);
    }


}
