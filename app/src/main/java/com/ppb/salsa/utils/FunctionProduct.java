package com.ppb.salsa.utils;


import com.ppb.salsa.R;

public class FunctionProduct {

    // Produk [Kategori][Nama Produk]
    private static final String[][] productName = {
            {"NU Greentea Madu", "Sprite Lemon Lime", "Marimas Rasa Jeruk", "Ichitan Series", "Kunyit Asem", "Susu Indomilk Series"},    // Minuman
            {"Indomie Goreng Rendang", "Indomie Goreng Jumbo", "Indomie Soto Padang", "Indomie Soto", "Indomie Goreng Pedas", "Indomie Kari Ayam" },   // Makanan Instan
            {"Beng-beng Shake it", "Chitato Sapi Panggang", "TicTac Sapi Panggang", "Lays Rumput Laut", "Qtela Barbeque", "Sponge Chocolate"},  // Makanan Ringan
            {"Racik Soto Ayam", "Racik Ikan Goreng", "Bamboe Nasi Goreng", "Royco Sapi", "Munik Tom Yam", "Bumbu Kentang Goreng"},  // Bumbu Makanan
            {"Tolak Angin Sidomuncul", "Permen Herbal Antangin", "Minyak Kayu Putih Cap Lang", "Vicee Vitamin C", "My Baby Minyak Telon", "Salonpas Koyo"}, // Kesehatan
            {"Devall Face Mask", "Pulpen Snowman V7", "Refill Ink Snowman", "Spidol Snowman", "Gunting", "Glue Stick ZRM"}  // Lainnya
    };

    private static final int[][] priceProduct = {
        {7000,6500,500,10000,17500,5500},    // Minuman
        {3100,5500,3100,3100,3100,3100},     // Makanan Instan
        {13000,13000,8000,8000,7500,12500},  // Makanan Ringan
        {3500,3500,6500,8500,38000,4500},    // Bumbu Makanan
        {4500,4500,9800,2000,20000,8300},    // Kesehatan
        {60000,2000,16500,7500,6000,2000}    // Lainnya
    };

    private static final int[][] productImage = {
            {R.drawable.minuman1,R.drawable.minuman2,R.drawable.minuman3,R.drawable.minuman4,R.drawable.minuman5,R.drawable.minuman6},    // Minuman
            {R.drawable.makanan_instant1,R.drawable.makanan_instant2,R.drawable.makanan_instant3,R.drawable.makanan_instant4,R.drawable.makanan_instant5,R.drawable.makanan_instant6},    // Makanan Instan
            {R.drawable.makanan_ringan1,R.drawable.makanan_ringan2,R.drawable.makanan_ringan3,R.drawable.makanan_ringan4,R.drawable.makanan_ringan5,R.drawable.makanan_ringan6},    // Makanan Ringan
            {R.drawable.bumbu1,R.drawable.bumbu2,R.drawable.bumbu3,R.drawable.bumbu4,R.drawable.bumbu5,R.drawable.bumbu6},    // Bumbu Makanan
            {R.drawable.kesehatan1,R.drawable.kesehatan2,R.drawable.kesehatan3,R.drawable.kesehatan4,R.drawable.kesehatan5,R.drawable.kesehatan6},    // Kesehatan
            {R.drawable.lain1,R.drawable.lain2,R.drawable.lain3,R.drawable.lain4,R.drawable.lain5,R.drawable.lain6}     // Lainnya
    };

    private static final int[] imageProductDiscount = {
            R.drawable.discount_produk1,
            R.drawable.discount_produk2,
            R.drawable.discount_produk3,
            R.drawable.discount_produk4,
            R.drawable.discount_produk5,
            R.drawable.discount_produk6
    };

    private static final int[] producDiscount = {30, 20, 40, 20, 10, 50, 1};


    public static String getProductName(String categories, int id) {
        switch (categories) {
            case "Minuman":
                return productName[0][id - 1];
            case "Makanan Instant":
                return productName[1][id - 1];
            case "Makanan Ringan":
                return productName[2][id - 1];
            case "Bumbu Instant":
                return productName[3][id - 1];
            case "Kesehatan":
                return productName[4][id - 1];
            case "Lainnya":
                return productName[5][id - 1];
        }
        return "Null";
    }

    public static int getProductPrice(String categories, int id) {
        switch (categories) {
            case "Minuman":
                return priceProduct[0][id - 1];
            case "Makanan Instant":
                return priceProduct[1][id - 1];
            case "Makanan Ringan":
                return priceProduct[2][id - 1];
            case "Bumbu Instant":
                return priceProduct[3][id - 1];
            case "Kesehatan":
                return priceProduct[4][id - 1];
            case "Lainnya":
                return priceProduct[5][id - 1];
        }
        return 0;
    }

    public static int getProductImage(String categories, int id){
        switch (categories) {
            case "Minuman":
                return productImage[0][id - 1];
            case "Makanan Instant":
                return productImage[1][id - 1];
            case "Makanan Ringan":
                return productImage[2][id - 1];
            case "Bumbu Instant":
                return productImage[3][id - 1];
            case "Kesehatan":
                return productImage[4][id - 1];
            case "Lainnya":
                return productImage[5][id - 1];
        }
        return R.drawable.ic_add;
    }

    public static int getProductDiscount(String categories){
        switch (categories) {
            case "Minuman":
                return producDiscount[0];
            case "Makanan Instant":
                return producDiscount[1];
            case "Makanan Ringan":
                return producDiscount[2];
            case "Bumbu Instant":
                return producDiscount[3];
            case "Kesehatan":
                return producDiscount[4];
            case "Lainnya":
                return producDiscount[5];
        }
        return producDiscount[6];
    }

    public static String getProductDiscountName(String categories) {
        switch (categories) {
            case "Minuman":
                return productName[0][0];
            case "Makanan Instant":
                return productName[1][0];
            case "Makanan Ringan":
                return productName[2][0];
            case "Bumbu Instant":
                return productName[3][0];
            case "Kesehatan":
                return productName[4][0];
            case "Lainnya":
                return productName[5][0];
        }
        return "Null";
    }

    public static int getProductDiscountImage(String categories){
        switch (categories) {
            case "Minuman":
                return imageProductDiscount[0];
            case "Makanan Instant":
                return imageProductDiscount[1];
            case "Makanan Ringan":
                return imageProductDiscount[2];
            case "Bumbu Instant":
                return imageProductDiscount[3];
            case "Kesehatan":
                return imageProductDiscount[4];
            case "Lainnya":
                return imageProductDiscount[5];
        }
        return R.drawable.ic_add;
    }

}
