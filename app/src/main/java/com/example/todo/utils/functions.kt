package com.example.todo.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun getFormattedDateTime(millis: Long, s: String) =
    SimpleDateFormat(Locale.getDefault().toString()).format(Date(millis))

