package com.example.zhihudaily;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class StoryContent extends AppCompatActivity {
    private String id;
    private WebView webview;
   // @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_content);
        webview=findViewById(R.id.storyContent);
        Intent intent =getIntent();
        Bundle bundle =intent.getExtras();
        if(bundle!=null){
            id=bundle.getString("id");
        }
        webview.loadUrl("http://daily.zhihu.com/story/"+id);
    }

}
