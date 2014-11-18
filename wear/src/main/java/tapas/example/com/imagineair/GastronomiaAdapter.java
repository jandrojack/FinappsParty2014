package tapas.example.com.imagineair;


/**
 * Created by TickClick on 25/10/2014 for the FinappsParty
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.ImageReference;
import android.view.Gravity;

public class GastronomiaAdapter extends FragmentGridPagerAdapter {

    private final Context mContext;

    public GastronomiaAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        mContext = ctx;
    }

    static final int[][] BG_IMAGES = new int[][] {
            {
                    R.drawable.shopcheck_bg,
            },
    };

    // DE NORMAL, ESTA MATRIZ SE CREA A PARTIR DE UN FICHERO EN EL SERVIDOR O UNA BASE DE DATOS.
    // PARA LAS PRUEBAS, LA CREAMOS AQUÍ
    private final Page[][] PAGES = {
            {
                    new Page("100 Montaditos","spain.cienmontaditos.com", R.drawable.cienmontaditos),
                    new Page("1€","Todos los miercoles, todos los productos a 1€",R.drawable.cienmontaditos),
                    new Page("Oferta 2","Esto es otra oferta",R.drawable.cienmontaditos),
                    new Page("Oferta 3","Y una oferta mas",R.drawable.cienmontaditos),
            },
            {
                    new Page("Duffin Dagels","www.duffindagels.es",R.drawable.donuts),
                    new Page("Oferta 1","Late 15 min",R.drawable.donuts),
                    new Page("Oferta 4","Arrived from Denver",R.drawable.donuts),
                    new Page("No sabemos contar","Late 20 min",R.drawable.donuts),
            },
            {
                    new Page("McDonalds","www.mcdonalds.com",R.drawable.mcdonals),
                    new Page("Super oferta","2 hamburquesas + patatas + 2 bebidas por 6.65€",R.drawable.mcdonals),
                    new Page("Oferta 010","Late 10 min",R.drawable.mcdonals),
                    new Page("Oferta 011","Late 20 min",R.drawable.mcdonals),
                    new Page("Oferta 100","Alla a las 10",R.drawable.mcdonals),
            },
            {
                    new Page("Pizzeria","No Web",R.drawable.pizzeria),
                    new Page("Oferta A","Arrived from SFO",R.drawable.pizzeria),
                    new Page("Oferta B","Late 10 min",R.drawable.pizzeria),
                    new Page("Oferta C","Late 20 min",R.drawable.pizzeria),
            },

    };

    @Override
    public Fragment getFragment(int row, int col) {
        Page page = PAGES[row][col];
        String title = page.getNombreTienda();
        String text = page.getDescripcion();
        int image = page.getImagen();
        CardFragment fragment = CardFragment.create(title, text, image);  //ESTA ES LA IMAGEN
        // Advanced settings
        fragment.setCardGravity(page.cardGravity);
        fragment.setExpansionEnabled(page.expansionEnabled);
        fragment.setExpansionDirection(page.expansionDirection);
        fragment.setExpansionFactor(page.expansionFactor);
        return fragment;
    }

    @Override
    public ImageReference getBackground(int row, int column) {
        return ImageReference.forDrawable(BG_IMAGES[0][0]);
    }

    @Override
    public int getRowCount() {
        return PAGES.length;
    }

    @Override
    public int getColumnCount(int rowNum) {
        return PAGES[rowNum].length;
    }
}

