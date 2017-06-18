package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.net.Uri;

import java.util.List;

/**
 * Created by Lariveg on 14/06/2017.
 */

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /** Tag for log messages */
    private final String LOG_TAG = NewsLoader.class.getName();

    /** Query URL */
    private String mUrl;
    private String mSearchQuery;

    public NewsLoader(Context context, String url, String searchQuery) {
        super(context);
        mUrl = url;
        mSearchQuery = searchQuery;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        if(mSearchQuery != null) {

            String mAPIKey = "test";
            Uri baseUri = Uri.parse(mUrl + mSearchQuery);
            Uri.Builder uriBuilder = baseUri.buildUpon();
            uriBuilder.appendQueryParameter("api-key", mAPIKey);

            // Perform the network request, parse the response, and extract a list of news.
            List<News> news = Utils.fetchNewsData(uriBuilder.toString());
            return news;
        } else {
            return null;
        }
    }
}
