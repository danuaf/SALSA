package com.ppb.salsa.order;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import com.ppb.salsa.database.DatabaseModel;
import com.ppb.salsa.database.DatabaseClient;
import com.ppb.salsa.database.dao.DatabaseDao;
import com.ppb.salsa.utils.FunctionHelper;

public class OrderViewModel extends AndroidViewModel {

    LiveData<List<DatabaseModel>> modelDatabase;
    DatabaseDao databaseDao;

    public OrderViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
    }

    public LiveData<List<DatabaseModel>> getDataIdUser() {
        modelDatabase = databaseDao.getAllOrder();
        return modelDatabase;
    }


    public void addDataOrder(final String strMenu, final int strJmlItems, final int strHarga) {
        Completable.fromAction(() -> {
                    DatabaseModel databaseModel = new DatabaseModel();
                    databaseModel.nama_menu = strMenu;
                    databaseModel.items = strJmlItems;
                    databaseModel.harga = strHarga;
                    databaseModel.code = FunctionHelper.getRandomString();
                    databaseModel.date = FunctionHelper.getToday();
                    databaseDao.insertData(databaseModel);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
