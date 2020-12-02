package nl.OmerErdem.madlvl5t2.utils

import androidx.room.TypeConverter
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Calendar? = value?.let { _ ->
        GregorianCalendar().also { calendar ->
            calendar.timeInMillis = value
        }
    }
//    fun fromTimestamp(value: Long?): Calendar? {
//        return value?.let {  Calendar.getInstance().timeInMillis = it * 1000L }
//    }

    @TypeConverter
    fun toTimestamp(calendar: Calendar?): Long? {
        return calendar?.timeInMillis
    }
}