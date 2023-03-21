package `in`.hahow.android_recruit_project.data.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class FakeLocalSource : BaseLocalSource {

    private val sources = MutableStateFlow<List<CourseLocalData>>(emptyList())

    override fun getSources(): Flow<List<CourseLocalData>> {
        return sources
    }

    override suspend fun insertSources(sources: List<CourseLocalData>) {
        this.sources.value = sources
    }
}