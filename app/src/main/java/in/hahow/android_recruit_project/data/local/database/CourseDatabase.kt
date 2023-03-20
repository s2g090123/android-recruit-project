package `in`.hahow.android_recruit_project.data.local.database

import `in`.hahow.android_recruit_project.data.local.CourseLocalData
import `in`.hahow.android_recruit_project.data.local.database.converter.DateConverter
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [CourseLocalData::class],
    version = 1
)
@TypeConverters(DateConverter::class)
abstract class CourseDatabase : RoomDatabase() {

    companion object {

        private const val DATABASE_NAME = "course_database"

        @Volatile
        private var instance: CourseDatabase? = null

        fun getInstance(context: Context): CourseDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): CourseDatabase {
            return Room.databaseBuilder(context, CourseDatabase::class.java, DATABASE_NAME).build()
        }
    }

    abstract fun getDao(): CourseDao
}