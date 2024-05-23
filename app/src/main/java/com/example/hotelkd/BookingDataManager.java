package com.example.hotelkd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BookingDataManager {
    private BookingDatabaseHelper dbHelper;

    public BookingDataManager(Context context) {
        dbHelper = new BookingDatabaseHelper(context);
    }

    public void addBooking(Booking booking) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("bookingNumber", booking.getBookingNumber());
        values.put("bookingDate", booking.getBookingDate());
        values.put("roomType", booking.getRoomType());
        values.put("checkInDate", booking.getCheckInDate());
        values.put("checkOutDate", booking.getCheckOutDate());
        values.put("clientName", booking.getClientName());
        values.put("bookingStatus", booking.getBookingStatus());

        db.insert("bookings", null, values);
    }

    public List<Booking> getAllBookings() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<Booking> bookings = new ArrayList<>();

        Cursor cursor = db.query("bookings", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            int bookingNumber = cursor.getInt(cursor.getColumnIndex("bookingNumber"));
            String bookingDate = cursor.getString(cursor.getColumnIndex("bookingDate"));
            String roomType = cursor.getString(cursor.getColumnIndex("roomType"));
            String checkInDate = cursor.getString(cursor.getColumnIndex("checkInDate"));
            String checkOutDate = cursor.getString(cursor.getColumnIndex("checkOutDate"));
            String clientName = cursor.getString(cursor.getColumnIndex("clientName"));
            String bookingStatus = cursor.getString(cursor.getColumnIndex("bookingStatus"));

            bookings.add(new Booking(bookingNumber, bookingDate, roomType, checkInDate, checkOutDate, clientName, bookingStatus));
        }
        cursor.close();

        return bookings;
    }

    public void updateBooking(Booking booking) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("bookingDate", booking.getBookingDate());
        values.put("roomType", booking.getRoomType());
        values.put("checkInDate", booking.getCheckInDate());
        values.put("checkOutDate", booking.getCheckOutDate());
        values.put("clientName", booking.getClientName());
        values.put("bookingStatus", booking.getBookingStatus());

        db.update("bookings", values, "bookingNumber = ?", new String[]{String.valueOf(booking.getBookingNumber())});
    }

    public void deleteBooking(int bookingNumber) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("bookings", "bookingNumber = ?", new String[]{String.valueOf(bookingNumber)});
    }
}