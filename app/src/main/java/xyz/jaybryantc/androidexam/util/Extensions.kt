package xyz.jaybryantc.androidexam.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun Date.format(): String {
    val sdf = SimpleDateFormat.getDateInstance()
    return sdf.format(this)
}

fun Date.getElapsedYears(): Int {
    val date = Calendar.getInstance()
    val today = Calendar.getInstance()
    date.time = this
    var elapsedYears = today.get(Calendar.YEAR) - date.get(Calendar.YEAR)
    if ((date.get(Calendar.MONTH) > today.get(Calendar.MONTH)) ||
        (date.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
                date.get(Calendar.DATE) > today.get(Calendar.DATE))
    ) {
        elapsedYears--
    }
    return elapsedYears
}
