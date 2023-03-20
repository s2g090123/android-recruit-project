package `in`.hahow.android_recruit_project.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "course")
data class CourseLocalData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Long = 0L,
    @ColumnInfo(name = "status") val status: CourseStatus,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "image_url") val imageUrl: String,
    @ColumnInfo(name = "due_time") val proposalDueTime: Date?,
    @ColumnInfo(name = "sold_tickets") val soldTickets: Int,
    @ColumnInfo(name = "success_sold_tickets") val successSoldTickets: Int
)