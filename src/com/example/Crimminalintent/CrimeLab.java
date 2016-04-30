package com.example.Crimminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Elkin on 24.04.2016.
 */
public class CrimeLab {
    private ArrayList<Crime> mCrimes;
    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
//        for (int i = 0; i < 100; i++) {
//            Crime c = new Crime();
//            c.setmTitle("Crime #" + i);
//            c.setmSolved(i % 2 == 0);
//            mCrimes.add(c);
//        }
    }

    public ArrayList<Crime> getmCrimes() {
        return mCrimes;
    }

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context.getApplicationContext());
        }
        return sCrimeLab;
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes) {
            if (c.getmId().equals(id)) {
                return c;
            }
        }

        return null;
    }

    public void addCrime(Crime crime) {
        mCrimes.add(crime);
    }
}
