package com.example.hotelkd;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class BookingListActivity extends AppCompatActivity {
    private BookingDataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list);

        dataManager = new BookingDataManager(this);
        ListView listView = findViewById(R.id.listView);

        List<Booking> bookings = dataManager.getAllBookings();
        BookingAdapter adapter = new BookingAdapter(this, bookings);
        listView.setAdapter(adapter);
    }
}
