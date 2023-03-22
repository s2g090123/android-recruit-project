package `in`.hahow.android_recruit_project.screen.compose

import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.data.CourseDataFactory
import `in`.hahow.android_recruit_project.data.local.CourseStatus
import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import androidx.test.core.app.ApplicationProvider
import org.junit.Rule
import org.junit.Test
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.min

class MainScreenTest {

    companion object {
        private const val TAG = "MAIN_SCREEN"
    }

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun mainScreen_checksIncubating() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val course = CourseDataFactory.createCourse(1, CourseStatus.INCUBATING)
        val date = Date(1672502400000)
        composeTestRule.setContent {
            MainScreen(
                modifier = Modifier.fillMaxWidth(),
                currentDate = date,
                courses = listOf(course)
            )
        }

        composeTestRule.onRoot().printToLog(TAG)
        composeTestRule.onNodeWithText(course.title).assertIsDisplayed()
        composeTestRule.onNodeWithText(context.getString(R.string.course_incubating_label))
            .assertIsDisplayed()
        composeTestRule.onNodeWithText(
            context.getString(
                R.string.course_incubating_proportion,
                course.soldTickets,
                course.successSoldTickets
            )
        ).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            context.getString(
                R.string.course_remaining_days,
                TimeUnit.MILLISECONDS.toDays((course.proposalDueTime?.time ?: 0) - date.time)
            )
        ).assertIsDisplayed()
    }

    @Test
    fun mainScreen_checksPublish() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val course = CourseDataFactory.createCourse(1, CourseStatus.PUBLISHED)
        val date = Date(1672502400000)
        composeTestRule.setContent {
            MainScreen(
                modifier = Modifier.fillMaxWidth(),
                currentDate = date,
                courses = listOf(course)
            )
        }

        composeTestRule.onRoot().printToLog(TAG)
        composeTestRule.onNodeWithText(course.title).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            context.getString(R.string.course_published_label)
        ).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            context.getString(
                R.string.course_publish_percentage,
                (min(1f, course.soldTickets.toFloat() / course.successSoldTickets) * 100).toInt()
            )
        )
    }

    @Test
    fun mainScreen_checksSuccess() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val course = CourseDataFactory.createCourse(1, CourseStatus.SUCCESS)
        val date = Date(1672502400000)
        composeTestRule.setContent {
            MainScreen(
                modifier = Modifier.fillMaxWidth(),
                currentDate = date,
                courses = listOf(course)
            )
        }

        composeTestRule.onRoot().printToLog(TAG)
        composeTestRule.onNodeWithText(course.title).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            context.getString(R.string.course_success_label)
        ).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            context.getString(
                R.string.course_publish_percentage,
                (min(1f, course.soldTickets.toFloat() / course.successSoldTickets) * 100).toInt()
            )
        )
    }
}