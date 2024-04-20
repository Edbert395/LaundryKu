package com.example.myapplication.menu.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.menu.user.User;

import io.realm.Realm;
import io.realm.RealmConfiguration;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class LoginActivity extends AppCompatActivity {


    public LoginActivity() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_login);

        final EditText emailEditText = findViewById(R.id.et_email_login);
        final EditText passwordEditText = findViewById(R.id.et_password_login);
        final Button loginButton = findViewById(R.id.btn_login);
        final TextView registerButton = findViewById(R.id.gotoRegisterButton);
        final TextView forgotPasswordButton = findViewById(R.id.gotoForgotPasswordButton);


        loginButton.setOnClickListener(v -> {
            String email = emailEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            this.attemptLogin(email, password);
        });

        forgotPasswordButton.setOnClickListener(v -> this.navigateToForgotPassword());
        registerButton.setOnClickListener(v -> this.navigateToRegister());

    }

    private void attemptLogin(String email, String password) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransactionAsync(r -> {
            User user = r.where(User.class).equalTo("email", email).findFirst();
            if (user != null && BCrypt.verifyer().verify(password.toCharArray(), user.getPassword()).verified) {
                // Login successful
//                finish();
                runOnUiThread(() -> {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                    // Assume MainActivity hosts the HomeFragment
                    this.goToHomeFragment(email);
                });
            } else {
                // Login failed
                runOnUiThread(() ->
                        Toast.makeText(this, "Invalid Credentials - " +
                                "Email or Password", Toast.LENGTH_SHORT).show());
            }
        });
        realm.close();
    }

    private void navigateToRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void navigateToForgotPassword() {
        Intent intent = new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }

    private void goToHomeFragment(String emailUser) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("USER_EMAIL", emailUser);
        startActivity(intent);
        finish();
//        intent.putExtra("LoginSuccess", true);
    }

}