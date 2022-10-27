package com.example.dbr21.DataClass;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.dbr21.Timetable;

@Database(entities = {Timetable.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TimetableClassDao timetableClassDao();
}
 