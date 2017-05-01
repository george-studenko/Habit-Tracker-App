package com.georgestudenko.habittracker;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.stetho.Stetho;
import com.georgestudenko.habittracker.data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);

        HabitDbHelper dbHelper = new HabitDbHelper(this,HabitDbHelper.DATABASE_NAME,null,HabitDbHelper.DATABASE_VERSION);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
    }
}
