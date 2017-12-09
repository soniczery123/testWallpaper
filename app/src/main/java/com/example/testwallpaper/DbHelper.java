package com.example.testwallpaper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MSI-GL62 on 9/12/2560.
 */

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db.picture";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "highscore_hard";
    public static final String COL_ID = "_id";
    public static final String COL_PICTURE = "picture";


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_PICTURE + " INTEGER)";


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_PICTURE, R.drawable.backgound);
        db.insert(TABLE_NAME, null, cv);
        cv = new ContentValues();
        cv.put(COL_PICTURE, R.drawable.mine2);
        db.insert(TABLE_NAME, null, cv);
    }

        @Override
        public void onUpgrade(SQLiteDatabase db,int i, int i1){
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }

}