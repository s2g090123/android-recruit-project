package `in`.hahow.android_recruit_project.data.remote

import android.app.Application
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class CourseRemoteSource(
    private val application: Application
) : BaseRemoteSource {

    override fun getRemoteCourseData(): CourseRemoteData {
        val json = StringBuilder()
        val inputStream = application.applicationContext.assets.open("data.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
        while (true) {
            val line = bufferedReader.readLine() ?: break
            json.append(line)
        }
        val jsonString = json.toString()
        return Gson().fromJson(jsonString, CourseRemoteData::class.java)
    }
}