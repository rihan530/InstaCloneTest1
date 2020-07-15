package com.coolwhite.instaclonetest.Utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.coolwhite.instaclonetest.Likes.LikesActivity;
import com.coolwhite.instaclonetest.Home.HomeActivity;
import com.coolwhite.instaclonetest.Profile.ProfileActivity;
import com.coolwhite.instaclonetest.R;
import com.coolwhite.instaclonetest.Search.SearchActivity;
import com.coolwhite.instaclonetest.Share.ShareActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_house:
                        Intent houseIntent = new Intent(context, HomeActivity.class); //ACTIVITY_NUM = 0;
                        context.startActivity(houseIntent);
                        break;

                    case R.id.ic_search:
                        Intent searchIntent = new Intent(context, SearchActivity.class);//ACTIVITY_NUM = 1;
                        context.startActivity(searchIntent);
                        break;

                    case R.id.ic_add:
                        Intent shareIntent = new Intent(context, ShareActivity.class);//ACTIVITY_NUM = 2;
                        context.startActivity(shareIntent);
                        break;

                    case R.id.ic_like:
                        Intent likeIntent = new Intent(context, LikesActivity.class);//ACTIVITY_NUM = 3;
                        context.startActivity(likeIntent);
                        break;

                    case R.id.ic_profile:
                        Intent profileIntent = new Intent(context, ProfileActivity.class);//ACTIVITY_NUM = 4;
                        context.startActivity(profileIntent);
                        break;
                }

                return false;
            }
        });
    }
}
