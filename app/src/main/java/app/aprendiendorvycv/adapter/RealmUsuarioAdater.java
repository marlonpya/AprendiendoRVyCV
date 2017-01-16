package app.aprendiendorvycv.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.aprendiendorvycv.R;
import app.aprendiendorvycv.model.RealmUsuario;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;

/**
 * Created by marlonpya on 15/01/17.
 */

public class RealmUsuarioAdater extends RealmBasedRecyclerViewAdapter<RealmUsuario, RealmUsuarioAdater.ViewHolder> {

    public RealmUsuarioAdater(
            Context context,
            RealmResults<RealmUsuario> realmResults) {
        super(context, realmResults, true, true);
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(inflater.inflate(R.layout.row_usuario, viewGroup, false));
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int position) {
        final RealmUsuario item = realmResults.get(position);
        viewHolder.nombre.setText(item.getNombre());
        viewHolder.edad.setText(String.valueOf(item.getEdad()));
    }

    public class ViewHolder extends RealmViewHolder {
        @BindView(R.id.etNombre) TextView nombre;
        @BindView(R.id.etEdad) TextView edad;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
