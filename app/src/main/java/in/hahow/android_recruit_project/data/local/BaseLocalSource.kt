package `in`.hahow.android_recruit_project.data.local

import kotlinx.coroutines.flow.Flow

interface BaseLocalSource {
    fun getSources(): Flow<List<CourseLocalData>>
    suspend fun insertSources(sources: List<CourseLocalData>)
}