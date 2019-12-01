package com.example.zhihudaily;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.zhihudaily.gson.ItenBean;

import java.util.ArrayList;

public class ViewPagerAdapter extends PagerAdapter {
    private ArrayList<ItenBean.TopStoriesBean> topStories = new ArrayList<>();
    private Context mcontext;

    ViewPagerAdapter(Context context,ArrayList<ItenBean.TopStoriesBean> list){
        topStories.addAll(list);
        this.mcontext=context;
    }
    @Override
    public int getCount() {
        return topStories.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position){
        final String[]id = {String.valueOf(topStories.get(position).getId())};
        View view= LayoutInflater.from(mcontext).inflate(R.layout.banneritem_layout,container,false);
        TextView topTitles=view.findViewById(R.id.topTitle);
        ImageView topImage=view.findViewById(R.id.topImage);
        topTitles.setText(topStories.get(position).getTitle());
        Glide.with(mcontext)
                .load(topStories.get(position).getImage())
                .into(topImage);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext,StoryContent.class);
                Bundle bundle=new Bundle();
                bundle.putString("id",id[0]);
                intent.putExtras(bundle);
                mcontext.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup view,int position,Object object){
        view.removeView((View) object);
    }
}
