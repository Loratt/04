package com.card;

import java.util.Calendar;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

public class DataAutoFormatField implements TextWatcher {

	private String current = "";
	private String ddmm = "    ";
	private Button next;
	private Button ok;
	private Calendar cal = Calendar.getInstance();
	private EditText data;
	private EditText cvv;

	public DataAutoFormatField(EditText data, EditText cvv, Button next, Button ok) {
		this.data = data;
		this.cvv = cvv;
		this.next = next;
		this.ok = ok;

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		if (!s.toString().equals(current)) {

			next.setEnabled(false);
			String clean = s.toString().replaceAll("[^\\d.]", "");
			String cleanC = current.replaceAll("[^\\d.]", "");

			int cl = clean.length();
			int sel = cl;
			for (int i = 2; i <= cl && i < 6; i += 2) {
				sel++;
			}
			if (clean.equals(cleanC))
				sel--;

			if (clean.length() < 4) {

				next.setEnabled(false);
				next.setTextColor(Color.GRAY);
				ok.setTextColor(Color.GRAY);
				ok.setEnabled(false);

				clean = clean + ddmm.substring(clean.length());
			} else {

				next.setEnabled(true);
				next.setTextColor(Color.WHITE);

				int day = Integer.parseInt(clean.substring(0, 2));
				int mon = Integer.parseInt(clean.substring(2, 4));

				if (mon > 12)
					mon = 12;
				cal.set(Calendar.MONTH, mon - 1);

				day = (day > cal.getActualMaximum(Calendar.DATE)) ? cal.getActualMaximum(Calendar.DATE) : day;
				clean = String.format("%02d%02d", day, mon);

				if (cvv.length() == 3) {
					ok.setEnabled(true);
					ok.setTextColor(Color.WHITE);
				}
			}

			clean = String.format("%s/%s", clean.substring(0, 2), clean.substring(2, 4));

			sel = sel < 0 ? 0 : sel;
			current = clean;
			data.setText(current);
			data.setSelection(sel < current.length() ? sel : current.length());
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}

	@Override
	public void afterTextChanged(Editable s) {
	}
}
