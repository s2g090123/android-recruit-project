package `in`.hahow.android_recruit_project.data.remote

import android.content.Context
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class CourseRemoteSource : BaseRemoteSource {

    override fun getRemoteCourseData(context: Context): CourseRemoteData {
        val json = StringBuilder()
        val inputStream = context.assets.open("data.json")
        val bufferedReader = BufferedReader(InputStreamReader(inputStream, "UTF-8"))
        while (true) {
            val line = bufferedReader.readLine() ?: break
            json.append(line)
        }
        val jsonString = json.toString()
        return Gson().fromJson(jsonString, CourseRemoteData::class.java)
    }
}