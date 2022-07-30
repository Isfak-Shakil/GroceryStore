package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEt,passwordEt;
    private TextView forgotTextView;
    private Button loginbtn,signUpLogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        emailEt=findViewById(R.id.email_log_Id);
        passwordEt=findViewById(R.id.password_log_Id);
        forgotTextView=findViewById(R.id.fogotPassword_Log_Id);
        loginbtn=findViewById(R.id.login_btn_Id);
        signUpLogBtn=findViewById(R.id.sign_up_Log_btn_Id);

        forgotTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ForgotPasswordActivity.class));
            }
        });
        signUpLogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterUserActivity.class));
            }
        });
    }
}