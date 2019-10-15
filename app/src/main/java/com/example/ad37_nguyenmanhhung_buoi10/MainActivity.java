package com.example.ad37_nguyenmanhhung_buoi10;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView tvJson;
    String json = "{\"coord\":{\"lon\":139.01,\"lat\":35.02}, \"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}], \"base\":\"stations\", \"main\":{\"temp\":285.514, \"pressure\":1013.75, \"humidity\":100, \"temp_min\":285.514, \"temp_max\":285.514, \"sea_level\":1023.22, \"grnd_level\":1013.75}, \"wind\":{\"speed\":5.52, \"deg\":311}, \"clouds\":{\"all\":0}, \"dt\":1485792967, \"sys\":{\"message\":0.0025,\"country\":\"JP\",\"sunrise\":1485726240,\"sunset\":1485763863}, \"id\":1907296, \"name\":\"Tawarano\", \"cod\":200}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvJson = findViewById(R.id.tvJson);
        getJson(json);
    }

    public void getJson(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);

            //Coordination
            JSONObject coordObj = jsonObject.getJSONObject("coord");
            String lon = coordObj.getString("lon");
            String lat = coordObj.getString("lat");

            //Weather
            JSONArray weatherArr = jsonObject.getJSONArray("weather");
            String id_weather = weatherArr.getJSONObject(0).getString("id");
            String main = weatherArr.getJSONObject(0).getString("main");
            String description = weatherArr.getJSONObject(0).getString("description");
            String icon = weatherArr.getJSONObject(0).getString("icon");

            //Base
            String base = jsonObject.getString("base");

            //Main
            JSONObject mainObj = jsonObject.getJSONObject("main");
            String temp = mainObj.getString("temp");
            String pressure = mainObj.getString("pressure");
            String humidity = mainObj.getString("humidity");
            String temp_min = mainObj.getString("temp_min");
            String temp_max = mainObj.getString("temp_max");
            String sea_level = mainObj.getString("sea_level");
            String ground_level = mainObj.getString("grnd_level");

            //Wind
            JSONObject winObj = jsonObject.getJSONObject("wind");
            String speed = winObj.getString("speed");
            String deg = winObj.getString("deg");

            //Cloud
            JSONObject cloudObj = jsonObject.getJSONObject("clouds");
            String all = cloudObj.getString("all");

            //dt
            String dt = jsonObject.getString("dt");

            //Sys
            JSONObject sysObj = jsonObject.getJSONObject("sys");
            String message = sysObj.getString("message");
            String country = sysObj.getString("country");
            String sunrise = sysObj.getString("sunrise");
            String sunset = sysObj.getString("sunset");

            //id, name, cod
            String id = jsonObject.getString("id");
            String name = jsonObject.getString("name");
            String cod = jsonObject.getString("cod");

            tvJson.setText("- Coordination (Lon: " + lon + ", Lat: " + lat + ")" + "\n"
                    + "- Weather (id: " + id_weather + ", main: " + main + ", description: " + description + ", icon: " + icon + ")\n"
                    + "- Base: " + base + "\n"
                    + "- Main (temp: " + temp + ", pressure: " + pressure + ", humidity:: " + humidity + ", temp_min: " + temp_min + ", temp_max: " + temp_max + ", sea_level: " + sea_level + ", ground_level: " + ground_level + ")\n"
                    + "- Wind (speed: " + speed + ", deg: " + deg + ")\n"
                    + "- Cloud (all: " + all + ")\n"
                    + "- dt: " + dt + "\n"
                    + "- sys (message: " + message + ", country: " + country + ", sunrise: " + sunrise + ", sunset: " + sunset + ")\n"
                    + "- id: " + id + "\n"
                    + "- name: " + name + "\n"
                    + "- cod: " + cod);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
