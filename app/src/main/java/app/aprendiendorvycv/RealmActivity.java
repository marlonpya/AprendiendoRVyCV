package app.aprendiendorvycv;

import android.os.Bundle;

import app.aprendiendorvycv.adapter.RealmUsuarioAdater;
import app.aprendiendorvycv.app.BaseActivity;
import app.aprendiendorvycv.model.RealmUsuario;
import butterknife.BindView;
import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;

public class RealmActivity extends BaseActivity {
    @BindView(R.id.rv_realm_lista) RealmRecyclerView realmRecyclerView;
    private RealmUsuarioAdater adater;
    private Realm realm;
    private RealmResults<RealmUsuario> realm_lista_usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);

        realm = Realm.getDefaultInstance();

        guardarUsuarios();
        iniciarRealmRV();
    }

    private void guardarUsuarios() {
        for (int i = 0; i < 10; i++) {
            realm.beginTransaction();
            RealmUsuario usuario = realm.createObject(RealmUsuario.class, RealmUsuario.getUltimoId());
            usuario.setNombre("sheyla");
            usuario.setEdad(11);
            realm.copyToRealm(usuario);

            RealmUsuario usuario2 = realm.createObject(RealmUsuario.class, RealmUsuario.getUltimoId());
            usuario2.setNombre("Josè");
            usuario2.setEdad(31);
            realm.copyToRealm(usuario2);
            realm.commitTransaction();
        }
    }

    private void iniciarRealmRV() {
        realm_lista_usuarios = realm.where(RealmUsuario.class).findAll();
        adater = new RealmUsuarioAdater(this, realm_lista_usuarios);
        realmRecyclerView.setAdapter(adater);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) realm.close();
    }
}
