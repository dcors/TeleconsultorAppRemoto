package com.example.dehcors.teleconsultorapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dehcors.teleconsultorapp.DAO.GenericDAO;

public class UserDashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String cpfUsuario ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        cpfUsuario = intent.getStringExtra("cpfUsuario");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView arquivos = (TextView) findViewById(R.id.dashboardtxtverarquivo);
        GenericDAO dao = new GenericDAO(this);
        int idTipo = dao.verificaTipo(cpfUsuario);
        if(idTipo ==1){

            arquivos.setText("Visualizar Teleconsultorias");
        }else {
            arquivos.setText("Atender Teleconsultorias");
        }




        ImageButton userDash_nConsult = (ImageButton) findViewById(R.id.userDash_newConsul);
        userDash_nConsult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nova_consulta();
            }
        });

        ImageButton userDash_verConsulta = (ImageButton) findViewById(R.id.userDash_verArquivo);
        userDash_verConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listar_consultas()
                ;
            }
        });

        ImageButton userDash_newDiag = (ImageButton) findViewById(R.id.userDash_newDiagnostico);
        userDash_newDiag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novo_diagnostico();
            }
        });

        ImageButton userDash_relatorios = (ImageButton) findViewById(R.id.userDash_relatorios);
        userDash_relatorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent irelat = new Intent(UserDashboard.this, RelatoriosView.class);
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navHeader_avisos) {
            AlertDialog.Builder alert1 = new AlertDialog.Builder(UserDashboard.this);
            alert1.setTitle("CONSULTORIAS");
            alert1.setMessage("Você não possui consultorias pendentes de resposta");
            alert1.setIcon(R.drawable.logoa);
            alert1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog1, int wich) {
                    dialog1.cancel();
                }
            });
            alert1.show();

        } else if (id == R.id.navHeader_clinicas) {
            Intent itClin = new Intent(UserDashboard.this, VerClinicas.class);
            startActivity(itClin);
        } else if (id == R.id.navHeader_altDados) {
            Intent ituser = new Intent(UserDashboard.this, UsuarioLogado.class);
            ituser.putExtra("cpfUsuario",cpfUsuario);
            startActivity(ituser);
        } else if (id == R.id.navHeader_logOut) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(UserDashboard.this);
            alertDialog.setTitle("DESLOGAR");
            alertDialog.setMessage("Você realmente deseja sair da sua conta?");
            alertDialog.setIcon(R.drawable.ic_logout_variant_black_36dp);
            alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int wich) {
                    Toast.makeText(UserDashboard.this.getApplicationContext(),
                            "Até breve...", Toast.LENGTH_SHORT).show();
                    UserDashboard.this.finish();
                }
            });
            alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int wich) {
                    Toast.makeText(UserDashboard.this.getApplicationContext(),
                            "Seguindo em frente!", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });
            alertDialog.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void nova_consulta() {
        Intent nc = new Intent(UserDashboard.this, NovaConsulta.class);
        nc.putExtra("cpfUsuario",cpfUsuario);
        startActivity(nc);

    }

    public void novo_diagnostico() {
        Intent nd = new Intent(UserDashboard.this, NovoDiagnostico.class);
        nd.putExtra("cpfUsuario",cpfUsuario);
        startActivity(nd);

    }

    public void listar_consultas() {
        Intent lc = new Intent(UserDashboard.this, ListaDeConsultas.class);
        lc.putExtra("cpfUsuario",cpfUsuario);
        startActivity(lc);

    }


}