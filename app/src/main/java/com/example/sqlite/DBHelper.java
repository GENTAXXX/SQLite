package com.example.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;

    static final String DATABASE_NAME = "sqlite_apk.db";
    public static final String TABLE_SQLite = "sqlite";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_ADDRESS = "address";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_CONTACT_TABLE = "CREATE TABLE" + TABLE_SQLite + "{" +
                COLUMN_ID + " INTEGER PRIMARY KEY autoincrement, " +
                COLUMN_NAME + " TEXT NOT NULL, " +
                COLUMN_PHONE + " TEXT NOT NULL, " +
                COLUMN_ADDRESS + " TEXT NOT NULL" +
                "}";
        sqLiteDatabase.execSQL(SQL_CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int o, int n) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_SQLite);
        onCreate(sqLiteDatabase);
    }

    public void insert(String name, String phone, String address){
        SQLiteDatabase database = this.getWritableDatabase();
        String queryValues = "INSERT INTO " + TABLE_SQLite + " (name, phone, address) " +
                "VALUES ('" + name + "', '" + phone + "', '" + address + "')";
        database.execSQL(queryValues);
        database.close();
    }

    public void update(int id, String name, String phone, String address){
        SQLiteDatabase database = this.getWritableDatabase();
        String updateQuery = "UPDATE " + TABLE_SQLite + " SET "
                + COLUMN_NAME + "='" + name + "', "
                + COLUMN_PHONE + "='" + phone + "', "
                + COLUMN_ADDRESS + "='" + address + "', "
                + " WHERE " + COLUMN_ID + "=" + "'" + id + "'";
        database.execSQL(updateQuery);
        database.close();
    }

    public void delete (int id){
        SQLiteDatabase database = this.getWritableDatabase();
        String updateQuery = " DELETE FROM " + TABLE_SQLite + " WHERE " + COLUMN_ID + "=" + "'" +
                id + "'";
        database.execSQL(updateQuery);
        database.close();
    }
}
