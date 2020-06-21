package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static String SSID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SSID = "YOUR_FKING_SSID";

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

connectToWifi(SSID, fuckingpassword );
    }

   /* public String ПЕРЕБОРНИК С ПАРОЛЯМИ(String pass) {
        int success = 0;
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        while (success == 0) {


            try {

                connectToWifi(SSID, pass);

            } catch (Exception e) {

            }


            if (mWifi.isConnected()) {
                success = 1;
            } else Log.e("NOT", pass);
        }

        return null;
    }
*/


    private void connectToWifi(final String networkSSID, final String networkPassword) throws InterruptedException {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = String.format("\"%s\"", networkSSID);
        conf.preSharedKey = String.format("\"%s\"", networkPassword);

        int netId = wifiManager.addNetwork(conf);
        wifiManager.disconnect();
        wifiManager.enableNetwork(netId, true);

        Thread.sleep(380);

        wifiManager.reconnect();

    }


}


