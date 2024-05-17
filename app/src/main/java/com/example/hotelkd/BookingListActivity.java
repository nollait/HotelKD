package com.example.hotelkd;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

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

        SpannableString s = new SpannableString("Удалить бронирование");
        SpannableString v = new SpannableString("Вы уверены, что хотите удалить это бронирование?");
        SpannableString d = new SpannableString("Удалить");
        SpannableString m = new SpannableString("Отмена");


        // Изменение цвета текста на голубой
        s.setSpan(new ForegroundColorSpan(Color.RED), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Изменение размера текста на 15dp
        s.setSpan(new AbsoluteSizeSpan(20, true), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Изменение стиля текста на жирный
        s.setSpan(new StyleSpan(Typeface.BOLD), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        v.setSpan(new ForegroundColorSpan(Color.BLACK), 0, v.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        v.setSpan(new AbsoluteSizeSpan(15, true), 0, v.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        v.setSpan(new StyleSpan(Typeface.BOLD), 0, v.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        d.setSpan(new ForegroundColorSpan(Color.RED), 0, d.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        d.setSpan(new AbsoluteSizeSpan(15, true), 0, d.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        d.setSpan(new StyleSpan(Typeface.BOLD), 0, d.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        m.setSpan(new ForegroundColorSpan(Color.BLACK), 0, m.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        m.setSpan(new AbsoluteSizeSpan(15, true), 0, m.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        m.setSpan(new StyleSpan(Typeface.BOLD), 0, m.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        dialogBuilder.setTitle(s);
        dialogBuilder.setMessage(v);
        dialogBuilder.setPositiveButton(d, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dataManager.deleteBooking(booking.getBookingNumber());
                // Обновите список бронирований после удаления
                List<Booking> bookings = dataManager.getAllBookings();
                BookingAdapter adapter = new BookingAdapter(BookingListActivity.this, bookings);
                listView.setAdapter(adapter);
            }
        });
        dialogBuilder.setNegativeButton(m, null);
        AlertDialog b = dialogBuilder.create();
        b.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                AlertDialog dialog = (AlertDialog) dialogInterface;
                TextView messageView = (TextView) dialog.findViewById(android.R.id.message);
                TextView titleView = (TextView) dialog.getWindow().findViewById(android.R.id.title);
                Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
                Button negativeButton = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);

                // Изменение шрифта
                Typeface typeface = Typeface.create("sans-serif-light", Typeface.NORMAL);
                if (messageView != null) {
                    messageView.setTypeface(typeface);
                }
                if (titleView != null) {
                    titleView.setTypeface(typeface);
                }
                if (positiveButton != null) {
                    positiveButton.setTypeface(typeface);
                }
                if (negativeButton != null) {
                    negativeButton.setTypeface(typeface);
                }
            }
        });
        b.show();
    }
}