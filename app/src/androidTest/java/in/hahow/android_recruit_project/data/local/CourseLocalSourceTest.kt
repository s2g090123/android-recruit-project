package `in`.hahow.android_recruit_project.data.local

import `in`.hahow.android_recruit_project.data.CourseDataFactory
import `in`.hahow.android_recruit_project.data.local.database.CourseDatabase
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CourseLocalSourceTest {

    private lateinit var db: CourseDatabase
    private lateinit var localSource: CourseLocalSource

    @Before
    fun setup() {
        db = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            CourseDatabase::class.java
        ).build()
        localSource = CourseLocalSource(db.getDao())
    }

    @After
    fun teardown() {
        db.close()
    }

    @Test
    fun localSource_getSources_expectsEmpty() = runTest {
        val result = localSource.getSources().first()
        assertThat(result, `is`(emptyList()))
    }

    @Test
    fun localSource_insertSources_expectsList() = runTest {
        val courses = CourseDataFactory.createCourses()
        localSource.insertSources(courses)
        val result = localSource.getSources().first()
        assertThat(result, `is`(courses))
    }
}