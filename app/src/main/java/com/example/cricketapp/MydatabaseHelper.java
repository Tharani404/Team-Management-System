package com.example.cricketapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MydatabaseHelper  extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME ="Champions.db";
    private  static  final  int DATABASE_VERSION =1;

    public   static  final  String COLUMN_ID = "_id";
    public static final String TABLE_NAME = "cricket_ply";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MATCH = "macth";
    public static final String  COLUMN_RUNS ="ply_runs";
    public static final String  COLUMN_FIF ="ply_50";
    public static final String  COLUMN_HUN ="ply_100";
    public static final String  COLUMN_RATE ="ply_RATE";




     MydatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //create database table
    //data types
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_NAME + " TEXT, "
                + COLUMN_MATCH + " INTEGER, "
                + COLUMN_RUNS + " INTEGER, "
                + COLUMN_FIF + " INTEGER, "
                + COLUMN_HUN + " INTEGER, "
                + COLUMN_RATE + " TEXT) ";
        db.execSQL(query);
    }


    //upgrade db if version change
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //add player records to the DB
    public void addplayer(String name, int match, int runs, int fifty, int hundred, String rate){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_MATCH,match);
        cv.put(COLUMN_RUNS, runs);
        cv.put(COLUMN_FIF, fifty);
        cv.put(COLUMN_HUN, hundred);
        cv.put(COLUMN_RATE, rate);


        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Action Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Succesfully", Toast.LENGTH_SHORT).show();
        }
    }


    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = null;
        if (db!= null){
          cursor = db.rawQuery(query, null);
        }

        return cursor;
    }

     void updateData( String row_id,String name, int match, int runs, int fifty, int hundred, String rate) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_MATCH, match);
        cv.put(COLUMN_RUNS, runs);
        cv.put(COLUMN_FIF, fifty);
        cv.put(COLUMN_HUN, hundred);
        cv.put(COLUMN_RATE, rate);

        long result = db.update(TABLE_NAME, cv, COLUMN_ID + "=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Update failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteoneRow(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, COLUMN_ID + "=?", new String[]{row_id});
        if (result == -1) {
            Toast.makeText(context, "Delete failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Delete successful", Toast.LENGTH_SHORT).show();
        }
    }


}
