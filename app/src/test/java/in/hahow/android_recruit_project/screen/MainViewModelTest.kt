package `in`.hahow.android_recruit_project.screen

import `in`.hahow.android_recruit_project.TestCoroutineEnvironment
import `in`.hahow.android_recruit_project.data.BaseRepository
import `in`.hahow.android_recruit_project.data.CourseDataFactory
import `in`.hahow.android_recruit_project.data.FakeRepository
import `in`.hahow.android_recruit_project.datastore.BaseDataStore
import `in`.hahow.android_recruit_project.datastore.FakeDataStore
import `in`.hahow.android_recruit_project.rule.MainDispatcherRule
import `in`.hahow.android_recruit_project.utils.launchAndCollect
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel
    private lateinit var repository: BaseRepository
    private lateinit var dataStore: BaseDataStore

    private val coroutineEnvironment = TestCoroutineEnvironment()

    @get:Rule
    val mainDispatcherRule =
        MainDispatcherRule(coroutineEnvironment.testDispatcherProvider.unconfined)

    @Before
    fun setup() {
        repository = FakeRepository()
        dataStore = FakeDataStore()
        viewModel = createViewModel()
    }

    @Test
    fun main_getCourses_expectsCourses() = runTest {
        viewModel.courses.launchAndCollect(coroutineEnvironment)
        assertThat(viewModel.courses.value, `is`(CourseDataFactory.createCourses()))
    }

    private fun createViewModel(): MainViewModel {
        return MainViewModel(
            repository,
            dataStore,
            coroutineEnvironment.testDispatcherProvider
        )
    }
}