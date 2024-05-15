package com.example.hotelkd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityTwo extends AppCompatActivity {

    private Button btnActTwo;
    private Button btnDeveloperInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        // Инициализация элементов
        btnActTwo = (Button) findViewById(R.id.btnActTwo);
        btnDeveloperInfo = (Button) findViewById(R.id.btnDeveloperInfo);

        // Установка обработчиков событий
        btnActTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Код для перехода к расчету
            }
        });


        btnDeveloperInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Код для отображения информации о разработчике
            }
        });
    }
}

