package com.ppb.salsa.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ppb.salsa.database.dao.DatabaseDao;

@Database(entities = {DatabaseModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();
}
