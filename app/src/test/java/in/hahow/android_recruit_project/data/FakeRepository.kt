package `in`.hahow.android_recruit_project.data

import `in`.hahow.android_recruit_project.data.local.CourseLocalData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeRepository : BaseRepository {

    private val courses = MutableStateFlow<List<CourseLocalData>>(emptyList())

    override fun getCourseFlow(): Flow<List<CourseLocalData>> {
        return courses
    }

    override suspend fun updateCourse() {
        courses.value = CourseDataFactory.createCourses()
    }
}