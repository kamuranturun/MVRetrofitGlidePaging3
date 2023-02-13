package com.turun.androidkotlin

const val NETWORK_PAGE_SIZE = 25  //bir sayfada 25 adet

data class MovieResponse(val page: Int,
                         val results: List<Movie>)

data class Movie(val original_title: String,
                 val poster_path: String,
                 val overview: String)