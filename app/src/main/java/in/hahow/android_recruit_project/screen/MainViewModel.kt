package `in`.hahow.android_recruit_project.screen

import `in`.hahow.android_recruit_project.data.BaseRepository
import `in`.hahow.android_recruit_project.datastore.BaseDataStore
import `in`.hahow.android_recruit_project.dispatcher.DefaultDispatcherProvider
import `in`.hahow.android_recruit_project.dispatcher.DispatcherProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.*

class MainViewModel(
    private val repository: BaseRepository,
    private val dataStore: BaseDataStore,
    dispatcherProvider: DispatcherProvider = DefaultDispatcherProvider
) : ViewModel() {

    val courses = repository.getCourseFlow()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    val currentDate = Date()

    init {
        viewModelScope.launch(dispatcherProvider.io) {
            val isInit = dataStore.initData.first()
            if (!isInit) {
                repository.updateCourse()
                dataStore.updateInitData(true)
            }
        }
    }
}