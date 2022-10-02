package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AddProductActivity extends AppCompatActivity {

    private ImageButton backBtn;
    private ImageView productIconIv;
    private EditText titleEt,descriptionEt;
    private TextView categroyEt,quantityEt,priceEt,discountedPriceEt,discountedNoteEt;
    private SwitchCompat discountSwitch;
    private Button addProductBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        backBtn=findViewById(R.id.back_btn_Id);
        productIconIv=findViewById(R.id.productIconIv);
        titleEt=findViewById(R.id.titleEt);
        descriptionEt=findViewById(R.id.descriptionEt);
        categroyEt=findViewById(R.id.categoryTv);
        quantityEt=findViewById(R.id.quantityEt);
        priceEt=findViewById(R.id.priceEt);
        discountedPriceEt=findViewById(R.id.discountPriceEt);
        discountedNoteEt=findViewById(R.id.discountNoteeEt);
        discountSwitch=findViewById(R.id.discountSwitchId);
        addProductBtn=findViewById(R.id.addProductBtn);
    }
}