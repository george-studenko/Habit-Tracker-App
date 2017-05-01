package com.georgestudenko.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.georgestudenko.habittracker.data.HabitContract.HabitEntry;

/**
 * Created by george on 01/05/2017.
 */

public final class HabitContentManager {
    /**
     * Inserts a Habit into the Database
     * @param context The activity context
     * @param habitDescription Set a description for the Habit to track
     * @param habitDifficultyLevel How difficult is it? Use the of the 3 constants HabitEntry.DIFFICULTY_LEVEL_EASY, HabitEntry.DIFFICULTY_LEVEL_MEDIUM or HabitEntry.DIFFICULTY_LEVEL_HARD
     * @param habitTotalRepetitions How many repetitions did you manage to get for this habit so far? the default is 0, if you haven't started on this habit set it to 0
     * @return The a long containing the id of the inserted row, if the id is -1 it means the insertion failed
     */
    public static long insertHabit(Context context, String habitDescription, int habitDifficultyLevel, int habitTotalRepetitions){
        long id = 0;

        ContentValues cv = new ContentValues();
        cv.put(HabitEntry.COLUMN_HABIT_DESCRIPTION, habitDescription);
        cv.put(HabitEntry.COLUMN_HABIT_DIFFICULTY_LEVEL, habitDifficultyLevel);
        cv.put(HabitEntry.COLUMN_HABIT_REPETITIONS_COUNT, habitTotalRepetitions);

        HabitDbHelper dbHelper = new HabitDbHelper(context,HabitDbHelper.DATABASE_NAME,null, HabitDbHelper.DATABASE_VERSION);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        id = db.insert(HabitEntry.TABLE_NAME,null,cv);
        db.close();
        return  id;
    }

    /**
     *
     * @param context The activity context
     * @return A Cursor with all rows in the habits table
     */
    public static Cursor getAllHabitsData(Context context){
        HabitDbHelper dbHelper = new HabitDbHelper(context,HabitDbHelper.DATABASE_NAME,null, HabitDbHelper.DATABASE_VERSION);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(HabitEntry.TABLE_NAME,null,null,null,null,null,HabitEntry.COLUMN_HABIT_DESCRIPTION);
    }
}
