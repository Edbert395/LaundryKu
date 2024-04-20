package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import com.example.myapplication.menu.auth.LoginActivity;
import com.example.myapplication.menu.home.HomeFragment;
import com.example.myapplication.menu.message.MessageFragment;
import com.example.myapplication.menu.notification.NotificationFragment;
import com.example.myapplication.menu.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            this.loadHomeFragment();
        }
    }


    private void loadHomeFragment() {
        setToolbar();
        initViews();
        handleIntent();
        initComponentsNavHeader();

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, homeFragment); // Ensure you have a 'fragment_container' in your layout
        transaction.commit();

    }

    // Optionally handle back navigation from RegisterActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Handle result from RegisterActivity
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private boolean isLoggedIn() {
        // Implement your logic to check if user is logged in
        // This might involve checking shared preferences or Realm for user session data
        return false;
    }
    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(0);
    }

    private void handleIntent(){

        NavigationView navigation = findViewById(R.id.nav_view);
        View headerView = navigation.getHeaderView(0);
        // Set email to navigation drawer or menu bar as needed
        TextView emailTextView = headerView.findViewById(R.id.tv_email_header);


        Intent intent = getIntent();
        String userEmail = intent.getStringExtra("USER_EMAIL"); // Retrieve the email passed from LoginActivity
        if (userEmail != null && emailTextView != null) {
            Log.d( "This is my message: ", userEmail);
            emailTextView.setText(userEmail);
        }else{
            Log.e("MainActivity", "Email or email TextView not found");
        }


    }
    private void initViews() {
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        /**
         * Menu Navigation Drawer
         **/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(view -> drawer.openDrawer(GravityCompat.START));
        toggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
        toggle.syncState();
    }

    /**
     * Menu Bottom Navigation Drawer
     * */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment = null;

        int itemId = item.getItemId();

        if(itemId == R.id.nav_menu_home){
            fragment = new HomeFragment();
        }else if(itemId == R.id.nav_menu_location){
            fragment = new SearchFragment();
        }else if(itemId == R.id.nav_menu_article){
            fragment = new NotificationFragment();
        }else if(itemId == R.id.nav_menu_message){
            fragment = new MessageFragment();
        }

        return loadFragment(fragment);
    }

    private void initComponentsNavHeader(){
//        int itemId = R.id.nav_view;
        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setItemIconTintList(null); //disable tint on each icon to use color icon svg
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();

                if(itemId == R.id.nav_my_account){
                    Pesan("My Account");
                    return false;
                }else if(itemId == R.id.nav_support){
                    Pesan("My Account");
                    return false;
                }else if(itemId == R.id.nav_setting){
                    Pesan("Setting");
                    return false;
                }else if(itemId == R.id.nav_help){
                    Pesan("Help");
                    return false;
                }


                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }

            private void Pesan(String pesan) {
                Toast.makeText(MainActivity.this, pesan, Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * Fragment
     **/
    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_profile) {
            Uri uri = Uri.parse("https://github.com/");
            startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Choose Browser"));
        }
        return true;
    }


}