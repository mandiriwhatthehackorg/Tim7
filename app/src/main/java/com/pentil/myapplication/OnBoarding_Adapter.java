package com.pentil.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OnBoarding_Adapter extends PagerAdapter {
    private Context mContext;
    ArrayList<Onboarding> onBoardItems=new ArrayList<>();
    public OnBoarding_Adapter(Context mContext, ArrayList<Onboarding> items) {
        this.mContext = mContext;
        this.onBoardItems = items;
    }
    @Override
    public int getCount() {
        return onBoardItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.onboard,container,false);
        Onboarding item = onBoardItems.get(position);
        ImageView imageView = (ImageView)itemView.findViewById(R.id.MainBardingActivity);
        imageView.setImageResource(item.idImage);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
