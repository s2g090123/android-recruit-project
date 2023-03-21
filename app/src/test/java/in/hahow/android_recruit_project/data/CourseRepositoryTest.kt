package `in`.hahow.android_recruit_project.data

import `in`.hahow.android_recruit_project.data.local.FakeLocalSource
import `in`.hahow.android_recruit_project.data.remote.FakeRemoteSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CourseRepositoryTest {

    private lateinit var repository: CourseRepository

    @Before
    fun setup() {
        repository = CourseRepository(
            FakeLocalSource(),
            FakeRemoteSource()
        )
    }

    @Test
    fun repository_getCourseFlow_expectsEmpty() = runTest {
        val courses = repository.getCourseFlow().first()
        assertThat(courses, `is`(emptyList()))
    }

    @Test
    fun repository_updateAndGetCoursesFlow_expectsList() = runTest {
        repository.updateCourse()
        val courses = repository.getCourseFlow().first()
        val expects = CourseDataFactory.createRemoteCourses().toLocal()
        assertThat(courses, `is`(expects))
    }
}