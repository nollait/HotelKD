package com.example.hotelkd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityTwo extends AppCompatActivity {

    private Button btnListAct;
    private Button btnCreateBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // Инициализация элементов
        btnListAct = (Button) findViewById(R.id.btnListAct);
        btnCreateBooking = (Button) findViewById(R.id.btnCreateBooking);

        // Установка обработчиков событий
        btnListAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityTwo.this, BookingListActivity.class);
                startActivity(intent);
            }
        });


        btnCreateBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityTwo.this, CreateBookingActivity.class);
                startActivity(intent);
            }
        });
    }
}

