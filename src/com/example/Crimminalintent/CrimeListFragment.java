package com.example.Crimminalintent;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by Elkin on 24.04.2016.
 */
public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> mCrimes;
    private static final int REQUEST_CRIME = 1;
//    private static final String TAG = "CrimeListFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getmCrimes();

//        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(), android.R.layout.simple_list_item_1, mCrimes);
        CrimeAdapter adapter = new CrimeAdapter(mCrimes);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
//        Crime c = (Crime) (getListAdapter()).getItem(position);
        Crime c = ((CrimeAdapter)getListAdapter()).getItem(position);
//        Intent i = new Intent(getActivity(), CrimeActivity.class);
        Intent i = new Intent(getActivity(), CrimePagerActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, c.getmId());
//        startActivity(i);
        startActivityForResult(i, REQUEST_CRIME);

//        Toast.makeText(getContext(), c.getmTitle(), Toast.LENGTH_SHORT).show();
//        Log.d(TAG, c.getmTitle() + " was clicked");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CRIME) {

        }

    }

    private class CrimeAdapter extends ArrayAdapter<Crime> {
        public CrimeAdapter(ArrayList<Crime> crimes) {
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_crime, null);
            }
            Crime c = getItem(position);
            TextView titleTextView = (TextView) convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getmTitle());
            TextView dateTextView = (TextView) convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextView.setText(c.getmDate().toString());
            CheckBox solvedCheckBox = (CheckBox) convertView.findViewById(R.id.crime_list_item_solvedCheckBox);
            solvedCheckBox.setChecked(c.ismSolved());

            return convertView;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        ((CrimeAdapter)getListAdapter()).notifyDataSetChanged();
    }
}

