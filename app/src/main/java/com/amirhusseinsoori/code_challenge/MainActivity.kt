package com.amirhusseinsoori.code_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.amirhusseinsoori.code_challenge.ui.screen.movie.MovieViewModel
import com.amirhusseinsoori.code_challenge.ui.navigation.SetupNavGraph
import com.amirhusseinsoori.code_challenge.ui.screen.ListContent
import com.amirhusseinsoori.code_challenge.ui.theme.Code_challengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalPagingApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Code_challengeTheme {

                SetupNavGraph()
            }
        }
    }
}


@OptIn(ExperimentalPagingApi::class, ExperimentalCoilApi::class)
@Composable
fun MovieScreen(
    navController: NavHostController,
    homeViewModel: MovieViewModel = hiltViewModel(),
) {
    val getAllMovies = homeViewModel.getAllImages.collectAsLazyPagingItems()
    ListContent(items = getAllMovies, navController)
}


