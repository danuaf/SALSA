package com.ppb.salsa.main;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import com.ppb.salsa.R;
import com.ppb.salsa.history.HistoryOrderActivity;
import com.ppb.salsa.utils.FunctionHelper;
import com.ppb.salsa.utils.FunctionLocation;
import com.ppb.salsa.utils.FunctionLogo;
import com.ppb.salsa.utils.FunctionProduct;

public class MainActivity extends AppCompatActivity implements FunctionLocation.LocationCallback {

    public static String location;
    private String[] categories = {"Minuman", "Makanan Instant", "Makanan Ringan", "Bumbu Instant", "Kesehatan", "Lainnya"};
    List<ModelCategories> modelCategoriesList = new ArrayList<>();
    List<ModelDiscount> modelDiscountList = new ArrayList<>();
    CategoriesAdapter categoriesAdapter;
    DiscountAdapter discountAdapter;
    ModelCategories modelCategories;
    ModelDiscount modelDiscount;
    RecyclerView rvCategories, rvDiscount;
    CardView cvHistory;
    TextView tvGreeting, tvLocationMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new FunctionLocation(this, this);

        setStatusbar();
        setInitLayout();
        setGreeting();
        setCategories();
        setDiscount();
    }

    @Override
    public void onLocationResult(String location) {
        MainActivity.location = location;
        setLocation();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        FunctionLocation functionLocation = new FunctionLocation(this, this);
        functionLocation.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    private void setInitLayout() {
        cvHistory = findViewById(R.id.cvHistory);
        cvHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryOrderActivity.class);
                startActivity(intent);
            }
        });

        rvCategories = findViewById(R.id.rvCategories);
        rvCategories.setLayoutManager(new GridLayoutManager(this, 3));
        rvCategories.setHasFixedSize(true);

        rvDiscount = findViewById(R.id.rvDiscount);
        rvDiscount.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvDiscount.setHasFixedSize(true);


    }

    private void setGreeting(){
        tvGreeting = findViewById(R.id.tvMainGreeting);
        tvGreeting.setText(FunctionHelper.timeGreeting());
    }

    private void setLocation(){
        tvLocationMain = findViewById(R.id.tvMainLocation);
        tvLocationMain.setText(location);
    }

    private void setCategories() {
        for (String category : this.categories) {
            modelCategories = new ModelCategories(FunctionLogo.getCategoriesLogo(category), category);
            modelCategoriesList.add(modelCategories);
        }

        categoriesAdapter = new CategoriesAdapter(this, modelCategoriesList);
        rvCategories.setAdapter(categoriesAdapter);
    }

    private void setDiscount() {
        for (String category : this.categories) {
            modelDiscount = new ModelDiscount(FunctionProduct.getProductDiscountImage(category),
                    FunctionLogo.getDiscountLogo(FunctionProduct.getProductDiscount(category)),
                    FunctionProduct.getProductDiscountName(category),
                    FunctionHelper.rupiahFormat(FunctionProduct.getProductPrice(category, 1)),
                    FunctionHelper.rupiahFormat(FunctionHelper.getDiscount(FunctionProduct.getProductPrice(category, 1), FunctionProduct.getProductDiscount(category))));
            modelDiscountList.add(modelDiscount);
        }

        discountAdapter = new DiscountAdapter(this, modelDiscountList);
        rvDiscount.setAdapter(discountAdapter);
    }

    public void setStatusbar() {
        if (Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(@NonNull Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }

}