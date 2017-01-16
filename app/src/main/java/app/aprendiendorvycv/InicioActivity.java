package app.aprendiendorvycv;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import app.aprendiendorvycv.adapter.UsuarioAdapter;
import app.aprendiendorvycv.app.BaseActivity;
import app.aprendiendorvycv.model.Usuario;
import butterknife.BindView;

public class InicioActivity extends BaseActivity {
    @BindView(R.id.rv_lista) RecyclerView recyclerView;
    private UsuarioAdapter adapter;
    private ArrayList<Usuario> lista_usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        iniciarRV();
    }

    private void iniciarRV() {
        lista_usuarios = new ArrayList<>();
        lista_usuarios.add(new Usuario("Sheyla", 11));
        lista_usuarios.add(new Usuario("José", 12));

        adapter = new UsuarioAdapter(this, lista_usuarios);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}
