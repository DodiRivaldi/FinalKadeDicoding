package tech.march.finalsepakbola.util

import android.content.Context
import android.view.View
import tech.march.finalsepakbola.data.database.DatabaseHelper

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

val Context.db: DatabaseHelper
    get() = DatabaseHelper.getInstance(applicationContext)