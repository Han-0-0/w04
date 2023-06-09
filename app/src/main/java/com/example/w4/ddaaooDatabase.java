package com.example.w4;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class ddaaooDatabase extends RoomDatabase {
    public abstract ddaaoo ddaaoo();
}
