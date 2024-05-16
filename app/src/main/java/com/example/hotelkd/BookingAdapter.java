package com.example.hotelkd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookingAdapter extends ArrayAdapter<Booking> {
    public BookingAdapter(Context context, List<Booking> bookings) {
        super(context, 0, bookings);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Booking booking = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_booking, parent, false);
        }

        TextView bookingNumber = convertView.findViewById(R.id.bookingNumber);
        TextView bookingDate = convertView.findViewById(R.id.bookingDate);
        TextView roomType = convertView.findViewById(R.id.roomType);
        TextView checkInDate = convertView.findViewById(R.id.checkInDate);
        TextView checkOutDate = convertView.findViewById(R.id.checkOutDate);
        TextView clientName = convertView.findViewById(R.id.clientName);
        TextView bookingStatus = convertView.findViewById(R.id.bookingStatus);

        bookingNumber.setText("Номер бронирования: " + String.valueOf(booking.getBookingNumber()));
        bookingDate.setText("Дата бронирования: " + booking.getBookingDate());
        roomType.setText("Тип номера: " + booking.getRoomType());
        checkInDate.setText("Дата заезда: " + booking.getCheckInDate());
        checkOutDate.setText("Дата выезда: " + booking.getCheckOutDate());
        clientName.setText("Клиент: " + booking.getClientName());
        bookingStatus.setText("Статус бронирования: " + booking.getBookingStatus());

        return convertView;
    }
}