package tapas.example.com.imagineair;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class AtomPayListAdapter extends ArrayAdapter<AtomPayment> {

	protected static final String LOG_TAG = AtomPayListAdapter.class.getSimpleName();
	
	private List<AtomPayment> items;
	private int layoutResourceId;
	private Context context;

	public AtomPayListAdapter(Context context, int layoutResourceId, List<AtomPayment> items) {
		super(context, layoutResourceId, items);
		this.layoutResourceId = layoutResourceId;
		this.context = context;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		AtomPaymentHolder holder = null;

		LayoutInflater inflater = ((Activity) context).getLayoutInflater();
		row = inflater.inflate(layoutResourceId, parent, false);

		holder = new AtomPaymentHolder();
		holder.atomPayment = items.get(position);
		holder.removePaymentButton = (ImageButton)row.findViewById(R.id.atomPay_removePay);
		holder.removePaymentButton.setTag(holder.atomPayment);

		row.setTag(holder);

		return row;
	}


	public static class AtomPaymentHolder {
		AtomPayment atomPayment;
		ImageButton removePaymentButton;
	}
	
	private void setNameTextChangeListener(final AtomPaymentHolder holder) {
		holder.name.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				holder.atomPayment.setName(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

			@Override
			public void afterTextChanged(Editable s) { }
		});
	}

	private void setValueTextListeners(final AtomPaymentHolder holder) {
		holder.value.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				try{
					holder.atomPayment.setValue(Double.parseDouble(s.toString()));
				}catch (NumberFormatException e) {
					Log.e(LOG_TAG, "error reading double value: " + s.toString());
				}
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

			@Override
			public void afterTextChanged(Editable s) { }
		});
	}
}
