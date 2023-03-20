package `in`.hahow.android_recruit_project.utils

import `in`.hahow.android_recruit_project.TestCoroutineEnvironment
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
fun <T> Flow<T>.launchAndCollect(coroutineEnvironment: TestCoroutineEnvironment) {
    coroutineEnvironment.testScope.launch(coroutineEnvironment.testDispatcherProvider.unconfined) {
        collect()
    }
}