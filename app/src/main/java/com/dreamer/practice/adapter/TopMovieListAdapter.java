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
import com.dreamer.practice.bean.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreamer on 2015/5/12.
 */
public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.MovieHolder> {
    private static final String TAG = "MovieListAdapter";
    private List<Movie> movieList;
    private Context context;

    public TopMovieListAdapter(Context context){
        this.context = context;
        movieList = new ArrayList<Movie>();
    }

    public void addMovies(List<Movie> movies) {
        this.movieList.addAll(movies);
        this.notifyItemRangeInserted(0, movies.size() - 1);
    }

    public void clearMovies() {
        int size = this.movieList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                movieList.remove(0);
            }
            this.notifyItemRangeRemoved(0, size);
        }
    }

    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.top_movie_item, viewGroup, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieHolder holder, final int position) {
        final Movie movie = movieList.get(position);
        //Picasso.with(context).setIndicatorsEnabled(true);
        Picasso.with(context).load(movie.getImages().getSmall()).into(holder.poster);
        holder.title.setText(movie.getTitle());
        holder.original_title.setText(movie.getOriginalTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,context.getResources().getString(R.string.click)+(i+1),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MovieDetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("movieID",movie.getId());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder{
        public ImageView poster;
        public TextView title;
        public TextView original_title;
        public MovieHolder(View itemView) {
            super(itemView);
            poster = (ImageView) itemView.findViewById(R.id.poster);
            title = (TextView)itemView.findViewById(R.id.title);
            original_title = (TextView) itemView.findViewById(R.id.original_title);
        }
    }
}
