package `in`.hahow.android_recruit_project.screen.compose

import `in`.hahow.android_recruit_project.R
import `in`.hahow.android_recruit_project.data.local.CourseLocalData
import `in`.hahow.android_recruit_project.data.local.CourseStatus
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.math.min

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    currentDate: Date,
    courses: List<CourseLocalData>,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp)
    ) {
        items(courses) { course ->
            CourseItem(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .shadow(8.dp, RoundedCornerShape(8.dp), true)
                    .fillMaxWidth()
                    .aspectRatio(3.5f)
                    .background(Color.White)
                    .padding(top = 8.dp, bottom = 8.dp),
                data = course,
                currentDate = currentDate
            )
        }
    }
}

@Composable
private fun CourseItem(
    modifier: Modifier = Modifier,
    data: CourseLocalData,
    currentDate: Date
) {
    val percentage by remember(data) {
        mutableStateOf(min(data.soldTickets / data.successSoldTickets.toFloat(), 1f))
    }
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(start = 8.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxHeight()
                .aspectRatio(1.2f)
        ) {
            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(data.imageUrl)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            StatusLabel(
                modifier = Modifier.align(Alignment.BottomEnd),
                status = data.status
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier.weight(1f),
                text = data.title,
                color = Color(0xDE000000),
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.6f)
                ) {
                    Text(
                        text = if (data.status == CourseStatus.INCUBATING) {
                            stringResource(
                                R.string.course_incubating_proportion,
                                data.soldTickets,
                                data.successSoldTickets
                            )
                        } else {
                            stringResource(
                                R.string.course_publish_percentage,
                                (percentage * 100).toInt()
                            )
                        },
                        color = Color(0x99000000),
                        fontSize = 14.sp
                    )
                    LinearProgressIndicator(
                        modifier = Modifier
                            .clip(RoundedCornerShape(2.dp))
                            .fillMaxWidth(0.5f),
                        progress = percentage,
                        color = getColorByStatus(data.status),
                        backgroundColor = Color(0x1F000000)
                    )
                }
                data.proposalDueTime?.let {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            modifier = Modifier
                                .size(18.dp)
                                .alpha(0.6f),
                            painter = painterResource(R.drawable.ic_black_time),
                            contentDescription = null
                        )
                        Text(
                            modifier = Modifier.padding(start = 4.dp),
                            text = stringResource(
                                R.string.course_remaining_days,
                                TimeUnit.MILLISECONDS.toDays(it.time - currentDate.time)
                            ),
                            color = Color(0x99000000),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun StatusLabel(
    modifier: Modifier = Modifier,
    status: CourseStatus,
) {
    Text(
        modifier = modifier.then(
            Modifier
                .clip(RoundedCornerShape(topStart = 8.dp))
                .background(getColorByStatus(status))
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ),
        text = stringResource(
            when (status) {
                CourseStatus.INCUBATING -> R.string.course_incubating_label
                CourseStatus.PUBLISHED -> R.string.course_published_label
                CourseStatus.SUCCESS -> R.string.course_success_label
            }
        ),
        color = Color.White,
        fontSize = 14.sp
    )
}

@Composable
private fun getColorByStatus(status: CourseStatus): Color {
    return when (status) {
        CourseStatus.INCUBATING -> Color(0xFFEB9500)
        CourseStatus.PUBLISHED -> Color(0xFF02BD8E)
        CourseStatus.SUCCESS -> Color.Red
    }
}