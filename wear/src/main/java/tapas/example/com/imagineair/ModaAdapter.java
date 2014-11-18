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

public class ModaAdapter extends FragmentGridPagerAdapter {

    private final Context mContext;

    public ModaAdapter(Context ctx, FragmentManager fm) {
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
                    new Page("Bershka","www.bershka.com", R.drawable.bershka),
                    new Page("Oferta 1","Esto es una oferta",R.drawable.bershka),
                    new Page("Oferta 2","Esto es otra oferta",R.drawable.bershka),
                    new Page("Oferta 3","Y una oferta mas",R.drawable.bershka),
            },
            {
                    new Page("Gucci","www.gucci.com",R.drawable.gucci),
                    new Page("Oferta 1","Late 15 min",R.drawable.gucci),
                    new Page("Oferta 4","Arrived from Denver",R.drawable.gucci),
                    new Page("No sabemos contar","Late 20 min",R.drawable.gucci),
            },
            {
                    new Page("Mango","www.mango.com",R.drawable.mango),
                    new Page("Oferta 001","Arrived from SFO",R.drawable.mango),
                    new Page("Oferta 010","Late 10 min",R.drawable.mango),
                    new Page("Oferta 011","Late 20 min",R.drawable.mango),
                    new Page("Oferta 100","Alla a las 10",R.drawable.mango),
            },
            {
                    new Page("Sprinter","www.sprinter.es",R.drawable.sprinter),
                    new Page("Oferta A","Arrived from SFO",R.drawable.sprinter),
                    new Page("Oferta B","Late 10 min",R.drawable.sprinter),
                    new Page("Oferta C","Late 20 min",R.drawable.sprinter),
            },
            {
                    new Page("TOUS","www.tous.com",R.drawable.tous),
                    new Page("Oferta 1","Arrived from SFO",R.drawable.tous),
                    new Page("Oferta 2","Late 10 min",R.drawable.tous),
            },
            {
                    new Page("Converse","www.converse.com",R.drawable.converse),
                    new Page("Oferta 1","Arrived from SFO",R.drawable.converse),
                    new Page("Oferta 2","Late 10 min",R.drawable.converse),
                    new Page("Oferta 3","Late 20 min",R.drawable.converse),
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

