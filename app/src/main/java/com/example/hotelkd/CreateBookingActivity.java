package com.example.hotelkd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateBookingActivity extends AppCompatActivity {
    private BookingDataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_booking);

        dataManager = new BookingDataManager(this);

        final EditText bookingNumber = findViewById(R.id.bookingNumber);
        final EditText bookingDate = findViewById(R.id.bookingDate);
        final EditText roomType = findViewById(R.id.roomType);
        final EditText checkInDate = findViewById(R.id.checkInDate);
        final EditText checkOutDate = findViewById(R.id.checkOutDate);
        final EditText clientName = findViewById(R.id.clientName);
        final EditText bookingStatus = findViewById(R.id.bookingStatus);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(bookingNumber.getText().toString());
                String date = bookingDate.getText().toString();
                String room = roomType.getText().toString();
                String checkIn = checkInDate.getText().toString();
                String checkOut = checkOutDate.getText().toString();
                String client = clientName.getText().toString();
                String status = bookingStatus.getText().toString();

                Booking booking = new Booking(number, date, room, checkIn, checkOut, client, status);
                dataManager.addBooking(booking);

                finish();
            }
        });
    }
}
