package com.muneiah.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentRepo {
    LiveData<List<Student_Entity>> listLiveData;
    StudentDataBase studentDataBase;

    public StudentRepo(Application application){
        studentDataBase=StudentDataBase.getDataBase(application);
        listLiveData=studentDataBase.studentDAO().retriveData();
    }
    //for live data ineserting
    public class MyAsyncTakForInsert extends AsyncTask<Student_Entity,Void,Void>{

        @Override
        protected Void doInBackground(Student_Entity... student_entities) {
            studentDataBase.studentDAO().insertData(student_entities[0]);
            return null;
        }
    }
    //for live data update
    public class MyAsyncTakForUpdate extends AsyncTask<Student_Entity,Void,Void>{

        @Override
        protected Void doInBackground(Student_Entity... student_entities) {
            studentDataBase.studentDAO().updateData(student_entities[0]);
            return null;
        }
    }
    //for live data delete
   public class MyAsyncTaskDelete extends AsyncTask<Student_Entity,Void,Void>{

        @Override
        protected Void doInBackground(Student_Entity... student_entities) {
            studentDataBase.studentDAO().deleteData(student_entities[0]);
            return null;
        }
    }
    public void insert(Student_Entity entity)
    {
        new MyAsyncTakForInsert().execute(entity);
    }
    public void update(Student_Entity entity)
    {
        new MyAsyncTakForUpdate().execute(entity);
    }
    public void delete(Student_Entity entity)
    {
        new MyAsyncTaskDelete().execute(entity);
    }
}
