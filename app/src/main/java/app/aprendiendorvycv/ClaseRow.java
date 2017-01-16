package app.aprendiendorvycv;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by marlonpya on 15/01/17.
 */

public class ClaseRow extends RecyclerView.ViewHolder{

    public @BindView(R.id.etNombre) TextView nombre;
    public @BindView(R.id.etEdad) TextView edad;

    public ClaseRow(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
