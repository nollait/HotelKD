package com.example.hotelkd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;
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
                String numberStr = bookingNumber.getText().toString();
                String date = bookingDate.getText().toString();
                String room = roomType.getText().toString();
                String checkIn = checkInDate.getText().toString();
                String checkOut = checkOutDate.getText().toString();
                String client = clientName.getText().toString();
                String status = bookingStatus.getText().toString();

                if (numberStr.isEmpty() || date.isEmpty() || room.isEmpty() || checkIn.isEmpty() || checkOut.isEmpty() || client.isEmpty() || status.isEmpty()) {
                    Snackbar.make(v, "Ошибка: все поля должны быть заполнены!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                int number = Integer.parseInt(numberStr);
                if (number <= 0) {
                    Snackbar.make(v, "Ошибка: номер бронирования должен быть положительным числом!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                // Проверка корректности даты бронирования
                if (!date.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                    Snackbar.make(v, "Ошибка: дата бронирования должна быть в формате ДД.ММ.ГГГГ!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                // Проверка корректности типа номера
                if (room.length() > 15 || !room.matches("[a-zA-Zа-яА-Я ]+")) {
                    Snackbar.make(v, "Ошибка: тип номера должен быть текстовым и не длиннее 15 символов!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                // Проверка корректности даты заезда и выезда
                if (!checkIn.matches("\\d{2}\\.\\d{2}\\.\\d{4}") || !checkOut.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                    Snackbar.make(v, "Ошибка: даты заезда и выезда должны быть в формате ДД.ММ.ГГГГ!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                // Проверка корректности статуса бронирования
                if (!status.equals("Занято") && !status.equals("Свободно")) {
                    Snackbar.make(v, "Ошибка: статус бронирования должен быть \"Занято\" или \"Свободно\"!", Snackbar.LENGTH_LONG).show();
                    return;
                }

                Booking booking = new Booking(number, date, room, checkIn, checkOut, client, status);
                dataManager.addBooking(booking);

                finish();
            }
        });
    }
}