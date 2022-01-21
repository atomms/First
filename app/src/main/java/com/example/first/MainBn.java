package com.example.first;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.first.ui.main.SectionsPagerAdapter;
import com.example.first.databinding.ActivityMainBnBinding;

public class MainBn extends AppCompatActivity {

    private ActivityMainBnBinding binding;
    private MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // el adaptador coloca las Pages -los fragmentos con las diferentes vistas- dentro de la vista padre Viewpager del xml
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;

        viewPager.setAdapter(sectionsPagerAdapter);

//        TabLayout tabs = binding.tabs;
//        tabs.setupWithViewPager(viewPager);

        // cast al xml
        BottomNavigationView mybottomNavView = findViewById(R.id.bottom_navigation);


        //El listener del menú
        mybottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.heart:
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Heart clicked.", Toast.LENGTH_SHORT).show();
//                        removeBadge(mybottomNavView,item.getItemId());
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.add:
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Add clicked.", Toast.LENGTH_SHORT).show();
//                        removeBadge(mybottomNavView,item.getItemId());
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.browse:
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Browse clicked.", Toast.LENGTH_SHORT).show();
//                        removeBadge(mybottomNavView,item.getItemId());
                        viewPager.setCurrentItem(2);

                        break;
                    case R.id.profile:
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Profile clicked.", Toast.LENGTH_SHORT).show();
//                        removeBadge(mybottomNavView,item.getItemId());
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });


//        here we listen to viewpager moves and set navigations items checked or not

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null)
                    prevMenuItem.setChecked(false);

                else
                    mybottomNavView.getMenu().getItem(0).setChecked(false);

                mybottomNavView.getMenu().getItem(position).setChecked(true);
//                removeBadge(mybottomNavView,mybottomNavView.getMenu().getItem(position).getItemId());
                prevMenuItem = mybottomNavView.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }




//        FloatingActionButton fab = binding.fab;
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
