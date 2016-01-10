package com.card;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CardAutoFormatField implements TextWatcher {

	private int length_before;
	private final String TAG = "PhoneAutoRormatField";
	private EditText card_number;
	private EditText data;
	private EditText cvv;
	private ImageView card;
	private Button next;
	private Button done;
	private String tempNumber;
	private LinearLayout layout;
	private String formated;
	private int set_position;
	private Context context;
	private int STATE;

	public CardAutoFormatField(EditText card_number, EditText data, EditText cvv, ImageView imageView,
			LinearLayout layout, Context context, Button next, Button done) {

		this.card_number = card_number;
		this.data = data;
		this.cvv = cvv;
		this.card = imageView;
		this.layout = layout;
		this.context = context;
		this.next = next;
		this.done = done;
		this.formated = "";

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		try {
			if (s.toString().length() == 0) {
				card.setImageResource(R.drawable.cc_front);
				card.setTag(1);
				return;
			}
			card_number.removeTextChangedListener(this);
			tempNumber = s.toString();
			tempNumber = tempNumber.replaceAll(" ", "");

			long prefix = Long.parseLong(tempNumber);

			if (tempNumber.length() == 1) {

				if (prefix == 4) {
					card.setImageResource(R.drawable.cc_visa);
					card.setTag(2);
					layout.setBackgroundResource(R.drawable.rounded_edittext);
					STATE = 1;
				}
			}

			else if (tempNumber.length() == 2) {

				if (prefix >= 51 && prefix <= 55) {
					card.setImageResource(R.drawable.cc_mc);
					layout.setBackgroundResource(R.drawable.rounded_edittext);
					STATE = 2;
				}

				else if (prefix == 37 || prefix == 34) {
					card.setImageResource(R.drawable.cc_amex);
					layout.setBackgroundResource(R.drawable.rounded_edittext);
					STATE = 3;
				}
			}

			else if (tempNumber.length() == 4) {

				if (prefix == 6011) {
					card.setImageResource(R.drawable.cc_disc);
					layout.setBackgroundResource(R.drawable.rounded_edittext);
					STATE = 4;
				}
			}

			for (int i = 0; i < tempNumber.length(); i++) {

				if (i == 4 && tempNumber.charAt(i) != " ".charAt(0)) {
					formated += " ";
				}
				if (i == 8 && tempNumber.charAt(i) != " ".charAt(0)) {
					formated += " ";
				}
				if (i == 12 && tempNumber.charAt(i) != " ".charAt(0)) {
					formated += " ";
				}
				if (i == 14 && tempNumber.charAt(i) != " ".charAt(0)) {
					next.setTextColor(Color.GRAY);
					next.setEnabled(false);
					done.setTextColor(Color.GRAY);
					done.setEnabled(false);
				}
				if (i == 15 && tempNumber.charAt(i) != " ".charAt(0)) {
					if (card.getDrawable().getConstantState() == ContextCompat.getDrawable(context, R.drawable.cc_front)
							.getConstantState()) {
						layout.setBackgroundResource(R.drawable.rounded_edittext_red);
					} else {
						next.setTextColor(Color.WHITE);
						next.setEnabled(true);
							
						if (cvv.length() == 3 && !data.getText().toString().substring(4).equalsIgnoreCase(" ")) {
							done.setTextColor(Color.WHITE);
							done.setEnabled(true);
						}
					}
				}

				formated += tempNumber.charAt(i);
			}

			card_number.setText(formated);

			if (length_before < formated.length()) {

				if (formated.charAt(start) == " ".charAt(0)) {
					set_position = start + 2;
				} else {
					set_position = start + 1;
				}

			} else if (length_before > formated.length()) {
				if (s.toString().charAt(((start - 1) == -1) ? 0 : (start - 1)) == " ".charAt(0)) {
					set_position = start - 1;
				} else {
					set_position = start;
				}
			} else {
				set_position = start;
			}

			card_number.setSelection(set_position);

			card_number.addTextChangedListener(this);
		}catch(

	IndexOutOfBoundsException e)

	{
		Log.v(TAG, "Index out of bounds: " + e.getMessage());
	} catch(

	Exception e)

	{
		Log.v(TAG, e.toString());
	}

	}

	public int getCard() {
		return STATE;
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		this.length_before = s.toString().length();
	}

	@Override
	public void afterTextChanged(Editable s) {
		formated = "";
	}
}
