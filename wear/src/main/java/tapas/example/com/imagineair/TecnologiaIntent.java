package tapas.example.com.imagineair;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;
import android.view.View;
import android.view.WindowInsets;

/**
 * Created by Ichirusaki on 25/10/14.
 */
public class TecnologiaIntent extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnologia_intent);
        final Resources res = getResources();
        final GridViewPager pager = (GridViewPager) findViewById(R.id.tecnologia_pager);
        pager.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsets onApplyWindowInsets(View v, WindowInsets insets) {
                // Adjust page margins:
                //   A little extra horizontal spacing between pages looks a bit
                //   less crowded on a round display.
                final boolean round = insets.isRound();
                int rowMargin = res.getDimensionPixelOffset(R.dimen.page_row_margin);
                int colMargin = res.getDimensionPixelOffset(round ?
                        R.dimen.page_column_margin_round : R.dimen.page_column_margin);
                pager.setPageMargins(rowMargin, colMargin);
                return insets;
            }
        });
        pager.setAdapter(new TecnologiaAdapter(this, getFragmentManager()));
    }
}