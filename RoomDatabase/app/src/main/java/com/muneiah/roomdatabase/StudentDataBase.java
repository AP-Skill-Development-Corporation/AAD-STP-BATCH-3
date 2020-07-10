package com.muneiah.roomdatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = Student_Entity.class,version = 1,exportSchema = false)
public abstract class StudentDataBase extends RoomDatabase {
    private StudentDataBase INSTANCE;
    public abstract StudentDAO studentDAO();


}
