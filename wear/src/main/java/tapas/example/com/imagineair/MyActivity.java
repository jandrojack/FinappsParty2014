package tapas.example.com.imagineair;
/**
 * Created by Tapas Behera on 22/07/2014.
 */
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.support.wearable.activity.InsetActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;


public class MyActivity  extends InsetActivity{
    private TextView mTextView;
    private static String TAG="WearActivity";
    private static final int SPEECH_REQUEST_CODE = 0;
    private View myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onReadyForContent() {
//        setContentView(R.layout.activity_my_wear);
//        setContentView(R.layout.rect_activity_my_wear);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(LAYOUT_INFLATER_SERVICE);
        myView  = inflater.inflate(R.layout.rect_activity_my, null);
        setContentView(myView);
        Resources res = getResources();
        ImageButton[] values = new ImageButton[5];
        values[0] =  new ImageButton(this);
        values[0].setBackground(res.getDrawable(R.drawable.moda));
        values[1] =  new ImageButton(this);
        values[1].setBackground(res.getDrawable(R.drawable.ocio));
        values[2] =  new ImageButton(this);
        values[2].setBackground(res.getDrawable(R.drawable.tecnologia));
        values[3] =  new ImageButton(this);
        values[3].setBackground(res.getDrawable(R.drawable.gastronomia));
        values[4] =  new ImageButton(this);
        values[4].setBackground(res.getDrawable(R.drawable.gastronomia));

        final ArrayList<ImageButton> list = new ArrayList<ImageButton>();
        for (int i = 0; i < values.length; ++i) {
            list.add(values[i]);
        }

        final ListView listView = (ListView) myView.findViewById(R.id.actionsListView);
        final ArrayAdapter<ImageButton> arrayAdapter = new ArrayAdapter<ImageButton>(this, android.R.layout.simple_list_item_1, values);
        // Assign adapter to ListView
        listView.setAdapter(arrayAdapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = (String) listView.getItemAtPosition(position);
                // Show Alert
                if (position == 0) {
                    Intent modaIntent = new Intent(MyActivity.this, ModaIntent.class);
                    MyActivity.this.startActivity(modaIntent);
                } else if (position == 1) {
                    Intent ocioIntent = new Intent(MyActivity.this, OcioIntent.class);
                    MyActivity.this.startActivity(ocioIntent);
                }else if (position == 2) {
                    Intent tecnologiaIntent = new Intent(MyActivity.this, TecnologiaIntent.class);
                    MyActivity.this.startActivity(tecnologiaIntent);
                }else if (position == 3) {
                    Intent gastronomiaIntent = new Intent(MyActivity.this, GastronomiaIntent.class);
                    MyActivity.this.startActivity(gastronomiaIntent);
                }
            }
        });
    }
}