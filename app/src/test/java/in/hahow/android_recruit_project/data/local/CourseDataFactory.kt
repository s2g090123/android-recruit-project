package `in`.hahow.android_recruit_project.data.local

import java.util.*

object CourseDataFactory {

    fun createCourses(): List<CourseLocalData> {
        return listOf(
            createCourse(CourseStatus.INCUBATING),
            createCourse(CourseStatus.SUCCESS),
            createCourse(CourseStatus.PUBLISHED)
        )
    }

    fun createCourse(status: CourseStatus): CourseLocalData {
        return CourseLocalData(
            id = 0,
            status = status,
            title = "Fake Course",
            imageUrl = "",
            proposalDueTime = Date(1687277582000),
            soldTickets = 10,
            successSoldTickets = 100
        )
    }
}