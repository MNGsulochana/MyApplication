package com.example.sulochana.myapplication.sample;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sulochana.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SampleFragment1 extends Fragment {


    public SampleFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sample_fragment1, container, false);
    }

}
