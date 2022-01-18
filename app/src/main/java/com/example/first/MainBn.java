package com.example.first;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
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

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
//        FloatingActionButton fab = binding.fab;

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


// cast al xml
        BottomNavigationView bottomNavBar = findViewById(R.id.bottom_navigation);

        // crear badges
        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) bottomNavBar.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(2);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        LayoutInflater.from(this)
                .inflate(R.layout.layout_badge, itemView, true);


        bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.likes:
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.add:
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.profile:
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
                        viewPager.setCurrentItem(2);

                        break;
                    case R.id.marker:
                        item.setChecked(true);
                        Toast.makeText(MainBn.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        removeBadge(bottomNavBar,item.getItemId());
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
                    bottomNavBar.getMenu().getItem(0).setChecked(false);

                bottomNavBar.getMenu().getItem(position).setChecked(true);
                removeBadge(bottomNavBar,bottomNavBar.getMenu().getItem(position).getItemId());
                prevMenuItem = bottomNavBar.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    //removong badges
    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);
        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }

    }
