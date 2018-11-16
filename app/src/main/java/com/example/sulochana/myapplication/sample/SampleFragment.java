package com.example.sulochana.myapplication.sample;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v17.leanback.app.BaseFragment;
import android.support.v17.leanback.app.RowsFragment;

import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.HeaderItem;
import android.support.v17.leanback.widget.ListRow;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sulochana.myapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment extends RowsFragment {
    private ArrayObjectAdapter mRowsAdapter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpRowAdapter();
    }

    private void setUpRowAdapter() {
        mRowsAdapter=new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(mRowsAdapter);
        HeaderItem gridHeader = new HeaderItem(0,"sample");
        GridItemPresenter gridPresenter = new GridItemPresenter(getActivity());
        ArrayObjectAdapter gridRowAdapter = new ArrayObjectAdapter(gridPresenter);
        gridRowAdapter.add("samd");
        gridRowAdapter.add("samd1");
        gridRowAdapter.add("samd2");
        gridRowAdapter.add("samd3");
        ListRow row = new ListRow(gridHeader, gridRowAdapter);
        mRowsAdapter.add(row);


        HeaderItem gridHeader1 = new HeaderItem(1,"sample1");
        GridItemPresenter gridPresenter1 = new GridItemPresenter(getActivity());
        ArrayObjectAdapter gridRowAdapter1 = new ArrayObjectAdapter(gridPresenter);
        gridRowAdapter1.add("samd2");
        gridRowAdapter1.add("samd13");
        gridRowAdapter1.add("samd24");
        gridRowAdapter1.add("samd35");
        ListRow row1 = new ListRow(gridHeader1, gridRowAdapter1);
        mRowsAdapter.add(row1);

        }


}
