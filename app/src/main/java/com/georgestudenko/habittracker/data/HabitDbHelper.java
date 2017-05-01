package com.georgestudenko.habittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.georgestudenko.habittracker.data.HabitContract.HabitEntry;
/**
 * Created by george on 01/05/2017.
 */

public class HabitDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "HabitTracker.db";
    public static final String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + "("+
            HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            HabitEntry.COLUMN_HABIT_DESCRIPTION + " TEXT NOT NULL,"+
            HabitEntry.COLUMN_HABIT_DIFFICULTY_LEVEL + " INTEGER NOT NULL,"+
            HabitEntry.COLUMN_HABIT_REPETITIONS_COUNT + " INTEGER DEFAULT 0);";

    public static final String SQL_DELETE_HABIT_TABLE = "DROP TABLE IF EXISTS " + HabitEntry.TABLE_NAME+";";

    public HabitDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_HABIT_TABLE);
        onCreate(db);
    }
}
