package com.coolwhite.instaclonetest.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.coolwhite.instaclonetest.R;
import com.coolwhite.instaclonetest.Utils.BottomNavigationViewHelper;
import com.coolwhite.instaclonetest.Utils.SectionPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final int ACTIVITY_NUM = 0;

    private Context mContext = HomeActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.d(TAG, "onCreate: starting.");

        setupBottomNavigationView();
        setupViewPager();
    }

    //Responsible for adding  the 3 tabs : Camera, Home, Messages
    private void setupViewPager() {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new CameraFragment());
        adapter.addFragment(new HomeFragment());
        adapter.addFragment(new MessagesFragment());
        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_camera);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_send);
    }

    //BottomNavigationView setup
    private void setupBottomNavigationView() {
    Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNaviViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        // Helper를 사용하면 밑처럼 하지 않고 바로 호출가능
//        bottomNavigationViewEx.enableAnimation(false);
//        bottomNavigationViewEx.enableItemShiftingMode(false);
//        bottomNavigationViewEx.enableShiftingMode(false);
//        bottomNavigationViewEx.setTextVisibility(false);

        BottomNavigationViewHelper.enableNavigation(mContext, bottomNavigationViewEx);
        // Activity마다 별도의 Intent를 새로 선언하면 코드가 너무 길어지므로 Helper에서 정의한 것을 불러옴
//        Intent houseIntent = new Intent(MainActivity.this, MainActivity.class);
//        startActivity(houseIntent);

        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}