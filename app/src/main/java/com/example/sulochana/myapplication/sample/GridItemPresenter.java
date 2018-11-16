package com.example.sulochana.myapplication.sample;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.sulochana.myapplication.R;

public class GridItemPresenter extends Presenter {

    TextView tv;
    ViewGroup.LayoutParams  layoutParams;
    Context context;
    Drawable mDefaultCardImage;

    public GridItemPresenter(Context context)
    {
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        Log.d("sample","ddfdn");

        /*ImageCardView cardView = new ImageCardView(viewGroup.getContext(),) {
            @Override
            public void setSelected(boolean selected) {

                super.setSelected(selected);
            }
        };
        cardView.setMinimumWidth(250);
        mDefaultCardImage = viewGroup.getResources().getDrawable(R.drawable.movie, null);

        cardView.setFocusable(true);
        cardView.setFocusableInTouchMode(true);

        cardView.setBackgroundColor(ContextCompat.getColor(context,  R.color.focused_end_multi));

        return new ViewHolder(cardView);*/

        TextView view = new TextView(viewGroup.getContext());

        Resources res = viewGroup.getResources();
        int width = 200;
        int height = 100;

        view.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        // view.setBackgroundColor(ContextCompat.getColor(parent.getContext(), R.color.selected_background));
        view.setBackgroundColor(ContextCompat.getColor(viewGroup.getContext(), R.color.focused_end_multi));
        view.setTextColor(Color.WHITE);
        view.setGravity(Gravity.CENTER);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {

     /*   ImageCardView cardView = (ImageCardView) viewHolder.view;

        cardView.setTitleText("gvdhg");
        cardView.setContentText("bncx");
        Resources res = cardView.getResources();
        int width = 300;
        int height = 150;
        cardView.setMainImageDimensions(width, height);

        Glide.with(cardView.getContext())
                .load("https://www.gstatic.com/webp/gallery/1.jpg")
                .apply(RequestOptions.errorOf(mDefaultCardImage))
                .into(cardView.getMainImageView());*/
        ((TextView)viewHolder.view).setText(item.toString());
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {

    }
}
