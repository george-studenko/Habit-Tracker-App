package com.georgestudenko.habittracker.data;

import android.provider.BaseColumns;

/**
 * Created by george on 01/05/2017.
 */

public final class HabitContract {

    public final static class HabitEntry implements BaseColumns{
        public final static String TABLE_NAME = "habits";
        public final static String COLUMN_ID = BaseColumns._ID;
        public final static String COLUMN_HABIT_DESCRIPTION = "description";
        public final static String COLUMN_HABIT_REPETITIONS_COUNT = "totalCount";
        public final static String COLUMN_HABIT_DIFFICULTY_LEVEL = "difficulty";

        // Constants for Difficulty Level
        public final static int DIFFICULTY_LEVEL_EASY = 0;
        public final static int DIFFICULTY_LEVEL_MEDIUM = 1;
        public final static int DIFFICULTY_LEVEL_HARD = 2;
    }
}
