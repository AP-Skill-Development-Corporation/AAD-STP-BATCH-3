package com.muneiah.roomdatabase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Student_Entity.class,version = 1,exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {
    private static StudentDataBase INSTANCE;
    public abstract StudentDAO studentDAO();
    //For Live Data
        public static synchronized StudentDataBase getDataBase(Context context){
            if (INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context,StudentDataBase.class,"muni").allowMainThreadQueries()
                        .fallbackToDestructiveMigration().build();
            }
            return INSTANCE;
        }

}
