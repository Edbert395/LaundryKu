package com.example.myapplication.menu.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.menu.user.User;

import io.realm.Realm;

public class ForgotPasswordActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_forgot_password);

        EditText emailEditText = findViewById(R.id.et_email_forgot_password);
        Button resetPasswordButton = findViewById(R.id.btn_forgot_password);

        resetPasswordButton.setOnClickListener(v -> this.resetPassword(emailEditText.getText().toString()));
    }

    private void resetPassword(String email) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransactionAsync(r -> {
            User user = r.where(User.class).equalTo("email", email).findFirst();
            if (user != null) {
                user.setPassword("pAss123"); // Simplified for example; typically you would send an email or ask for more input
                runOnUiThread(() -> Toast.makeText(this, "Password Reset Successful", Toast.LENGTH_SHORT).show());
                this.navigateToLogin();
                finish();
            } else {
                runOnUiThread(() -> Toast.makeText(this, "Email Not Found", Toast.LENGTH_SHORT).show());
            }
        });


    }

    private void navigateToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
