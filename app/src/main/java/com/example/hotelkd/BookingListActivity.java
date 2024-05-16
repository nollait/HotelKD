package com.example.hotelkd;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class BookingListActivity extends AppCompatActivity {
    private BookingDataManager dataManager;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_list);

        dataManager = new BookingDataManager(this);
        listView = findViewById(R.id.listView);

        List<Booking> bookings = dataManager.getAllBookings();
        BookingAdapter adapter = new BookingAdapter(this, bookings);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Booking booking = (Booking) parent.getItemAtPosition(position);
                showDeleteDialog(booking);
                return true;
            }
        });
    }

    private void showDeleteDialog(final Booking booking) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Удалить бронирование");
        dialogBuilder.setMessage("Вы уверены, что хотите удалить это бронирование?");
        dialogBuilder.setPositiveButton("Удалить", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dataManager.deleteBooking(booking.getBookingNumber());
                // Обновите список бронирований после удаления
                List<Booking> bookings = dataManager.getAllBookings();
                BookingAdapter adapter = new BookingAdapter(BookingListActivity.this, bookings);
                listView.setAdapter(adapter);
            }
        });
        dialogBuilder.setNegativeButton("Отмена", null);
        AlertDialog b = dialogBuilder.create();
        b.show();
    }
}

