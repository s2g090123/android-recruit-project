package `in`.hahow.android_recruit_project.data

import `in`.hahow.android_recruit_project.data.local.CourseLocalData
import `in`.hahow.android_recruit_project.data.local.CourseStatus
import `in`.hahow.android_recruit_project.data.remote.CourseRemoteData
import java.util.*

object CourseDataFactory {

    fun createCourses(): List<CourseLocalData> {
        return listOf(
            createCourse(1, CourseStatus.INCUBATING),
            createCourse(2, CourseStatus.SUCCESS),
            createCourse(3, CourseStatus.PUBLISHED)
        )
    }

    fun createCourse(id: Long, status: CourseStatus): CourseLocalData {
        return CourseLocalData(
            id = id,
            status = status,
            title = "Fake Course",
            imageUrl = "",
            proposalDueTime = status.takeIf {
                status == CourseStatus.INCUBATING
            }?.let {
                Date(1687248000000)
            },
            soldTickets = 10,
            successSoldTickets = 100
        )
    }

    fun createRemoteCourses(): CourseRemoteData {
        return CourseRemoteData(
            listOf(
                createRemoteCourse(CourseStatus.INCUBATING),
                createRemoteCourse(CourseStatus.SUCCESS),
                createRemoteCourse(CourseStatus.PUBLISHED)
            )
        )
    }

    fun createRemoteCourse(status: CourseStatus): CourseRemoteData.Data {
        return CourseRemoteData.Data(
            successCriteria = CourseRemoteData.Data.SuccessCriteria(100),
            numSoldTickets = 10,
            status = status,
            proposalDueTime = status.takeIf {
                status == CourseStatus.INCUBATING
            }?.let {
                "2023-06-20T16:00:00.000Z"
            },
            coverImageUrl = "",
            title = "Fake Course"
        )
    }
}