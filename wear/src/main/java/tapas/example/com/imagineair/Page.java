package tapas.example.com.imagineair;

import android.support.wearable.view.CardFragment;
import android.view.Gravity;

/**
 * Created by Ichirusaki on 25/10/14.
 */
public class Page {

    private String nombreTienda;
    private String descripcion;
    private int imagen;

    int cardGravity = Gravity.CENTER;
    boolean expansionEnabled = false;
    float expansionFactor = 1.0f;
    int expansionDirection = CardFragment.EXPAND_DOWN;

    public Page(String nombreTienda, String descripcion, int imagen) {
        this.nombreTienda = nombreTienda;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImagen() {
        return imagen;
    }
}
