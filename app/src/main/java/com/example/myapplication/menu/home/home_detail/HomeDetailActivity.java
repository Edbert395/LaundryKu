package com.example.myapplication.menu.home.home_detail;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;


public class HomeDetailActivity extends AppCompatActivity {
    private ImageButton buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.activity_home_detail);

        buttonBack = findViewById(R.id.button_back);
        TextView textName = findViewById(R.id.text_name);
        TextView textLocation = findViewById(R.id.item_recommended_location);
        TextView textPrice = findViewById(R.id.rate); // Assuming you want to show price in 'rate' TextView
        ImageView imageView = findViewById(R.id.image_location); // Assuming you want to show image here

        if (getIntent() != null) {
            int image = getIntent().getIntExtra("Image", 0);
            String name = getIntent().getStringExtra("Name");
            String price = getIntent().getStringExtra("Price");
            String location = getIntent().getStringExtra("Location");

            textName.setText(name);
            textPrice.setText(price);
            textLocation.setText(location);
            imageView.setBackgroundResource(image); // Set the image resource to your ImageView
        }


//        go back to previous page
        buttonBack.setOnClickListener(view -> onBackPressed());
    }

    @SuppressLint("ObsoleteSdkInt")
    private void hideStatusBar() {
        try {
            if (Build.VERSION.SDK_INT >= 19) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().getDecorView().setSystemUiVisibility(3328);
            } else {
                requestWindowFeature(Window.FEATURE_NO_TITLE);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}