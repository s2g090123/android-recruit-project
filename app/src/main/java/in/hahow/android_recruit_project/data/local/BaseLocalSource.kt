package `in`.hahow.android_recruit_project.data.local

import kotlinx.coroutines.flow.Flow

interface BaseLocalSource {
    fun getCourses(): Flow<List<CourseLocalData>>
    suspend fun insertCourses(sources: List<CourseLocalData>)
}