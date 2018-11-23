package com.example.sulochana.myapplication.keyboard;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class InputKeyboard extends RelativeLayout {

    Context c;

    public InputKeyboard(Context context) {
        super(context);
        c=context;
        init();
    }

    private void init() {

        TextView tv=new TextView(c);
        for(int i=0;i<10;i++)
        {
            tv.setText(i + "   ");
        }
    }

    public InputKeyboard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InputKeyboard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputKeyboard(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
