package com.example.Crimminalintent;

import android.support.v4.app.Fragment;

import java.util.UUID;

//import android.support.v4.app.Fragment;

public class CrimeActivity extends SingleFragmentActivity {
    /** Called when the activity is first created. */
    @Override
    protected Fragment createFragment() {
//        return new CrimeFragment();
        UUID crimeID = (UUID) getIntent()
                .getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeID);
    }
}
