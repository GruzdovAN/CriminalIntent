package com.example.Crimminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.UUID;

public class CrimePagerActivity extends FragmentActivity {
    private ViewPager mViewPager;
//    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewPager = new ViewPager(this);
        mViewPager.setId(R.id.viewPager);
        setContentView(mViewPager);

//        mCrimes = CrimeLab.get(this).getmCrimes();
        final ArrayList<Crime> crimes = CrimeLab.get(this).getmCrimes();
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int pos) {
                UUID crimeID = crimes.get(pos).getmId();
                return CrimeFragment.newInstance(crimeID);
            }

            @Override
            public int getCount() {
                return crimes.size();
            }
        });

        mViewPager.addOnPageChangeListener (new ViewPager.OnPageChangeListener(){
            public void  onPageScrollStateChanged(int state){}
            public void  onPageScrolled(int pos, float pasOffset, int posOffset) {}

            public void onPageSelected(int pos) {
                Crime crime = crimes.get(pos);
                if (crime.getmTitle() != null) {
                    setTitle(crime.getmTitle());
                }
            }
        });

        UUID crimeID = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for (int i = 0; i < crimes.size(); i++) {
            if (crimes.get(i).getmId().equals(crimeID)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
