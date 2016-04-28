package com.example.Crimminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Elkin on 23.04.2016.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private Date mDate;
    private boolean mSolved;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {

        this.mTitle = mTitle;
    }

    public UUID getmId() {

        return mId;
    }

    public Crime() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Date getmDate() {

        return mDate;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public boolean ismSolved() {
        return mSolved;
    }
}
