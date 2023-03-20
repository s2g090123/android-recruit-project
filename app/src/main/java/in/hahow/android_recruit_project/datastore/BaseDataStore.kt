package `in`.hahow.android_recruit_project.datastore

import kotlinx.coroutines.flow.Flow

interface BaseDataStore {
    val initData: Flow<Boolean>
    suspend fun updateInitData(init: Boolean)
}