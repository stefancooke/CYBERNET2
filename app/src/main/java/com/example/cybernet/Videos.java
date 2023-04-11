package com.example.cybernet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


public class Videos extends AppCompatActivity {

    private WebView mWebView;
    private String mVideoId = "XBkzBrXlle0"; // Replace with your video ID


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        mWebView = findViewById(R.id.youtube_player_view);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setAllowFileAccessFromFileURLs(true);

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mWebView.loadUrl("javascript:(function() {" +
                            "var player;" +
                            "function onYouTubeIframeAPIReady() {" +
                            "player = new YT.Player('player', {" +
                            "videoId: '" + mVideoId + "'," +
                            "playerVars: { 'autoplay': 1, 'controls': 1, 'showinfo': 0 }," +
                            "events: {" +
                            "'onReady': onPlayerReady," +
                            "'onStateChange': onPlayerStateChange" +
                            "}" +
                            "});" +
                            "}" +
                            "function onPlayerReady(event) {" +
                            "player.playVideo();" +
                            "}" +
                            "function onPlayerStateChange(event) {" +
                            "if (event.data === YT.PlayerState.ENDED) {" +
                            "window.android.onPlayerFinished();" +
                            "}" +
                            "}" +
                            "window.onYouTubeIframeAPIReady = onYouTubeIframeAPIReady;" +
                            "})()");
                }
            }
        });
        mWebView.loadUrl("file:///assets/youtube_iframe_api.js");
    }

    public void onPlayerFinished() {
        // Handle player finished event here
    }
}
