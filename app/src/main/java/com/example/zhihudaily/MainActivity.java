package com.example.zhihudaily;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.zhihudaily.gson.ItenBean;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItenBean> news = new ArrayList<>();
    ItenBean.StoriesBean story;
    ArrayList<ItenBean.StoriesBean>stories=new ArrayList<>();
    private Banner banner;
    ItenBean data=new ItenBean();

    RecyclerView recyclerView;
    ArticleAdapter adapter;
    String date=getDate1();

    private int otherdate = 0;
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getDayDate());
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setSubtitle(getMonDate()+"月");
        sendRequestWithOkHttp();
//        initView();
        refresh();

    }

    private String getDayDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, -otherdate);
        String date = new SimpleDateFormat("dd").format(c.getTime());
        return date;
    }

    private String getMonDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, -otherdate);
        String date = new SimpleDateFormat("MM").format(c.getTime());
        return date;
    }

    private String getDate1() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_MONTH, -otherdate);
        String date = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
        return date;
    }


    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        refreshLayout = findViewById(R.id.refresh);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ArticleAdapter(this,news);
        adapter.initData(data);
        recyclerView.setAdapter(adapter);
        load();
        refreshLayout.setRefreshing(false);
        adapter.addData(data);
        adapter.notifyDataSetChanged();
        //loadMore();
    }

    //网络请求
    private void sendRequestWithOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                        OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://news-at.zhihu.com/api/3/news/latest")
                            .build();
                    final Call call = Client.getInstance().newCall(request);
//                        Response response = client.newCall(request).execute();
                    Response response = call.execute();
                    String responseData = response.body().string();
                    Message message = Message.obtain();
                    message.what = 1;
                    message.obj = responseData;
                    handler.sendMessage(message);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                Gson gson = new Gson();
                data = gson.fromJson(msg.obj.toString(), ItenBean.class);
                news.add(data);
                //date=data.getDate();
                initView();
            }
            else if(msg.what==0){
                Gson gson = new Gson();
                 story= gson.fromJson(msg.obj.toString(), ItenBean.StoriesBean.class);
                for(int i=0;i<data.getStories().size();i++){
                    stories.add(story);
                }
                //date=data.getDate();
            }
        }
    };

    private void onLoadMore() {
        initView();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
//                        OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("https://news-at.zhihu.com/api/3/news/before/"+getDate1())
                            .build();
                    final Call call = Client.getInstance().newCall(request);
//                        Response response = client.newCall(request).execute();
                    Response response = call.execute();
                    String responseData = response.body().string();
                    Message message = Message.obtain();
                    message.what = 0;
                    message.obj = responseData;
                    handler.sendMessage(message);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    //下拉刷新
    public void refresh() {
        refreshLayout = findViewById(R.id.refresh);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                sendRequestWithOkHttp();
            }
        });
        refreshLayout.setRefreshing(false);
    }

    //上拉加载
    public void load() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int totalItemCount;
            private int firstVisibleItem;
            private int visibleItemCount;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                totalItemCount = linearLayoutManager.getItemCount();
                firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                visibleItemCount = recyclerView.getChildCount();
                if (((totalItemCount - visibleItemCount) <= firstVisibleItem)) {
                    otherdate++;
                    onLoadMore();
                }
            }


        });
    }
}

