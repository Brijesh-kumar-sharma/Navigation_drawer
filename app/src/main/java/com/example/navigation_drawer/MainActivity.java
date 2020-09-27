package com.example.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private  DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         drawerLayout =findViewById(R.id.nav_view);

        NavigationView navigationView=findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new HomeFragment());
        Toolbar toolbar=findViewById(R.id.toolbar);

        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_draw_open,R.string.navigation_draw_close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
        }





    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {

            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new HomeFragment()).commit();
                break;
            case R.id.user:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new UserFragment()).commit();
                break;

            case R.id.camera:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new CameraFragment()).commit();
                break;


            case R.id.send:
                Intent intent=new Intent(this,sendActivity.class);
                startActivity(intent);
                break;


        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }



    }
}