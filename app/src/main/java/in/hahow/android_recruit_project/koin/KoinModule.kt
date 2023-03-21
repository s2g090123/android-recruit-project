package `in`.hahow.android_recruit_project.koin

import `in`.hahow.android_recruit_project.data.CourseRepository
import `in`.hahow.android_recruit_project.data.local.CourseLocalSource
import `in`.hahow.android_recruit_project.data.local.database.CourseDatabase
import `in`.hahow.android_recruit_project.data.remote.CourseRemoteSource
import `in`.hahow.android_recruit_project.datastore.CourseDataStore
import `in`.hahow.android_recruit_project.screen.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {

    // viewModel
    viewModel {
        MainViewModel(
            get<CourseRepository>(),
            get<CourseDataStore>()
        )
    }

    // single
    single { CourseDatabase.getInstance(androidContext()) }
    single {
        CourseRepository(get<CourseLocalSource>(), get<CourseRemoteSource>())
    }
    single {
        CourseDataStore(androidApplication())
    }

    // factory
    factory { (get() as CourseDatabase).getDao() }
    factory { CourseRemoteSource(androidApplication()) }
    factory { CourseLocalSource(get()) }

}