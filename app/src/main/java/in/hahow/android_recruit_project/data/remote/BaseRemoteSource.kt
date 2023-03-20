package `in`.hahow.android_recruit_project.data.remote

import android.content.Context

interface BaseRemoteSource {
    fun getRemoteCourseData(context: Context): CourseRemoteData
}