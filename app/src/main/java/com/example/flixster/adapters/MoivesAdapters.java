package com.example.flixster.adapters;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
//import com.codepath.rkpandey.flixster.R;
//import  com.codepath.rkpandey.flixster.models.Movie;
import com.example.flixster.R;
import com.example.flixster.models.Movie;

import java.util.List;


public class MoivesAdapters extends RecyclerView.Adapter<MoivesAdapters.ViewHolder> {

    Context context;
    List<Movie> movies;

    public MoivesAdapters(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;

    }


// Usually involves inflating a layout from xml and returning the holder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new ViewHolder(movieView);
    }
//Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      //get the movie at the passed position
        Movie movie = movies.get(position);
     // bind movie data in to the VH
       holder.bind(movie);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        TextView textViewOverview;
        ImageView imageViewPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.tvTitle);
            textViewOverview = itemView.findViewById(R.id.tvOverview);
            imageViewPoster = itemView.findViewById(R.id.IvPoster);
        }

        public void bind(Movie movie) {
            textViewTitle.setText(movie.getTitle());
            textViewOverview.setText(movie.getOverview());
            Glide.with(context).load(movie.getPosterPath()).into( imageViewPoster);
        }
    }
}






















