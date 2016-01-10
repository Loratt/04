package com.card;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class CVVAutoFormatField implements TextWatcher {

	private EditText cvv;
	private Button ok;

	public CVVAutoFormatField(EditText cvv, Button ok) {

		this.cvv = cvv;
		this.ok = ok;

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {

		if (cvv.length() == 3) {
			ok.setEnabled(true);
			ok.setTextColor(Color.WHITE);
		}
		if (cvv.length() == 2) {
			ok.setEnabled(false);
			ok.setTextColor(Color.GRAY);
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}

	@Override
	public void afterTextChanged(Editable s) {
	}
}
