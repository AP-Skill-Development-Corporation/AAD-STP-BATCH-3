package com.muneiah.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDAO {
    @Insert
    public void insertData(Student_Entity entity);
    @Update
    public void updateData(Student_Entity entity);
    @Delete
    public void deleteData(Student_Entity entity);

    //for live data
    @Query("SELECT * FROM student_table")
    public LiveData<List<Student_Entity>> retriveData();
    //public List<Student_Entity> retriveData();//Normal data
}
