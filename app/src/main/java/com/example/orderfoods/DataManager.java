package com.example.orderfoods;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataManager {
    // This is the actual database
    private SQLiteDatabase db;

    /* Next we have a public static final string for
       each row/table that we need to refer to both
       inside and outside this class
    */
    public static final String TABLE_ROW_ID = "_id";
    public static final String TABLE_ROW_PHONE = "phone";
    public static final String TABLE_ROW_PASSWORD = "password";

    /*
        Next we have a private static final strings for
        each row/table that we need to refer to just
        inside this class
    */
    private static final String DB_NAME = "user_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_P_AND_P = "phone_and_password";

    public DataManager(Context context) {
        // Create an instance of our internal CustomSQLiteOpenHelper class
        CustomSQLiteOpenHelper helper = new CustomSQLiteOpenHelper(context);
        // Get a writable database
        db = helper.getWritableDatabase();
    }

    public void SignUp(String phone, String password){
        // Add all the details to the table
        String query = "INSERT INTO " + TABLE_P_AND_P + " (" +
                TABLE_ROW_PHONE + ", " + TABLE_ROW_PASSWORD + ") " + "VALUES (" +
                "'" + phone + "'" + ", " + "'" + password + "'" +
                "); ";
        Log.i("insert() = ", query);
        db.execSQL(query);
    }

    // Get all the records
    public Cursor selectAll() {
        Cursor c = db.rawQuery("SELECT *" +" from " + TABLE_P_AND_P, null);
        return c;
    }

    // Find a specific record
    public Cursor searchPhone(String phone) {
        String query = "SELECT " +
                TABLE_ROW_ID + ", " +
                TABLE_ROW_PHONE +
                ", " + TABLE_ROW_PASSWORD +
                " from " +
                TABLE_P_AND_P + " WHERE " + TABLE_ROW_PHONE + " = '" + phone + "';";
        Log.i("searchPhone() = ", query); Cursor c = db.rawQuery(query, null);
        return c;
    }

    public boolean checkUser(String phone, String password) {
        String[] column = {TABLE_ROW_ID};

        String selection = TABLE_ROW_PHONE + " =?" + " AND " + TABLE_ROW_PASSWORD + " =?";
        String[] selectionArgs = {phone, password};

        Cursor cursor = db.query(TABLE_P_AND_P, column, selection, selectionArgs, null, null, null);
        int cursorcount = cursor.getCount();
        db.close();
        if (cursorcount > 0) {
            return true;
        } else {
            return false;
        }
    }

    // This class is created when our DataManager is initialized
    private class CustomSQLiteOpenHelper extends SQLiteOpenHelper {
        public CustomSQLiteOpenHelper(Context context) { super(context, DB_NAME, null, DB_VERSION);
        }
        // This method only runs the first time the database is created
        @Override
        public void onCreate(SQLiteDatabase db) {
            // Create a table for photos and all their details
            String newTableQueryString = "create table " + TABLE_P_AND_P + " ("
                    + TABLE_ROW_ID
                    + " integer primary key autoincrement not null," + TABLE_ROW_PHONE
                    + " text not null,"
                    + TABLE_ROW_PASSWORD
                    + " text not null);";
            db.execSQL(newTableQueryString); }

        // This method only runs when we increment DB_VERSION
        @Override
        public void onUpgrade(SQLiteDatabase db,
                              int oldVersion, int newVersion) {
        }
    }


}
