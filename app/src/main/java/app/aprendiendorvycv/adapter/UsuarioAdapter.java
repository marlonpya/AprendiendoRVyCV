package app.aprendiendorvycv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.aprendiendorvycv.ClaseRow;
import app.aprendiendorvycv.R;
import app.aprendiendorvycv.model.Usuario;

/**
 * Created by marlonpya on 15/01/17.
 */

public class UsuarioAdapter extends RecyclerView.Adapter<ClaseRow> {
    private Context context;
    private ArrayList<Usuario> lista_usuario;
    private LayoutInflater inflater;

    public UsuarioAdapter(Context context, ArrayList<Usuario> usuario) {
        this.context = context;
        this.lista_usuario = usuario;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public ClaseRow onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ClaseRow(inflater.inflate(R.layout.row_usuario, parent, false));
    }

    @Override
    public void onBindViewHolder(ClaseRow holder, int position) {

        final Usuario item = this.lista_usuario.get(position);

        holder.nombre.setText(item.getNombre());
        holder.edad.setText(String.valueOf(item.getEdad()));
        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("User", item.toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista_usuario.size();
    }
}
