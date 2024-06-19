package com.ppb.salsa.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class FunctionLocation {

    private static final int REQUEST_CODE_LOCATION_PERMISSION = 1;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private Activity activity;
    private LocationCallback callback;

    public interface LocationCallback {
        void onLocationResult(String location);
    }

    public FunctionLocation(Activity activity, LocationCallback callback) {
        this.activity = activity;
        this.callback = callback;
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity);

        checkPermissionsAndGetLocation();
    }

    private void checkPermissionsAndGetLocation() {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ContextCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE_LOCATION_PERMISSION);
        } else {
            getLocation();
        }
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                callback.onLocationResult("Izin lokasi ditolak");
            }
        }
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
            @Override
            public void onComplete(@NonNull Task<Location> task) {
                if (task.isSuccessful() && task.getResult() != null) {
                    Location location = task.getResult();
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();

                    Geocoder geocoder = new Geocoder(activity, Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
                        if (addresses != null && !addresses.isEmpty()) {
                            Address address = addresses.get(0);
                            String villageName = address.getThoroughfare()+ ", " + address.getSubLocality() + ", " + address.getLocality(); // Nama desa

                            if (villageName == null) {
                                villageName = address.getLocality();
                            }
                            if (villageName == null) {
                                villageName = address.getFeatureName();
                            }

                            callback.onLocationResult(villageName != null ? villageName : "Nama daerah tidak ditemukan");
                        } else {
                            callback.onLocationResult("Alamat tidak ditemukan");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        callback.onLocationResult("Gagal mendapatkan alamat");
                    }
                } else {
                    callback.onLocationResult("Gagal mendapatkan lokasi");
                }
            }
        });
    }
}