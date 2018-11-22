package com.example.sulochana.myapplication.sample;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sulochana.myapplication.R;

public class ActivityBasicSample extends Activity {
    LinearLayout l1,l2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customanim);
        l1=findViewById(R.id.firstlayout);
        l1.setVisibility(View.GONE);

        tv=findViewById(R.id.text1);

        Fragment fragment1 = new SampleFragment1();
        getFragmentManager().beginTransaction().replace(R.id.container1, fragment1)
                .commit();
        Fragment fragment = new SampleFragment();
        getFragmentManager().beginTransaction().replace(R.id.container, fragment)
                .commit();

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode ==KeyEvent.KEYCODE_DPAD_LEFT)
        {
            Log.d("focus","geifdff");
            l1.setVisibility(View.VISIBLE);
            TextView tv=findViewById(R.id.text1);
            tv.requestFocus();
            slideToLeft(l1);

        }
        if(keyCode ==KeyEvent.KEYCODE_MENU)
        {
            Log.d("focus","geifdffright");
            l1.setVisibility(View.VISIBLE);
            l1.requestFocus();
            l1.setFocusableInTouchMode(true);

            tv.requestFocus();
            tv.setFocusableInTouchMode(true);
            slideToRight(l1);
        }
        if(keyCode== KeyEvent.KEYCODE_DPAD_UP)
        {
            Log.d("focus","geifdffUP");
           tv.setNextFocusDownId(R.id.text22);
           TextView tv2=findViewById(R.id.text22);
           tv2.requestFocus();
           tv2.setFocusableInTouchMode(true);
        }
        return super.onKeyDown(keyCode, event);
    }

    // To animate view slide out from left to right
    public void slideToRight(View view){
        view.setVisibility(View.VISIBLE);
        Log.d("widthofview",""+view.getWidth());
        //  TranslateAnimation animate = new TranslateAnimation(0,view.getWidth(),0,2);
        TranslateAnimation animate = new TranslateAnimation(0,0,0,0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
      //  view.setVisibility(View.GONE);
    }
    // To animate view slide out from right to left
    public void slideToLeft(View view){
        view.setVisibility(View.VISIBLE);
        Log.d("widthofview",""+(-view.getWidth()));
        //  TranslateAnimation animate = new TranslateAnimation(0,-view.getWidth(),0,0);
        TranslateAnimation animate = new TranslateAnimation(0,-280,0,0);
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.startAnimation(animate);
        //view.setVisibility(View.GONE);
    }
}



// l2=findViewById(R.id.layout);

      /*  //  TagLayout tagLayout = (TagLayout) findViewById(R.id.customlayout);
        LayoutInflater layoutInflater = getLayoutInflater();
      String tag;
        for (int i = 0; i <= 20; i++) {
            tag = "#tag" + i;
            View tagView = layoutInflater.inflate(R.layout.tag_layout, null, false);

            TextView tagTextView = (TextView) tagView.findViewById(R.id.tagTextView);
            tagTextView.setText(tag);
            tagLayout.addView(tagView);
        }*/
