package com.georgestudenko.habittracker;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.facebook.stetho.Stetho;
import com.georgestudenko.habittracker.data.HabitContentManager;
import com.georgestudenko.habittracker.data.HabitContract;
import com.georgestudenko.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);

        HabitContentManager.insertHabit(this,"Drink water", HabitContract.HabitEntry.DIFFICULTY_LEVEL_EASY,15);
        HabitContentManager.insertHabit(this,"Do exercise", HabitContract.HabitEntry.DIFFICULTY_LEVEL_MEDIUM,2);

        Cursor cursor = HabitContentManager.getAllHabitsData(this);

        while(cursor.moveToNext()) {
            Log.d("Cursor Data", cursor.getString(0) + "  " + cursor.getInt(1) + "  " + cursor.getInt(2));
        }
        cursor.close();
    }
}
