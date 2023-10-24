package com.example.nativebits_mm_mvvm_di.ui.screens

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nativebits_mm_mvvm_di.ui.components.EmptyStateComponent
import com.example.nativebits_mm_mvvm_di.ui.components.Loader
import com.example.nativebits_mm_mvvm_di.ui.components.NewsRowComponent
import com.example.nativebits_mm_mvvm_di.ui.viewmodel.NewsViewModel
import com.example.utilities.ResourceState

const val TAG = "HomeScreen"

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    newsViewModel: NewsViewModel = hiltViewModel()
) {

    val newsRes by newsViewModel.news.collectAsState()

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        100
    }

    VerticalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize(),
        pageSize = PageSize.Fill,
        pageSpacing = 8.dp
    ) { page: Int ->

        when (newsRes) {
            is ResourceState.Loading -> {
                Log.d(TAG, "inside_Loading")
                Loader()
            }

            is ResourceState.Success -> {
                Log.d(TAG, "inside_Success")
                val response = (newsRes as ResourceState.Success).data
                if (response.articles.isNotEmpty()) {
                    NewsRowComponent(page, response.articles[page])
                } else EmptyStateComponent()
            }

            is ResourceState.Error -> {
                Log.d(TAG, "inside_Error")
                val response = (newsRes as ResourceState.Error)
                Log.d(TAG, response.toString())
            }
        }
    }


}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
