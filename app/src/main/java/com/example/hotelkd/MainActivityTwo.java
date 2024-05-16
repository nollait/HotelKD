package com.example.hotelkd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivityTwo extends AppCompatActivity {

    private Button btnListAct;
    private Button btnCreateBooking;
    private RecyclerView recyclerView;
    private RoomListAdapter adapter;
    private List<Room> roomList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_two);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        // Инициализация элементов
        btnListAct = (Button) findViewById(R.id.btnListAct);
        btnCreateBooking = (Button) findViewById(R.id.btnCreateBooking);

        roomList = new ArrayList<>();
        roomList.add(new Room(R.drawable.houseone, "Люкс", "Цена: от 3939 рублей"));
        roomList.add(new Room(R.drawable.housetwo, "Стандарт", "Цена: от 2500 рублей"));
        roomList.add(new Room(R.drawable.housethree, "Премиум", "Цена: от 6495 рублей"));
        roomList.add(new Room(R.drawable.housefour, "Стандарт", "Цена: от 3200 рублей"));
        roomList.add(new Room(R.drawable.housefive, "Люкс", "Цена: от 4223 рублей"));
        // Здесь вы можете добавить данные в список комнат
        // roomList.add(new Room(R.drawable.icon, "Название", "Цена"));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RoomListAdapter(this, roomList);
        recyclerView.setAdapter(adapter);

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