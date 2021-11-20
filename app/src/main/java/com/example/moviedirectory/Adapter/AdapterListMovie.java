package com.example.moviedirectory.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedirectory.Model.Movie;
import com.example.moviedirectory.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterListMovie extends RecyclerView.Adapter<AdapterListMovie.ViewHolder> {

    Context context;
    List<Movie> movieList;

    public AdapterListMovie(Context context, List<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_movie_layout,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String posterPath = movieList.get(position).getPosterPath();
        Picasso.with(context).load(posterPath).fit().centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.movie);

        holder.txtTitleMov.setText(movieList.get(position).getTitle());
        holder.txtReleaseMov.setText(movieList.get(position).getReleaseDate());
        holder.txtOverviewMov.setText(movieList.get(position).getOverview());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movie;
        TextView txtTitleMov, txtOverviewMov, txtReleaseMov;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            movie = itemView.findViewById(R.id.icon);
            txtTitleMov = itemView.findViewById(R.id.txtTitleMov);
            txtOverviewMov = itemView.findViewById(R.id.txtOverviewMov);
            txtReleaseMov = itemView.findViewById(R.id.txtReleaseMov);
        }
    }
}
