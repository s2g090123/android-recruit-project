package `in`.hahow.android_recruit_project.data.local.database.converter

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun to(value: Long?): Date? {
        return value?.let { Date(value) }
    }

    @TypeConverter
    fun from(value: Date?): Long? {
        return value?.time
    }
}