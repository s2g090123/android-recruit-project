package `in`.hahow.android_recruit_project.data

import `in`.hahow.android_recruit_project.data.local.CourseLocalData
import kotlinx.coroutines.flow.Flow

interface BaseRepository {
    fun getCourseFlow(): Flow<List<CourseLocalData>>
    suspend fun updateCourse()
}