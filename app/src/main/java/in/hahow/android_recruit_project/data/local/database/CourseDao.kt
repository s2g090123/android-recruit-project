package `in`.hahow.android_recruit_project.data.local.database

import `in`.hahow.android_recruit_project.data.local.CourseLocalData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {

    @Query("SELECT * FROM course")
    fun getGames(): Flow<List<CourseLocalData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourses(courses: List<CourseLocalData>)
}