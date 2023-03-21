package `in`.hahow.android_recruit_project.data.remote

import `in`.hahow.android_recruit_project.data.CourseDataFactory

class FakeRemoteSource : BaseRemoteSource {
    override fun getRemoteCourseData(): CourseRemoteData {
        return CourseDataFactory.createRemoteCourses()
    }
}