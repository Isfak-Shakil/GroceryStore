package com.example.grocery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class RegisterSellerActivity extends AppCompatActivity implements LocationListener{
    private ImageButton backbtn,gpsbtn;
    private ImageView profileIv;
    private EditText nameEt,shopNameEt,delivaryFeeEt, phoneEt,countryEt,stateEt,cityEt,emailEt,addressEt,passwordEt,confirmPasswEt;
    private Button registerBtn;

    //permission constant
    private  static  final int LOCATION_REQUEST_CODE=100;

    //permission array
    private  String[] locationPermission;

    private Double latitude=0.0,longitude=0.0;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_seller);
        backbtn=findViewById(R.id.back_btn_Id);
        gpsbtn=findViewById(R.id.gps_btn_Id);
        profileIv=findViewById(R.id.profile_reg_user_Id);
        nameEt=findViewById(R.id.name_reg_Id);
        shopNameEt=findViewById(R.id.shopName_reg_Id);
        delivaryFeeEt=findViewById(R.id.delivaryEt_reg_Id);
        phoneEt=findViewById(R.id.phone_reg_Id);
        countryEt=findViewById(R.id.country_reg_Id);
        stateEt=findViewById(R.id.state_reg_Id);
        cityEt=findViewById(R.id.city_reg_Id);
        addressEt=findViewById(R.id.addressEt_Id);
        emailEt=findViewById(R.id.email_reg_Id);
        passwordEt=findViewById(R.id.password_reg_Id);
        confirmPasswEt=findViewById(R.id.confirm_password_reg_Id);
        registerBtn=findViewById(R.id.register_user_btn_Id);

        //init permission array
        locationPermission=new String[]{Manifest.permission.ACCESS_FINE_LOCATION};


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        profileIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        gpsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //Detect current Locatoion
                if (checkLocationPermission()){
                    //already allowed
                    detectLocation();
                }else {
                    //not allowed,request
                    requestLocationPermission();
                }
            }
        });
    }

    private  boolean checkLocationPermission(){
        boolean result= ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) ==
                (PackageManager.PERMISSION_GRANTED);
        return result;
    }
    private  void requestLocationPermission(){
        ActivityCompat.requestPermissions(this,locationPermission,LOCATION_REQUEST_CODE);
    }

    private void detectLocation() {
        Toast.makeText(this,"Please wait.....",Toast.LENGTH_LONG).show();
        locationManager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
    }
    private  void findAddress(){
        //find address,city,state,country
        Geocoder geocoder;
        List<Address> addresses;
        geocoder=new Geocoder(this, Locale.getDefault());
        try {
            addresses=geocoder.getFromLocation(latitude,longitude,1);
            String address=addresses.get(0).getAddressLine(0); //complete address
            String city=addresses.get(0).getLocality();
            String state=addresses.get(0).getAdminArea();
            String country=addresses.get(0).getCountryName();

            //set address
            countryEt.setText(country);
            stateEt.setText(state);
            cityEt.setText(city);
            addressEt.setText(address);

        }catch (Exception e){
            Toast.makeText(this,""+e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        //Location detected
        latitude=location.getLatitude();
        longitude=location.getLongitude();
        findAddress();

    }
    @Override
    public void onLocationChanged(@NonNull List<Location> locations) {

    }
    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }
    @Override
    public void onProviderDisabled(@NonNull String provider) {
        //gps /location disable
        Toast.makeText(this,"Please turn on location",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case LOCATION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    boolean locationAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    if (locationAccepted) {
                        //permission allowed
                        detectLocation();
                    } else {
                        //permission Denied
                        Toast.makeText(this, "Location permission is necessary.....", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}