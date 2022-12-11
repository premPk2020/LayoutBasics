package com.example.basicsoflayout

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int = R.drawable.fc1_short_mantras,
    @StringRes text: Int = R.string.fc1_short_mantras,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.width(192.dp)
        ) {

            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier.size(56.dp)
            )
            Text(
                text = stringResource(id = text),
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = modifier.padding(horizontal = 8.dp)
            )
        }
    }
}


private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }


@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    var itemCount by remember {
        mutableStateOf(0)
    }
    LazyRow(
        modifier = modifier.height(120.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(favoriteCollectionsData.size) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (it == 0) {
                    itemCount = it
                }
                if (itemCount < favoriteCollectionsData.size - 1) {
                    FavoriteCollectionCard(
                        favoriteCollectionsData[itemCount].drawable,
                        favoriteCollectionsData[itemCount].text,
                        modifier = Modifier.height(56.dp)
                    )
                    FavoriteCollectionCard(
                        favoriteCollectionsData[itemCount + 1].drawable,
                        favoriteCollectionsData[itemCount + 1].text,
                        modifier = Modifier.height(56.dp)
                    )
                }
                itemCount += 2
            }
        }
    }
}


//@Preview
//@Composable
//fun FavoriteCollectionCardPreview() {
//    FavoriteCollectionCard(
//        modifier = Modifier.padding(
//            8.dp
//        )
//    )
//}

@Preview(showBackground = false)
@Composable
fun FavoriteCollectionGridPreview() {
    FavoriteCollectionsGrid(modifier = Modifier.padding(8.dp))
}