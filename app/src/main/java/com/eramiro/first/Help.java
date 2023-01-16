package com.eramiro.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.eramiro.first.databinding.ActivityMainBinding;
import com.eramiro.first.ui.main.HelpSectionsPagerAdapter;


public class Help extends AppCompatActivity {

    private ActivityMainBinding binding;
    private HelpSectionsPagerAdapter helpSectionsPagerAdapter;
    String prevStarted = "yes";

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedpreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (!sharedpreferences.getBoolean(prevStarted, false)) {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putBoolean(prevStarted, Boolean.TRUE);
            editor.apply();
        } else {
            moveToSecondary();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        helpSectionsPagerAdapter = new HelpSectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager2 = findViewById(R.id.view_hpager);
        viewPager2.setAdapter(helpSectionsPagerAdapter);
//        TabLayout tabs = binding.tabs;
//        tabs.setupWithViewPager(viewPager);
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


    public void moveToSecondary(){
        // use an intent to travel from one activity to another.
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }

}