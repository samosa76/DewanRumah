package com.samosauus.dewarumah.AfterLogin.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.samosauus.dewarumah.AfterLogin.Fragment.FBonus;
import com.samosauus.dewarumah.AfterLogin.Fragment.FPoint;
import com.samosauus.dewarumah.R;

import java.util.ArrayList;
import java.util.List;

public class ALBonus extends AppCompatActivity {

    TabLayout tabs;
    ViewPager vpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albonus);

        tabs = (TabLayout) findViewById(R.id.tabBonus);
        vpager = (ViewPager) findViewById(R.id.vpBonus);


        setUpViewPager(vpager);
        tabs.setupWithViewPager(vpager);

    }

    private void setUpViewPager(ViewPager vpager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FPoint(),"Poin");
        adapter.addFragment(new FBonus(),"Bonus");
        vpager.setAdapter(adapter);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> nameList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);

        }
        public Fragment getItem(int position){
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            nameList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return nameList.get(position);
        }
    }
}
