package com.example.alldroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomAppBar;
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       bottomAppBar=findViewById(R.id.bottom_navigation);
       navController= Navigation.findNavController(MainActivity.this,R.id.nav_host_fragment_home);

       bottomAppBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()){

                   case R.id.home_nav:
                       navController.navigate(R.id.homeFragment);
                       break;

                   case R.id.map_nav:
                       navController.navigate(R.id.roadMapFragment);
                       break;


                   case R.id.android_nav:
                       Bundle bundle = new Bundle();
                       bundle.putString("url","https://developer.android.com/");
                       navController.navigate(R.id.webViewFragment,bundle);
                       break;


               }

               return true;
           }
       });
    }
}
