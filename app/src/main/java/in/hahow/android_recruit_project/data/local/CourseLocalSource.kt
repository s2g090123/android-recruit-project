package `in`.hahow.android_recruit_project.data.local

import `in`.hahow.android_recruit_project.data.local.database.CourseDao
import kotlinx.coroutines.flow.Flow

class CourseLocalSource(
    private val dao: CourseDao
) : BaseLocalSource {

    override fun getSources(): Flow<List<CourseLocalData>> {
        return dao.getGames()
    }

    override suspend fun insertSources(sources: List<CourseLocalData>) {
        dao.insertCourses(sources)
    }
}