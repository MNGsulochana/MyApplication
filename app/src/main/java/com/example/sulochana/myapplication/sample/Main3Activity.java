package com.example.sulochana.myapplication.sample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.example.sulochana.myapplication.R;

public class Main3Activity extends AppCompatActivity {

    PinEntryEditText1 edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main3);
        setContentView(R.layout.pinentry);
        edit=findViewById(R.id.txt_pin_entry2);
        edit.setFocusable(true);
        edit.setFocusableInTouchMode(true);
        edit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus)
                {
                    Log.d("getselectd","dhf");
                    InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(v, 0);
                }
            }
        });


    }
}
