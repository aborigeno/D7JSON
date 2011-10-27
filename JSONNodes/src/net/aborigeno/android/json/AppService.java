package net.aborigeno.android.json;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.aborigeno.android.json.dupal.App;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class AppService extends Service {
	private final static String TAG = "AppIntentService";
	private static final String urlBase = "Base URL";

	Gson gson;

	private final IBinder mBinder = new AppBinder();

	/**
	 * Class used for the client Binder. Because we know this service always
	 * runs in the same process as its clients, we don't need to deal with IPC.
	 */
	public class AppBinder extends Binder {
		AppService getService() {
			// Return this instance of LocalService so clients can call public
			// methods
			return AppService.this;
		}
	}


	public App getApp(int nid) {

		App n = null;
		try {
			final String url = 	urlBase+nid+".json";

			final String jsonString = convertStreamToString(getInputStreamFromUrl(url));
			n = gson.fromJson(jsonString, App.class);

			Log.d(TAG, n.getField_version().getUnd()[0].getValue());
			Log.d(TAG, n.getField_apk().getUnd().getUri());

		} catch (JsonSyntaxException je) {
			je.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return n;
	}

	public static String convertStreamToString(InputStream is) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		is.close();
		return sb.toString();
	}

	public static InputStream getInputStreamFromUrl(String url) {
		InputStream content = null;
		try {
			HttpClient httpclient = new DefaultHttpClient();

			HttpResponse response = httpclient.execute(new HttpGet(url));
			content = response.getEntity().getContent();
		} catch (Exception e) {
			Log.d("[GET REQUEST]", "Network exception " + e.getMessage());
			e.printStackTrace();
		}
		return content;
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "service binded", Toast.LENGTH_SHORT).show();
		return mBinder;
	}

	@Override
	public void onCreate() {
		gson = new Gson();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		Toast.makeText(this, "service destroy", Toast.LENGTH_SHORT).show();
		super.onDestroy();
	}
}
