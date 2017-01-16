package app.aprendiendorvycv.model;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by marlonpya on 15/01/17.
 */

public class RealmUsuario extends RealmObject {
    public static final String ID = "id";

    public static int getUltimoId() {
        Realm realm = Realm.getDefaultInstance();
        Number number = realm.where(RealmUsuario.class).max(ID);
        return number == null ? 0 : number.intValue() + 1;
    }

    @PrimaryKey
    private long id;
    private String nombre;
    private int edad;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
