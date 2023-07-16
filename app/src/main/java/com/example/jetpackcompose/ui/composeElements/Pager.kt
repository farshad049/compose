package com.example.jetpackcompose.ui.composeElements

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


data class HorizontalPagerContent(
    val title: String,
    val subtitle: String,
    val description: String
)

fun createItems() = listOf(
    HorizontalPagerContent(title = "Title1", subtitle = "Subtitle1", description = "Description1"),
    HorizontalPagerContent(title = "Title2", subtitle = "Subtitle2", description = "Description2"),
    HorizontalPagerContent(title = "Title3", subtitle = "Subtitle3", description = "Description3"),
    HorizontalPagerContent(title = "Title4", subtitle = "Subtitle4", description = "Description4"),
    HorizontalPagerContent(title = "Title5", subtitle = "Subtitle5", description = "Description5"),
    HorizontalPagerContent(title = "Title6", subtitle = "Subtitle6", description = "Description6"),
    HorizontalPagerContent(title = "Title7", subtitle = "Subtitle7", description = "Description7"),
    HorizontalPagerContent(title = "Title8", subtitle = "Subtitle8", description = "Description8"),
    HorizontalPagerContent(title = "Title9", subtitle = "Subtitle9", description = "Description9"),
    HorizontalPagerContent(title = "Title10", subtitle = "Subtitle10", description = "Description10")
)

@Preview
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPagerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        val items = createItems()
        val pagerState = rememberPagerState()

        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { currentPage ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = items[currentPage].title,
                    style = MaterialTheme.typography.h2
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].subtitle,
                    style = MaterialTheme.typography.h4
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = items[currentPage].description,
                    style = MaterialTheme.typography.body1
                )
            }
        }

        val coroutineScope = rememberCoroutineScope()
        Button(
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(page = 2)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Scroll to the third page")
        }
    }
}



@Preview
@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalTabs(
) {

    val items = createItems()
    val pagerState = rememberPagerState(initialPage = 2)
    val coroutineScope = rememberCoroutineScope()



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        ScrollableTabRow (
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            items.forEachIndexed { index, item ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(page = index)
                        }
                    }
                ) {
                    Text(text = item.title)
                }
            }
        }

            HorizontalPager(
                count = items.size,
                state = pagerState,
                modifier = Modifier.weight(1f)
            ) { currentPage ->
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = items[currentPage].title,
                        style = MaterialTheme.typography.h2
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = items[currentPage].subtitle,
                        style = MaterialTheme.typography.h4
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = items[currentPage].description,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
