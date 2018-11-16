package com.example.sulochana.myapplication.sample;

import android.app.Activity;


import android.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.example.sulochana.myapplication.R;

public class SampleActivity extends Activity {


    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_sample);
       // setContentView(R.layout.activity_main2);
        //setContentView(R.layout.activity_sample);
       // setContentView(R.layout.sample_activity);
      //  drawerLayout=findViewById(R.id.drawer);

        Fragment fragment1 = new SampleFragment1();
        getFragmentManager().beginTransaction().replace(R.id.container1, fragment1)
                .commit();
        Fragment fragment = new SampleFragment();
        getFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .commit();
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_MENU)
        {

          //  drawerLayout.openDrawer(Gravity.START);
            return true;
        }
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
          // drawerLayout.closeDrawer(Gravity.START,true);
           return true;
        }
        return true;
    }
}
