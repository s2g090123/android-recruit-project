package `in`.hahow.android_recruit_project.datastore

import `in`.hahow.android_recruit_project.datastore.CourseDataStore.PreferencesKeys.INIT_DATA
import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "course_data_store")

class CourseDataStore(
    private val application: Application
) : BaseDataStore {

    object PreferencesKeys {
        val INIT_DATA = booleanPreferencesKey("init_data")
    }

    private val datastore by lazy {
        application.applicationContext.dataStore
    }

    override val initData: Flow<Boolean> by lazy {
        datastore.data.map { prefs ->
            prefs[INIT_DATA] ?: false
        }
    }

    override suspend fun updateInitData(init: Boolean) {
        datastore.edit { prefs ->
            prefs[INIT_DATA] = init
        }
    }
}