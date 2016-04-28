package com.example.Crimminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by Elkin on 25.04.2016.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
