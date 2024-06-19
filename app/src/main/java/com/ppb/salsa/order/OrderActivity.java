package com.ppb.salsa.order;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.material.button.MaterialButton;

import com.ppb.salsa.R;
import com.ppb.salsa.main.MainActivity;
import com.ppb.salsa.utils.*;

public class OrderActivity extends AppCompatActivity {

    public static final String DATA_TITLE = "TITLE";
    String strTitle;
    int price1, price2, price3, price4, price5, price6;
    int itemCount1 = 0, itemCount2 = 0, itemCount3 = 0, itemCount4 = 0, itemCount5 = 0, itemCount6 = 0;
    int countP1, countP2, countP3, countP4, countP5, countP6, totalItems, totalPrice;
    ImageView imageAdd1, imageAdd2, imageAdd3, imageAdd4, imageAdd5, imageAdd6,
            imageMinus1, imageMinus2, imageMinus3, imageMinus4, imageMinus5, imageMinus6;
    Toolbar toolbar;
    TextView tvPaket1, tvPaket2, tvPaket3, tvPaket4, tvPaket5, tvPaket6, tvJumlahPorsi, tvTotalPrice;
    MaterialButton btnCheckout;
    OrderViewModel orderViewModel;

    // Testing
    TextView namaProduk1, namaProduk2, namaProduk3, namaProduk4, namaProduk5, namaProduk6;
    TextView hargaProduk1Discount, hargaProduk1, hargaProduk2, hargaProduk3, hargaProduk4, hargaProduk5, hargaProduk6;
    TextView lokasiTerbaru, namaToko, lokasiToko;
    ImageView imageDiscountLogo, imageProduct1, imageProduct2, imageProduct3, imageProduct4, imageProduct5, imageProduct6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        setStatusbar();
        setInitLayout();
        setInitPrice();
        setLocation();
        setPaket1();
        setPaket2();
        setPaket3();
        setPaket4();
        setPaket5();
        setPaket6();
        setInputData();

    }


    private void setInitLayout() {
        toolbar = findViewById(R.id.toolbar);
        tvPaket1 = findViewById(R.id.tvPaket1);
        tvPaket2 = findViewById(R.id.tvPaket2);
        tvPaket3 = findViewById(R.id.tvPaket3);
        tvPaket4 = findViewById(R.id.tvPaket4);
        tvPaket5 = findViewById(R.id.tvPaket5);
        tvPaket6 = findViewById(R.id.tvPaket6);
        tvJumlahPorsi = findViewById(R.id.tvJumlahPorsi);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        imageAdd1 = findViewById(R.id.imageAdd1);
        imageAdd2 = findViewById(R.id.imageAdd2);
        imageAdd3 = findViewById(R.id.imageAdd3);
        imageAdd4 = findViewById(R.id.imageAdd4);
        imageAdd5 = findViewById(R.id.imageAdd5);
        imageAdd6 = findViewById(R.id.imageAdd6);
        imageMinus1 = findViewById(R.id.imageMinus1);
        imageMinus2 = findViewById(R.id.imageMinus2);
        imageMinus3 = findViewById(R.id.imageMinus3);
        imageMinus4 = findViewById(R.id.imageMinus4);
        imageMinus5 = findViewById(R.id.imageMinus5);
        imageMinus6 = findViewById(R.id.imageMinus6);
        btnCheckout = findViewById(R.id.btnCheckout);

        namaProduk1 = findViewById(R.id.namaProduk1);
        namaProduk2 = findViewById(R.id.namaProduk2);
        namaProduk3 = findViewById(R.id.namaProduk3);
        namaProduk4 = findViewById(R.id.namaProduk4);
        namaProduk5 = findViewById(R.id.namaProduk5);
        namaProduk6 = findViewById(R.id.namaProduk6);

        hargaProduk1Discount = findViewById(R.id.hargaProduk1Discount);
        hargaProduk1 = findViewById(R.id.hargaProduk1);
        hargaProduk2 = findViewById(R.id.hargaProduk2);
        hargaProduk3 = findViewById(R.id.hargaProduk3);
        hargaProduk4 = findViewById(R.id.hargaProduk4);
        hargaProduk5 = findViewById(R.id.hargaProduk5);
        hargaProduk6 = findViewById(R.id.hargaProduk6);

        imageDiscountLogo = findViewById(R.id.imgDiscountLogoLayout);
        imageProduct1 = findViewById(R.id.imgProduk1);
        imageProduct2 = findViewById(R.id.imgProduk2);
        imageProduct3 = findViewById(R.id.imgProduk3);
        imageProduct4 = findViewById(R.id.imgProduk4);
        imageProduct5 = findViewById(R.id.imgProduk5);
        imageProduct6 = findViewById(R.id.imgProduk6);

        lokasiTerbaru = findViewById(R.id.tvOrderLokasi);
        lokasiToko = findViewById(R.id.tvOrderAlamatToko);
        namaToko = findViewById(R.id.tvOrderNamaToko);

        strTitle = getIntent().getExtras().getString(DATA_TITLE);
        if (strTitle != null) {

            setSupportActionBar(toolbar);
            assert getSupportActionBar() != null;
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(strTitle);
        }

        orderViewModel = ViewModelProviders.of(this).get(OrderViewModel.class);
    }

    private void setInitPrice(){
        price1 = FunctionProduct.getProductPrice(strTitle, 1);
        price2 = FunctionProduct.getProductPrice(strTitle, 2);
        price3 = FunctionProduct.getProductPrice(strTitle, 3);
        price4 = FunctionProduct.getProductPrice(strTitle, 4);
        price5 = FunctionProduct.getProductPrice(strTitle, 5);
        price6 = FunctionProduct.getProductPrice(strTitle, 6);
    }


    private void setLocation(){
        String[] locationParts = MainActivity.location.split(",");

        lokasiTerbaru.setText(MainActivity.location);
        namaToko.setText("Pick up your order at SalsaMart " + locationParts[1]);
        lokasiToko.setText("Ruko Halu No. 100, " + MainActivity.location);
    }

    private void setPaket1() {
        imageDiscountLogo.setImageResource(FunctionLogo.getDiscountLogo(FunctionProduct.getProductDiscount(strTitle)));
        imageProduct1.setImageResource(FunctionProduct.getProductImage(strTitle, 1));
        namaProduk1.setText(FunctionProduct.getProductName(strTitle,1));
        hargaProduk1.setText(FunctionHelper.rupiahFormat(price1));
        hargaProduk1Discount.setText(FunctionHelper.rupiahFormat(FunctionHelper.getDiscount(price1, FunctionProduct.getProductDiscount(strTitle))));

        hargaProduk1.setPaintFlags(hargaProduk1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        imageAdd1.setOnClickListener(v -> {
            itemCount1 = itemCount1 + 1;
            tvPaket1.setText(String.valueOf(itemCount1));
            countP1 = FunctionHelper.getDiscount(price1, 50) * itemCount1;
            setTotalPrice();
        });

        imageMinus1.setOnClickListener(v -> {
            if (itemCount1 > 0) {
                itemCount1 = itemCount1 - 1;
                tvPaket1.setText(String.valueOf(itemCount1));
            }
            countP1 = price1 * itemCount1;
            setTotalPrice();
        });
    }

    private void setPaket2() {
        imageProduct2.setImageResource(FunctionProduct.getProductImage(strTitle, 2));
        namaProduk2.setText(FunctionProduct.getProductName(strTitle,2));
        hargaProduk2.setText(FunctionHelper.rupiahFormat(price2));

        imageAdd2.setOnClickListener(v -> {
            itemCount2 = itemCount2 + 1;
            tvPaket2.setText(String.valueOf(itemCount2));
            countP2 = price2 * itemCount2;
            setTotalPrice();
        });

        imageMinus2.setOnClickListener(v -> {
            if (itemCount2 > 0) {
                itemCount2 = itemCount2 - 1;
                tvPaket2.setText(String.valueOf(itemCount2));
            }
            countP2 = price2 * itemCount2;
            setTotalPrice();
        });
    }

    private void setPaket3() {
        imageProduct3.setImageResource(FunctionProduct.getProductImage(strTitle, 3));
        namaProduk3.setText(FunctionProduct.getProductName(strTitle,3));
        hargaProduk3.setText(FunctionHelper.rupiahFormat(price3));

        imageAdd3.setOnClickListener(v -> {
            itemCount3 = itemCount3 + 1;
            tvPaket3.setText(String.valueOf(itemCount3));
            countP3 = price3 * itemCount3;
            setTotalPrice();
        });

        imageMinus3.setOnClickListener(v -> {
            if (itemCount3 > 0) {
                itemCount3 = itemCount3 - 1;
                tvPaket3.setText(String.valueOf(itemCount3));
            }
            countP3 = price3 * itemCount3;
            setTotalPrice();
        });
    }

    private void setPaket4() {
        imageProduct4.setImageResource(FunctionProduct.getProductImage(strTitle, 4));
        namaProduk4.setText(FunctionProduct.getProductName(strTitle,4));
        hargaProduk4.setText(FunctionHelper.rupiahFormat(price4));

        imageAdd4.setOnClickListener(v -> {
            itemCount4 = itemCount4 + 1;
            tvPaket4.setText(String.valueOf(itemCount4));
            countP4 = price4 * itemCount4;
            setTotalPrice();
        });

        imageMinus4.setOnClickListener(v -> {
            if (itemCount4 > 0) {
                itemCount4 = itemCount4 - 1;
                tvPaket4.setText(String.valueOf(itemCount4));
            }
            countP4 = price4 * itemCount4;
            setTotalPrice();
        });
    }

    private void setPaket5() {
        imageProduct5.setImageResource(FunctionProduct.getProductImage(strTitle, 5));
        namaProduk5.setText(FunctionProduct.getProductName(strTitle,5));
        hargaProduk5.setText(FunctionHelper.rupiahFormat(price5));

        imageAdd5.setOnClickListener(v -> {
            itemCount5 = itemCount1 + 1;
            tvPaket5.setText(String.valueOf(itemCount5));
            countP5 = price5 * itemCount5;
            setTotalPrice();
        });

        imageMinus5.setOnClickListener(v -> {
            if (itemCount5 > 0) {
                itemCount5 = itemCount5 - 1;
                tvPaket5.setText(String.valueOf(itemCount5));
            }
            countP5 = price5 * itemCount5;
            setTotalPrice();
        });
    }

    private void setPaket6() {
        imageProduct6.setImageResource(FunctionProduct.getProductImage(strTitle, 6));
        namaProduk6.setText(FunctionProduct.getProductName(strTitle,6));
        hargaProduk6.setText(FunctionHelper.rupiahFormat(price6));

        imageAdd6.setOnClickListener(v -> {
            itemCount6 = itemCount6 + 1;
            tvPaket6.setText(String.valueOf(itemCount6));
            countP6 = price6 * itemCount6;
            setTotalPrice();
        });

        imageMinus6.setOnClickListener(v -> {
            if (itemCount6 > 0) {
                itemCount6 = itemCount6 - 1;
                tvPaket6.setText(String.valueOf(itemCount6));
            }
            countP6 = price6 * itemCount6;
            setTotalPrice();
        });
    }

    private void setTotalPrice() {
        totalItems = itemCount1 + itemCount2 + itemCount3 + itemCount4 + itemCount5 + itemCount6;
        totalPrice = countP1 + countP2 + countP3 + countP4 + countP5 + countP6;

        tvJumlahPorsi.setText(totalItems + " items");
        tvTotalPrice.setText(FunctionHelper.rupiahFormat(totalPrice));
    }

    private void setInputData() {
        btnCheckout.setOnClickListener(v -> {
            if (totalItems == 0 || totalPrice == 0) {
                Toast.makeText(OrderActivity.this, "Oops, select the product first!",
                        Toast.LENGTH_SHORT).show();
            }else {

                orderViewModel.addDataOrder(strTitle, totalItems, totalPrice);
                Toast.makeText(OrderActivity.this,
                        "Yeay! Your order is successful, check the order history menu!!",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public void setStatusbar() {
        if (Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
