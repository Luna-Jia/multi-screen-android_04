package com.example.a13pager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

//ver 01 simple, static
//ver 02 multiple layout xmls
//ver 03 simple layout, callback
//ver 04 tabs

public class MainActivity extends AppCompatActivity {
    // https://www.androidhive.info/2020/01/viewpager2-pager-transformations-intro-slider-pager-animations-pager-transformations/
    // https://stackoverflow.com/questions/55372259/how-to-use-tablayout-with-viewpager2-in-android

    private String[] pages = {"First Screen", "Second Screen", "Third Screen"};
    private ViewPager2 viewPager2;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // tab sync (2b)
        ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tablayout.selectTab(tablayout.getTabAt(position));
            }
        };

        viewPager2 = findViewById(R.id.viewpager);
        viewPager2.setAdapter(new MyViewPager2Adapter(pages));
        viewPager2.registerOnPageChangeCallback(pageChangeCallback);

        // removing toolbar elevation
        getSupportActionBar().setElevation(0);
        // attaching tab mediator
        tablayout = findViewById(R.id.tablayout);
        tablayout.addTab(tablayout.newTab().setText("First"));
        tablayout.addTab(tablayout.newTab().setText("Second"));
        tablayout.addTab(tablayout.newTab().setText("Third"));

        // tab sync (1)
        //new TabLayoutMediator(tablayout, viewPager2, (tab, position) -> tab.setText(pages[position])).attach();
          /*new TabLayoutMediator(tablayout, viewPager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(pages[position]);
                    }
                }).attach();*/

        // tab sync (2a)
        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }
}