package com.eramiro.first;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.eramiro.first.ui.main.SectionsPagerAdapter;
import com.eramiro.first.databinding.ActivityMainBnBinding;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

/**
 * gradle update
 */
public class MainBn extends AppCompatActivity {

//    private ActivityMainBnBinding binding;
    private MenuItem prevMenuItem;
    private SectionsPagerAdapter sectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bn);
//        binding = ActivityMainBnBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

        // Configuración del adaptador para manejar fragmentos en el ViewPager
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager1 = findViewById(R.id.view_pager);
        viewPager1.setAdapter(sectionsPagerAdapter);


        // ... inside your Activity or Fragment ...

        DotsIndicator dotsIndicator = findViewById(R.id.dots_indicator);
//        ViewPager viewPager = findViewById(R.id.view_pager);
//        ViewPagerAdapter adapter = new ViewPagerAdapter();
//        viewPager.setAdapter(adapter);
        dotsIndicator.attachTo(viewPager1);


        // Configuración de la barra de navegación inferior
        BottomNavigationView mybottomNavView = findViewById(R.id.bottom_navigation);

        // Crear badges
        BottomNavigationMenuView bottomNavigationMenuView =
                (BottomNavigationMenuView) mybottomNavView.getChildAt(0);
        View v = bottomNavigationMenuView.getChildAt(2);
        BottomNavigationItemView itemView = (BottomNavigationItemView) v;

        LayoutInflater.from(this)
                .inflate(R.layout.layout_badge, itemView, true);

        // Manejo de la selección de ítems en la barra de navegación
        mybottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.likes) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Likes clicked.", Toast.LENGTH_SHORT).show();
                    removeBadge(mybottomNavView, item.getItemId());
                    viewPager1.setCurrentItem(0);
                } else if (item.getItemId() == R.id.add) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                    removeBadge(mybottomNavView, item.getItemId());
                    viewPager1.setCurrentItem(1);
                } else if (item.getItemId() == R.id.browse) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Browse clicked.", Toast.LENGTH_SHORT).show();
                    removeBadge(mybottomNavView, item.getItemId());
                    viewPager1.setCurrentItem(2);
                } else if (item.getItemId() == R.id.personal) {
                    item.setChecked(true);
                    Toast.makeText(MainBn.this, "Personal clicked.", Toast.LENGTH_SHORT).show();
                    removeBadge(mybottomNavView, item.getItemId());
                    viewPager1.setCurrentItem(3);
                }
                return true;
            }
        });

        // Escucha de cambios en el ViewPager para sincronizar con la barra de navegación
        viewPager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // No se necesita manejar este evento
            }

            @Override
            public void onPageSelected(int position) {
//                if (prevMenuItem != null) {
//                    prevMenuItem.setChecked(false);
//                } else {
//                    mybottomNavView.getMenu().getItem(0).setChecked(false);
//                }
                mybottomNavView.getMenu().getItem(position).setChecked(true);
                removeBadge(mybottomNavView, mybottomNavView.getMenu().getItem(position).getItemId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // No se necesita manejar este evento
            }
        });
    }

    /**
     * Remove badge.
     *
     * @param bottomNavigationView the bottom navigation view
     * @param itemId               the item id
     */
    public static void removeBadge(BottomNavigationView bottomNavigationView, @IdRes int itemId) {
        BottomNavigationItemView itemView = bottomNavigationView.findViewById(itemId);

        if (itemView.getChildCount() == 3) {
            itemView.removeViewAt(2);
        }
    }
}
