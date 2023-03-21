package `in`.hahow.android_recruit_project.screen

import `in`.hahow.android_recruit_project.screen.compose.MainScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val courses by viewModel.courses.collectAsState()
            MainScreen(
                modifier = Modifier.fillMaxSize(),
                currentDate = viewModel.currentDate,
                courses = courses
            )
        }
    }
}