package `in`.hahow.android_recruit_project.data.remote

import `in`.hahow.android_recruit_project.data.local.CourseLocalData
import `in`.hahow.android_recruit_project.data.local.CourseStatus
import android.annotation.SuppressLint
import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*

data class CourseRemoteData(
    @SerializedName("data")
    val data: List<Data>?
) {
    data class Data(
        @SerializedName("successCriteria")
        val successCriteria: SuccessCriteria?,
        @SerializedName("numSoldTickets")
        val numSoldTickets: Int?,
        @SerializedName("status")
        val status: CourseStatus?,
        @SerializedName("proposalDueTime")
        val proposalDueTime: String?,
        @SerializedName("coverImageUrl")
        val coverImageUrl: String?,
        @SerializedName("title")
        val title: String?
    ) {
        data class SuccessCriteria(
            @SerializedName("numSoldTickets")
            val numSoldTickets: Int?
        )
    }

    fun toLocal(): List<CourseLocalData>? {
        return data?.mapNotNull {
            it.successCriteria?.numSoldTickets ?: return@mapNotNull null
            it.numSoldTickets ?: return@mapNotNull null
            it.status ?: return@mapNotNull null
            it.coverImageUrl ?: return@mapNotNull null
            it.title ?: return@mapNotNull null
            val time = it.proposalDueTime?.run { parseTime(this) } ?: return@mapNotNull null
            CourseLocalData(
                status = it.status,
                title = it.title,
                imageUrl = it.coverImageUrl,
                proposalDueTime = time,
                soldTickets = it.numSoldTickets,
                successSoldTickets = it.successCriteria.numSoldTickets
            )
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun parseTime(time: String): Date? {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.000'Z'")
        return format.parse(time)
    }
}