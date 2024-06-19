package com.ppb.salsa.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import com.ppb.salsa.R;
import com.ppb.salsa.main.MainActivity;
import com.ppb.salsa.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    MaterialButton btnLogin, btnRegister;
    TextInputEditText inputUser, inputPassword;
    LoginViewModel loginViewModel;
    String strUsername, strPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setInitLayout();
        setInputData();
    }

    private void setInitLayout() {
        inputUser = findViewById(R.id.inputUser);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        loginViewModel = ViewModelProviders.of(LoginActivity.this).get(LoginViewModel.class);
    }

    private void setInputData() {
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strUsername = inputUser.getText().toString();
                strPassword = inputPassword.getText().toString();

                loginViewModel.getDataUser(strUsername, strPassword);

                if (strUsername.isEmpty() || strPassword.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Oops, all forms must be filled in!",
                            Toast.LENGTH_LONG).show();
                } else {
                    loginViewModel.getDataUser(strUsername, strPassword).observe(LoginActivity.this,
                            modelDatabases -> {
                                if (modelDatabases.size() != 0) {
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(LoginActivity.this,
                                            "Oops, your Username or Password is incorrect!", Toast.LENGTH_LONG).show();
                                }
                            });
                }
            }
        });
    }
}
