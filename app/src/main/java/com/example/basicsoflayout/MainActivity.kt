package com.example.basicsoflayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basicsoflayout.ui.theme.BasicsOfLayoutTheme
import com.example.basicsoflayout.ui.theme.backround

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsOfLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = backround
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
        Scaffold(
            bottomBar = { BottomNavigationBar()}
        ) { padding ->
            MainScreen(modifier = Modifier.padding(padding))

        }
}
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Column() {
        Spacer(modifier = Modifier.height(16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column() {
        Text(
            text = stringResource(id = title).uppercase(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 10.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}



@Preview(showBackground = true, backgroundColor = 0XFFF0EAE2)
@Composable
fun MyAppPreview() {
    MyApp()
}