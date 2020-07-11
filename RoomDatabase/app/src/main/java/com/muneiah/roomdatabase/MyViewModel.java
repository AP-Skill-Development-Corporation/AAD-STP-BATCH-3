package com.muneiah.roomdatabase;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    StudentRepo studentRepo;
    LiveData<List<Student_Entity>> listLiveData_model;
    public MyViewModel(@NonNull Application application) {
        super(application);
        studentRepo=new StudentRepo(application);
        listLiveData_model=studentRepo.listLiveData;
    }
    public void insert(Student_Entity entity){
        studentRepo.insert(entity);
    }
    public void update(Student_Entity entity){
        studentRepo.update(entity);
    }
    public void delete(Student_Entity entity){
        studentRepo.delete(entity);
    }
    public LiveData<List<Student_Entity>> liveData(){

        return  listLiveData_model;
    }
}
