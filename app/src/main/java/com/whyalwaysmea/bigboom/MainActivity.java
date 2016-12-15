package com.whyalwaysmea.bigboom;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.whyalwaysmea.bigboom.base.BaseActivity;
import com.whyalwaysmea.bigboom.view.menu.ui.AboutActivity;
import com.whyalwaysmea.bigboom.view.menu.ui.DownloadManagerActivity;
import com.whyalwaysmea.bigboom.view.menu.ui.GithubActivity;
import com.whyalwaysmea.bigboom.view.menu.ui.HistoryActivity;
import com.whyalwaysmea.bigboom.view.movielist.ui.MovieFragment;
import com.whyalwaysmea.bigboom.utils.SPUtils;
import com.whyalwaysmea.bigboom.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.fl_content)
    FrameLayout mFlContent;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    private MovieFragment mFragment;
    private SPUtils mSpUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        mSpUtils = new SPUtils(this, Constants.SP.SHARED_PREFERENCES_NAME);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            if(mSpUtils.getBoolean(Constants.SP.THEME)) {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                StatusBarUtil.setColorForDrawerLayout(this, mDrawerLayout, getResources().getColor(R.color.primary_night), 0);
            } else {
                StatusBarUtil.setColorForDrawerLayout(this, mDrawerLayout, getResources().getColor(R.color.colorPrimary), 0);
            }
        }

        mFragment = MovieFragment.newInstance();
        addFragmentToStack(R.id.fl_content, mFragment);

        MenuItem menuItem = mNavigationView.getMenu().findItem(R.id.nav_theme);
        SwitchCompat mThemeSwitch = (SwitchCompat) MenuItemCompat.getActionView(menuItem).findViewById(R.id.view_switch);
        if(mSpUtils.getBoolean(Constants.SP.THEME)) {
            mThemeSwitch.setChecked(true);
        }
        mThemeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            mSpUtils.putBoolean(Constants.SP.THEME, isChecked);
            mThemeSwitch.setChecked(isChecked);
            if (isChecked) {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
        });

        LinearLayout headerLayout = (LinearLayout) mNavigationView.getHeaderView(0).findViewById(R.id.header_layout);
        headerLayout.setOnClickListener(v -> {
            Intent intent = new Intent(mContext, GithubActivity.class);
            startActivity(intent);
        });

    }

    public void setToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            mDrawerLayout.setDrawerListener(toggle);
            toggle.syncState();
            mNavigationView.setNavigationItemSelectedListener(this);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        mFragment.onCreateOptionsMenu(menu, getMenuInflater());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        mFragment.onOptionsItemSelected(item);

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {

        } else if (id == R.id.browsing_history) {
            Intent intent = new Intent(mContext, HistoryActivity.class);
            startActivity(intent);
        } else if(id == R.id.download_manager) {
            Intent intent = new Intent(mContext, DownloadManagerActivity.class);
            startActivity(intent);
        } else if(id == R.id.about) {
            Intent intent = new Intent(mContext, AboutActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
}
