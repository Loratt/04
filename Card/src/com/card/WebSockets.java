package com.card;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.widget.Button;
import android.widget.Toast;
import de.tavendo.autobahn.WebSocket;
import de.tavendo.autobahn.WebSocketConnection;
import de.tavendo.autobahn.WebSocketConnectionHandler;
import de.tavendo.autobahn.WebSocketException;

class WebSockets {

	private Boolean result = false;
	private Button ok;
	private Context contest;

	static final String TAG = WebSockets.class.getSimpleName();

	public WebSockets(Context context, Button button) {
		ok = button;
		this.contest = context;
	}

	public void startWebSockets() {

		final WebSocket mConnection = (WebSocket) new WebSocketConnection();

		final String wsuri = "ws://10.0.3.2:8888/websocket";

		try {
			mConnection.connect(wsuri, new WebSocketConnectionHandler() {
				@Override
				public void onOpen() {
					mConnection.sendTextMessage("Place order");
				}

				@Override
				public void onTextMessage(String payload) {
					if (payload.equalsIgnoreCase("OK")) {
						result = true;
					}
					mConnection.disconnect();
				}

				@Override
				public void onClose(int code, String reason) {
					complete(result);
				}
			});
		} catch (WebSocketException e) {

			Log.d(TAG, e.toString());
		}

	}

	protected void complete(Boolean result) {
		if (result == true) {
			ok.setText("Confirmed");
		} else {
			ok.setText("OK");
			ok.setEnabled(true);
			ok.setTextColor(Color.WHITE);
			Toast toast = Toast.makeText(contest, "Error connection to the server", Toast.LENGTH_LONG);
			toast.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL, 0, 0);
			toast.show();
		}
	}

}