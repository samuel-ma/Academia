package com.samuelmajok.academia.main_pages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;
import com.samuelmajok.academia.R;
import com.samuelmajok.academia.adapter.homeAdapter.FeaturedAdapter;
import com.samuelmajok.academia.adapter.homeAdapter.featuredHelperClass;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    static final float END_SCALE = 0.7f;
    ImageView hamburgerMenu;
    LinearLayout contentView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);

        contentView = findViewById(R.id.content);

        featuredRecycler();

        drawerLayout = findViewById(R.id.drawer_layout);

        hamburgerMenu = findViewById(R.id.hamburger_menu);

        navigationView = findViewById(R.id.navigation_view);

        navigationDrawer();
    }

    //NavigationView
    private void navigationDrawer() {

        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);

        hamburgerMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.limeWhite));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                final float diffScaledoffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledoffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledoffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }


        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.nav_subjects:
                Intent intent = new Intent(getApplicationContext(), AllSubjects.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    //RecyclerViews
    private void featuredRecycler() {


        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<featuredHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new featuredHelperClass(R.drawable.book_7, "Beauty and the Beast", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_8, "Maid in Manhattan", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_1, "Elder Scrolls of Narnia", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_2, "The Calm and Collected", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_3, "The Revelation", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_4, "Thief Among Us", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_6, "Truth Be Told", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_5, "I Woke Up This Morning", "Our editors and contributors have curated the best books of the year"));

        adapter = new FeaturedAdapter(featuredLocations);

        featuredRecycler.setAdapter(adapter);

    }

}


