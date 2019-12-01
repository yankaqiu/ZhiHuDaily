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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.zhihudaily.gson.ItenBean;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter {
    //定义两种变量
    public static final int BANNER = 0;
    public static final int ARTICLE = 1;
    //三个集合
    private ArrayList<ItenBean> mdata;
    private ItenBean datas;
    private ArrayList<ItenBean.StoriesBean> stories ;
    private ArrayList<ItenBean.TopStoriesBean> topStories;
    //ArticleViewHolder holder=null;
    private String[] mData;
    private LayoutInflater layoutInflater;
    private Context mcontext;
    private View banner;
    int size = 1;

    public ArticleAdapter(Context mcontext) {
       stories=new ArrayList<>();
       topStories= new ArrayList<>();
       this.mcontext=mcontext;
    }

    public void initData(ItenBean datas) {
        this.datas = datas;
        stories.clear();
        topStories.clear();
        this.stories = (ArrayList<ItenBean.StoriesBean>) datas.getStories();
        this.topStories = (ArrayList<ItenBean.TopStoriesBean>) datas.getTop_stories();
        size = stories.size() + 1;
    }

    public void addData(ItenBean data) {
        this.stories.addAll(datas.getStories());
        mdata.add(data);
        size = stories.size() + 1;
        notifyItemChanged(size, size + stories.size());
    }

    @Override
    public int getItemViewType(int position) {

        return position == 0 ? BANNER : ARTICLE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            View view = LayoutInflater.from(mcontext).inflate(R.layout.banneritem_layout, parent, false);
            BannerHolder holder = new BannerHolder(view);
            return holder;
        } else {
            View view = LayoutInflater.from(mcontext).inflate(R.layout.item_layout, parent, false);
            ArticleViewHolder holder = new ArticleViewHolder(view);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final int realPosition = position - 1;
        if (holder instanceof BannerHolder) {
            BannerHolder bannerholder = (BannerHolder) holder;
            ViewPagerAdapter bannerAdapter = new ViewPagerAdapter(mcontext, topStories);
            bannerholder.viewPager.setAdapter(bannerAdapter);
        }
        //return;
        // final int pos = getRealPosition(holder);
        if (holder instanceof ArticleViewHolder) {
            ArticleViewHolder storyHolder = (ArticleViewHolder) holder;
            final ItenBean.StoriesBean story = stories.get(realPosition);
            storyHolder.articleName.setText(story.getTitle());
            storyHolder.hint.setText(story.getHint());
            Glide.with(mcontext)
                    .load(story.getImages().get(0))
                    .into(storyHolder.articleImage);
            holder.itemView.setTag(story);
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent intent = new Intent(mcontext,StoryContent.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("id",String.valueOf(story.id));
                    intent.putExtras(bundle);
                    mcontext.startActivity(intent);
                }
            });
        }
    }


    public void setBanner(View banner) {
        this.banner = banner;
        notifyItemInserted(0);
    }

    public View getBanner() {
        return banner;
    }

    private int getRealPosition(RecyclerView.ViewHolder holder) {
        int position = holder.getLayoutPosition();
        return banner == null ? position : position - 1;
    }

    @Override
    public int getItemCount() {
        return stories.size() + 1;
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        ImageView articleImage;
        TextView articleName;
        TextView hint;

        public ArticleViewHolder(View itemView) {
            super(itemView);
            articleImage = (ImageView) itemView.findViewById(R.id.article_image);
            articleName = (TextView) itemView.findViewById(R.id.article_name);
            hint = itemView.findViewById(R.id.hint);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mcontext,StoryContent.class);
                    Bundle bundle=new Bundle();
                   // bundle.putString("id",id[0]);
                    intent.putExtras(bundle);
                    mcontext.startActivity(intent);
                }
            });
        }
    }

    public class BannerHolder extends RecyclerView.ViewHolder {
        public ViewPager viewPager;

        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            viewPager = itemView.findViewById(R.id.topStory);
        }
    }

}






