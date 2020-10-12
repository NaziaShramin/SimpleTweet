package com.codepath.apps.restclienttemplate;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

public class TweetAdapter extends  RecyclerView.Adapter<TweetAdapter.ViewHoder>{

    Context context;
    List<Tweet>tweets;

    public TweetAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        // Get the data at position
        Tweet tweet = tweets.get(position);
        holder.bind(tweet);
        // Bind the tweet with view

    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }
    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }
    //Add alist of items
    public void addAll(List<Tweet> tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();

    }

    // pass in the context and list of tweets
    // for each row, inflate the layout
    // Bind values based on the position of the element
    // Define a viewholder
    public class ViewHoder extends RecyclerView.ViewHolder{
        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;


        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
        }

        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText(tweet.user.screenName);
            Glide.with(context).load(tweet.user.profileImageUrl).into(ivProfileImage);
        }
    }
}
