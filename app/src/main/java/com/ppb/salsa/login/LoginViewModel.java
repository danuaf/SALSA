package com.ppb.salsa.login;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import com.ppb.salsa.database.dao.DatabaseDao;
import com.ppb.salsa.database.DatabaseClient;
import com.ppb.salsa.database.DatabaseModel;

public class LoginViewModel extends AndroidViewModel {

    LiveData<List<DatabaseModel>> modelDatabase;
    DatabaseDao databaseDao;

    public LoginViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
    }


    public LiveData<List<DatabaseModel>> getDataUser(String username, String password) {
        modelDatabase = databaseDao.getUserByName(username, password);
        return modelDatabase;
    }

}