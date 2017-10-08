package com.example.chalmers.bookfragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sophia on 10/7/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "BookCollection.db";
    public static final String TABLE_NAME = "Book";
    public static final String  ID = "ID";
    public static final String  AUTHOR = "Author";
    public static final String  TITLE = "Title";
    public static final String  PRICE =  "Price";
    public static final String  ISBN = "Isbn";
    public static final String  COURSE = "Course";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table "+TABLE_NAME+" (ID  INTEGER PRIMARY KEY AUTOINCREMENT, AUTHOR TEXT,TITLE TEXT, PRICE INTEGER,ISBN TEXT, COURSE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    db.execSQL("DROP TABLE IF EXISTS"+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String author, String title, Integer price, String isbn, String course){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(AUTHOR, author);
        contentValues.put(TITLE, title);
        contentValues.put(PRICE, price);
        contentValues.put(ISBN, isbn);
        contentValues.put(COURSE, course);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return  false;
        else
            return true;
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
