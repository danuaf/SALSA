package com.ppb.salsa.utils;

import com.ppb.salsa.R;

public class FunctionLogo {

    public static int[] logoCategories = {
        R.drawable.ic_minuman,
        R.drawable.ic_makanan_instant,
        R.drawable.ic_makanan_ringan,
        R.drawable.ic_bumbu,
        R.drawable.ic_kesehatan,
        R.drawable.ic_lainnya
    };

    public static int[] logoDiscount = {
            R.drawable.ic_discount10,
            R.drawable.ic_discount20,
            R.drawable.ic_discount30,
            R.drawable.ic_discount40,
            R.drawable.ic_discount50,
            R.drawable.ic_discount60,
            R.drawable.ic_discount70,
            R.drawable.ic_discount80,
            R.drawable.ic_discount90
    };

    public static int getCategoriesLogo(String categories){
        switch (categories) {
            case "Minuman":
                return logoCategories[0];
            case "Makanan Instant":
                return logoCategories[1];
            case "Makanan Ringan":
                return logoCategories[2];
            case "Bumbu Instant":
                return logoCategories[3];
            case "Kesehatan":
                return logoCategories[4];
            case "Lainnya":
                return logoCategories[5];
        }
        return R.drawable.bg_rounded;
    }

    public static int getDiscountLogo(int discount){
        switch (discount) {
            case 10:
                return logoDiscount[0];
            case 20:
                return logoDiscount[1];
            case 30:
                return logoDiscount[2];
            case 40:
                return logoDiscount[3];
            case 50:
                return logoDiscount[4];
            case 60:
                return logoDiscount[5];
            case 70:
                return logoDiscount[6];
            case 80:
                return logoDiscount[7];
            case 90:
                return logoDiscount[8];
        }
        return R.drawable.bg_rounded;
    }

}
