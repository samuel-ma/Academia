package com.samuelmajok.academia.main_pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.material.navigation.NavigationView;
import com.samuelmajok.academia.R;
import com.samuelmajok.academia.adapter.homeAdapter.FeaturedAdapter;
import com.samuelmajok.academia.adapter.homeAdapter.featuredHelperClass;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    RecyclerView featuredRecycler;
    RecyclerView.Adapter adapter;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        featuredRecycler = findViewById(R.id.featured_recycler);

        featuredRecycler();

        drawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.navigation_view);

    }private void featuredRecycler(){


        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<featuredHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add(new featuredHelperClass(R.drawable.book_7,"Beauty and the Beast", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_8,"Maid in Manhattan", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_1,"Elder Scrolls of Narnia", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_2,"The Calm and Collected", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_3,"The Revelation", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_4,"Thief Among Us", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_6,"Truth Be Told", "Our editors and contributors have curated the best books of the year"));
        featuredLocations.add(new featuredHelperClass(R.drawable.book_5,"I Woke Up This Morning", "Our editors and contributors have curated the best books of the year"));

        adapter = new FeaturedAdapter(featuredLocations);

        featuredRecycler.setAdapter(adapter);

    }
}


