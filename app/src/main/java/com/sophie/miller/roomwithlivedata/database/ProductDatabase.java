package com.sophie.miller.roomwithlivedata.database;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.sophie.miller.roomwithlivedata.objects.Product;


@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "database";
    private static ProductDatabase database;
    private static final Object OBJECT = new Object();

    public static ProductDatabase getInstance(Context context) {
        if (database == null) {
            //synchronized avoids Concurent Modification Acception
            //.allowMainThreadQueries() temporary
            synchronized (OBJECT) {
                database = Room.databaseBuilder(context.getApplicationContext(), ProductDatabase.class, ProductDatabase.DATABASE_NAME).allowMainThreadQueries().build();
            }
        }
        return database;
    }

    public abstract ProductDao productDao();
}
