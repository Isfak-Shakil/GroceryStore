package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class RegisterSellerActivity extends AppCompatActivity {
    private ImageButton backbtn,gpsbtn;
    private ImageView profileIv;
    private EditText nameEt,shopNameEt,delivaryFeeEt, phoneEt,countryEt,stateEt,cityEt,emailEt,addressEt,passwordEt,confirmPasswEt;
    private Button registerBtn;

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


        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}