package com.card;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText code;
	private EditText data;
	private EditText cvv;
	private TextView short_code;
	private LinearLayout container;
	private ImageView card;
	private Button previous;
	private Button next;
	private Button ok;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		code = (EditText) findViewById(R.id.edit_text);
		data = (EditText) findViewById(R.id.data);
		cvv = (EditText) findViewById(R.id.cvv);

		short_code = (TextView) findViewById(R.id.short_code);
		card = (ImageView) findViewById(R.id.image);

		previous = (Button) findViewById(R.id.previous);
		next = (Button) findViewById(R.id.next);
		ok = (Button) findViewById(R.id.ok);

		container = (LinearLayout) findViewById(R.id.edit_text_container);

		final CardAutoFormatField card_number = new CardAutoFormatField(code, data, cvv, card, container,
				getApplicationContext(), next, ok);
		code.addTextChangedListener(card_number);
		data.addTextChangedListener(new DataAutoFormatField(data, cvv, next, ok));
		cvv.addTextChangedListener(new CVVAutoFormatField(cvv, ok));
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ok.setText("Processing...");
				ok.setEnabled(false);
				ok.setTextColor(Color.GRAY);
				new WebSockets(getApplicationContext(), ok).startWebSockets();	
			}
		});

		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				previous.setEnabled(true);
				previous.setTextColor(Color.WHITE);

				if (code.getVisibility() == View.VISIBLE) {
					if (code.length() == 19 && card.getDrawable().getConstantState() != ContextCompat
							.getDrawable(getApplicationContext(), R.drawable.cc_front).getConstantState()) {
						short_code.setText(code.getText().toString().substring(0, 4));
						code.setVisibility(View.GONE);
						;
						data.setEnabled(true);
						data.requestFocus();
						if (data.getText().toString().equalsIgnoreCase("")
								|| data.getText().toString().substring(4).equalsIgnoreCase(" ")) {
							next.setTextColor(Color.GRAY);
							next.setEnabled(false);
						}
					}
				}

				else if (data.length() == 5 && data.isEnabled() == true) {
					cvv.setEnabled(true);
					cvv.requestFocus();
					data.setEnabled(false);
					card.setImageResource(R.drawable.cc_back);
					card.setTag(3);
					next.setEnabled(false);
					next.setTextColor(Color.GRAY);
				}
			}
		});

		previous.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				next.setEnabled(true);
				next.setTextColor(Color.WHITE);

				if (cvv.isEnabled()) {
					data.setEnabled(true);
					data.requestFocus();
					cvv.setEnabled(false);
					switch (card_number.getCard()) {
					case 1:

						card.setImageResource(R.drawable.cc_visa);
						break;
					case 2:
						card.setImageResource(R.drawable.cc_mc);
						break;
					case 3:
						card.setImageResource(R.drawable.cc_amex);
						break;
					case 4:
						card.setImageResource(R.drawable.cc_disc);
						break;

					default:
						break;
					}

				} else if (data.getVisibility() == View.VISIBLE) {
					code.setVisibility(View.VISIBLE);
					code.setEnabled(true);
					code.requestFocus();
					previous.setEnabled(false);
					previous.setTextColor(Color.GRAY);
				}
			}
		});

	}
}
