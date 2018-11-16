package com.example.sulochana.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sulochana.myapplication.sample.Model;
import com.example.sulochana.myapplication.sample.SampleFragment;
import com.example.sulochana.myapplication.sample.SampleFragment1;

public class Main2Activity extends AppCompatActivity{

    Model m=new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        m.setName("suchi");
        m.setAddress("chirala");

        Fragment fragment1 = new SampleFragment1();
        getFragmentManager().beginTransaction().replace(R.id.container1, fragment1)
                .commit();
        Fragment fragment = new SampleFragment();
        getFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .commit();
    }
}
