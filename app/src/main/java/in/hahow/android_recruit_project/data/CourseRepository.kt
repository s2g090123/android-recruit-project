package `in`.hahow.android_recruit_project.data

import `in`.hahow.android_recruit_project.data.local.BaseLocalSource
import `in`.hahow.android_recruit_project.data.local.CourseLocalData
import `in`.hahow.android_recruit_project.data.remote.BaseRemoteSource
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class CourseRepository(
    private val localSource: BaseLocalSource,
    private val remoteSource: BaseRemoteSource
) : BaseRepository {

    override fun getCourseFlow(): Flow<List<CourseLocalData>> {
        return localSource.getSources()
    }

    override suspend fun updateCourse() {
        try {
            val remoteData = remoteSource.getRemoteCourseData()
            val localData = remoteData.toLocal()
            localData?.let {
                localSource.insertSources(it)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}