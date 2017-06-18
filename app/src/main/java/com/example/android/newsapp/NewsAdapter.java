package com.example.android.newsapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lariveg on 14/06/2017.
 */

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    static class ViewHolder {
        private TextView titleTextView;
        private TextView sectionTextView;
        private TextView authorTextView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        ViewHolder holder;

        // Check if the existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
            // cache view fields into the holder
            holder = new ViewHolder();
            holder.titleTextView = (TextView) listItemView.findViewById(R.id.news_title);
            holder.sectionTextView = (TextView) listItemView.findViewById(R.id.news_section);
            listItemView.setTag(holder);
        }
        // view already exists, get the holder instance from the view
        else {
            holder = (ViewHolder) listItemView.getTag();
        }

        // Get the {@link News} object located at this position in the list
        News currentNews = getItem(position);

        //Display the news title of the current news in that TextView
        holder.titleTextView.setText(currentNews.getTitle());

        //Display the news section of the current news in that TextView
        holder.sectionTextView.setText(currentNews.getSection());

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
