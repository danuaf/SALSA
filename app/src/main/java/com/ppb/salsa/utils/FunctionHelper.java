package com.ppb.salsa.utils;

import android.text.format.DateFormat;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class FunctionHelper {

    public static String getRandomString(){
        String Character = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(5);

        for(int i = 0; i < 5; i++){
            sb.append(Character.charAt(random.nextInt(Character.length())));
        }

        return sb.toString();
    }

    public static String rupiahFormat(int price) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return "Rp " + formatter.format(price).replaceAll(",", ".");
    }

    public static String getToday() {
        Date date = Calendar.getInstance().getTime();
        return (String) DateFormat.format("d MMMM yyyy", date);
    }

    public static String timeGreeting(){

        int now = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        if (now >= 5 && now < 12){
            return "Good Morning";
        }
        else if (now >= 12 && now < 18){
            return "Good Afternoon";
        }
        else if (now >= 18 && now <= 24 || now >= 0 && now < 5){
            return "Good Evening";
        }

        return "Welcome";
    }

    public static int getDiscount(int normalPrice, int discount){
        return normalPrice - (normalPrice/100 * discount);
    }

}
