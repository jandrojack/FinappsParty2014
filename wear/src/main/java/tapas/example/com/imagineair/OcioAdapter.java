package tapas.example.com.imagineair;

/**
 * Created by Tapas Behera on 22/07/2014.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.ImageReference;
import android.view.Gravity;

public class OcioAdapter extends FragmentGridPagerAdapter {

    private final Context mContext;

    public OcioAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        mContext = ctx;
    }

    static final int[][] BG_IMAGES = new int[][] {
            {
                    R.drawable.shopcheck_bg,
            },
    };


    private final Page[][] PAGES = {
            {
                    new Page("Bolera","No Web", R.drawable.bolera),
                    new Page("2x1","Grupos de 5 personas, paga una partida y la segunda de regalo", R.drawable.bolera),
                    new Page("IA634","Boarding", R.drawable.bolera),
                    new Page("IA087","Delayed 30 min", R.drawable.bolera),
            },
            {
                    new Page("Cines Box","www.boxcinema.net", R.drawable.cines),
                    new Page("Oferta Parejas","Entradas 2X1 en la sesion de la 01:00am", R.drawable.cines),
                    new Page("IA634","Boarding", R.drawable.cines),
                    new Page("IA087","Delayed 30 min", R.drawable.cines),
            },
            {
                    new Page("FNAC","www.fnac.com", R.drawable.fnac),
                    new Page("IA656","Departed", R.drawable.fnac),
                    new Page("IA634","Boarding", R.drawable.fnac),
                    new Page("IA087","Delayed 30 min", R.drawable.fnac),
            },
            {
                    new Page("Recreativos","No Web", R.drawable.recreativo),
                    new Page("IA656","Departed", R.drawable.recreativo),
                    new Page("IA634","Boarding", R.drawable.recreativo),
                    new Page("IA087","Delayed 30 min", R.drawable.recreativo),
            },

    };


    @Override
    public Fragment getFragment(int row, int col) {
        Page page = PAGES[row][col];
        String title = page.getNombreTienda();
        String text = page.getDescripcion();
        int image = page.getImagen();
        CardFragment fragment = CardFragment.create(title, text, image);
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

