package com.example.leccion.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.leccion.R

data class Libro (
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val author: Int,
    @StringRes val gender: Int
)

val libros = listOf(
    Libro(R.drawable._1, R.string.L1, R.string.Miguel, R.string.Drama),
    Libro(R.drawable._2, R.string.L2, R.string.Charles, R.string.Drama),
    Libro(R.drawable._3, R.string.L3, R.string.JRR, R.string.Aventura),
    Libro(R.drawable._4, R.string.L4, R.string.Antonie, R.string.Infantil),
    Libro(R.drawable._5, R.string.L5, R.string.JRR, R.string.Fantasia),
    Libro(R.drawable._6, R.string.L6, R.string.JK, R.string.Fantasia),
)