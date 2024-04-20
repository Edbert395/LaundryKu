package com.example.myapplication.menu.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.menu.user.User;

import io.realm.Realm;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class RegisterActivity extends AppCompatActivity {


    public RegisterActivity() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_register);

        final EditText emailEditText = findViewById(R.id.et_email_register);
        final EditText passwordEditText = findViewById(R.id.et_password_register);
        final EditText confirmPasswordEditText = findViewById(R.id.et_repassword_register);
        final TextView loginButton = findViewById(R.id.gotoLoginButton);
        Button registerButton = findViewById(R.id.btn_register);
        // function trigger after click register button in the view
        registerButton.setOnClickListener(v -> {

            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            String confirmPassword = confirmPasswordEditText.getText().toString();

            // call method create account
            register(email, password,confirmPassword);
        });

        loginButton.setOnClickListener(v -> this.navigateToLogin());


    }

    public void register(String email, String password, String confirmPassword){
        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Email or password cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        // use hash encryption to protect the password
        String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());

        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(r -> {
            User user = r.createObject(User.class, email);
//            user.setPassword(password); //old set password without encryption
            user.setPassword(hashedPassword); // use encryption password
        }, () -> {
            runOnUiThread(() -> {
                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                this.navigateToLogin();

            });
        }, error -> runOnUiThread(() -> Toast.makeText(this, "Registration Failed: " + error.getMessage(), Toast.LENGTH_SHORT).show()));
        realm.close();
    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

}