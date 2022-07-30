package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class ForgotPasswordActivity extends AppCompatActivity {
    private ImageButton backBtn;
    private EditText emailRecorver;
    private Button recoverbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        backBtn=findViewById(R.id.back_btn_Id);
        emailRecorver=findViewById(R.id.email_recorver_Id);
        recoverbtn=findViewById(R.id.recover_btn_Id);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}