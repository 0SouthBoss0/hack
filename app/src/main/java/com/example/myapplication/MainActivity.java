package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
   //Функция reconnect менеджера wifi асинхронная. Она возвращает результат не дожидаясь окончания подключения.
// В твоем коде получается, что ты не дождавшись окончания первой попытки подключения запускаешь вторую попытку - результаты могут быть самыми неожиданными.
    
    final String networkSSID = ("mySSID");
    final String networkPassword = ("myPASS");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        try {
            connectToWifi(networkSSID, "12345678");
        } catch (Exception e) {
        }
        try {
            connectToWifi(networkSSID, networkPassword);
        } catch (Exception e) {
        }
    }

    private void connectToWifi(final String networkSSID, final String networkPassword) {
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = String.format("\"%s\"", networkSSID);
        conf.preSharedKey = String.format("\"%s\"", networkPassword);

        int netId = wifiManager.addNetwork(conf);
        wifiManager.disconnect();
        wifiManager.enableNetwork(netId, true);
        wifiManager.reconnect();

    }

}

