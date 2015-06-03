package com.dreamer.practice.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dreamer.practice.R;
import com.dreamer.practice.activity.MovieDetailActivity;
import com.dreamer.practice.bean.USBoxMovie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreamer on 2015/5/30.
 */
public class USBoxMovieListAdapter extends RecyclerView.Adapter<USBoxMovieListAdapter.MovieHolder> {
    private static final String TAG = "MovieListAdapter";
    private List<USBoxMovie> USBoxMovieList;
    private Context context;

    public USBoxMovieListAdapter(Context context){
        this.context = context;
        USBoxMovieList = new ArrayList<USBoxMovie>();
    }

    public void addUSBoxMovies(List<USBoxMovie> USBoxMovies) {
        this.USBoxMovieList.addAll(USBoxMovies);
        this.notifyItemRangeInserted(0, USBoxMovies.size() - 1);
    }

    public void clearUSBoxMovies() {
        int size = this.USBoxMovieList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                USBoxMovieList.remove(0);
            }
            this.notifyItemRangeRemoved(0, size);
        }
    }
    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.usbox_movie_item, viewGroup, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, int position) {
        final USBoxMovie USBoxMovie = USBoxMovieList.get(position);
        Picasso.with(context).load(USBoxMovie.getSimpleMovie().getImages().getSmall()).into(holder.poster);
        holder.title.setText(USBoxMovie.getSimpleMovie().getTitle());
        holder.rank_box.setText("票房排名：" + USBoxMovie.getRank()+"  票房：" + USBoxMovie.getBox()/10000 + "万美元");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,context.getResources().getString(R.string.click)+(i+1),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MovieDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("movieID", USBoxMovie.getSimpleMovie().getId());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return USBoxMovieList.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder{
        public ImageView poster;
        public TextView title;
        public TextView rank_box;
        public MovieHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.poster);
            title = (TextView)itemView.findViewById(R.id.title);
            rank_box = (TextView) itemView.findViewById(R.id.rank_box);
        }
    }
}