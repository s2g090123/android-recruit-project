package `in`.hahow.android_recruit_project.data.remote

import `in`.hahow.android_recruit_project.data.FakeRemoteCourseLoader
import android.app.Application
import com.google.gson.Gson
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class CourseRemoteSourceTest {

    private val application = mockk<Application>()
    private lateinit var remoteSource: CourseRemoteSource

    @Before
    fun setup() {
        remoteSource = CourseRemoteSource(application)
        every {
            application.applicationContext.assets.open("data.json")
        } returns FakeRemoteCourseLoader.getInputStream()!!
    }

    @Test
    fun getRemoteCourseData() {
        val result = remoteSource.getRemoteCourseData()
        val expect = Gson().fromJson(getJsonString(), CourseRemoteData::class.java)
        assertThat(result, `is`(expect))
    }

    private fun getJsonString(): String {
        return "{\n" +
                "  \"data\": [\n" +
                "    {\n" +
                "      \"successCriteria\": {\n" +
                "        \"numSoldTickets\": 30\n" +
                "      },\n" +
                "      \"numSoldTickets\": 0,\n" +
                "      \"status\": \"INCUBATING\",\n" +
                "      \"proposalDueTime\": \"2023-06-06T16:00:00.000Z\",\n" +
                "      \"coverImageUrl\": \"https://images.api.hahow.in/images/614eca15a39712000619b672\",\n" +
                "      \"title\": \"學習 AI 一把抓：點亮人工智慧技能樹\"\n" +
                "    }\n" +
                "  ]\n" +
                "}"
    }
}