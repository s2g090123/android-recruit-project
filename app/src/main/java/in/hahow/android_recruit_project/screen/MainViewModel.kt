package `in`.hahow.android_recruit_project.screen

import `in`.hahow.android_recruit_project.data.BaseRepository
import `in`.hahow.android_recruit_project.datastore.BaseDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: BaseRepository,
    private val dataStore: BaseDataStore
) : ViewModel() {

    val courses = repository.getCourseFlow()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val isInit = dataStore.initData.first()
            if (!isInit) {
                repository.updateCourse()
                dataStore.updateInitData(true)
            }
        }
    }
}