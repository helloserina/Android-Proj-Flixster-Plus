package com.example.flixster

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.Target.SIZE_ORIGINAL

class MovieListRecyclerViewAdapter (private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieListRecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_single_movie, parent, false)
        return MovieViewHolder(view)
    }

    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(holder, position)
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return movies.size
    }

    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Movie? = null
        val mMovieTitle: TextView = mView.findViewById<View>(R.id.movie_title) as TextView
        val mMovieImage: ImageView = mView.findViewById<View>(R.id.movie_image) as ImageView
        val mMovieDescription: TextView = mView.findViewById<View>(R.id.movie_description) as TextView

        override fun toString(): String {
            return mMovieTitle.toString()
        }

        fun bind(holder: MovieViewHolder, position: Int){
            val movie = movies[position]

            holder.mItem = movie
            holder.mMovieTitle.text = movie.title
            holder.mMovieDescription.text = movie.description
            Log.d("MovieListRecyclerViewAdapter", "image = " + holder.mView.toString())

            Glide.with(holder.mView)
                .load("https://image.tmdb.org/t/p/w500/" + movie.image)
                .centerInside()
                .into(holder.mMovieImage)

            Log.d("MovieListRecyclerViewAdapter", "image should be attached")
        }
    }
}