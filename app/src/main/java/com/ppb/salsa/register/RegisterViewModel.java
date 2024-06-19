package com.ppb.salsa.register;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import com.ppb.salsa.database.dao.DatabaseDao;
import com.ppb.salsa.database.DatabaseClient;
import com.ppb.salsa.database.DatabaseModel;

public class RegisterViewModel extends AndroidViewModel {

    DatabaseDao databaseDao;

    public RegisterViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
    }

    public void addDataRegister(final String strEmail, final String strUsername,
                                final String strPassword) {
        Completable.fromAction(() -> {
                    DatabaseModel databaseModel = new DatabaseModel();
                    databaseModel.email = strEmail;
                    databaseModel.username = strUsername;
                    databaseModel.password = strPassword;
                    databaseDao.insertData(databaseModel);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}