package `in`.hahow.android_recruit_project.datastore

import kotlinx.coroutines.flow.MutableStateFlow

class FakeDataStore : BaseDataStore {

    override val initData = MutableStateFlow(false)

    override suspend fun updateInitData(init: Boolean) {
        initData.value = init
    }
}