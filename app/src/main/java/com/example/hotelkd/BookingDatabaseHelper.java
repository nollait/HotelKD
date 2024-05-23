package com.example.hotelkd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookingDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "booking.db";
    private static final int DATABASE_VERSION = 1;

    public BookingDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE bookings (" +
                "bookingNumber INTEGER PRIMARY KEY," +
                "bookingDate TEXT," +
                "roomType TEXT," +
                "checkInDate TEXT," +
                "checkOutDate TEXT," +
                "clientName TEXT," +
                "bookingStatus TEXT" +
                ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS bookings");
        onCreate(db);
    }
}