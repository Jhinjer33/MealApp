package com.intensecoder.mealzapp.ui.meals_catagories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.intensecoder.mealzapp.R
import com.intensecoder.mealzapp.ui.theme.*


val rootPadding = 24.dp
val topPadding = 20.dp
val cornerDimen = 12.dp

@Composable
fun MealsListScreen() {

    Column(Modifier.fillMaxSize()) {

        //header text
        TitleText()

        //to search meals
        SearchBar()

        Spacer(modifier = Modifier.height(topPadding))


        var categoryButtonState by remember {
            mutableStateOf(false)
        }


        // meal categories
        CategoriesList()

        Spacer(modifier = Modifier.height(topPadding))

        //meals
        FoodItemList()

    }

}

@Composable
fun TitleText() {

    Box(
        modifier = Modifier
            .fillMaxWidth(0.7f)
            .padding(rootPadding)
    ) {
        Text(
            text = "Find \nYour Best Food!",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.ExtraBold,
            color = MainTextColor
        )
    }


}

@Composable
fun SearchBar() {
    TextField(
        modifier = Modifier
            .padding(horizontal = rootPadding)
            .fillMaxWidth(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MyLightGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        placeholder = {
            Text(text = "Search")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = ""
            )
        },
        value = "",
        onValueChange = {
        },

        )
}


@Composable
fun CategoriesList() {

    var selectedIndex by remember {
        mutableStateOf(-1)
    }

    LazyRow {
        items(count = 5) { index ->
            //single row item

            val endPadding =
                if (index == 4) {
                    rootPadding
                } else {
                    0.dp
                }


            Row(
                Modifier
                    .padding(start = rootPadding, end = endPadding)
                    .background(
                        color = if (index == selectedIndex) PrimaryColor else ChipsBackgroundColor,
                        shape = RoundedCornerShape(cornerDimen)
                    )
                    .clip(RoundedCornerShape(cornerDimen))
                    .clickable {
                        selectedIndex = index
                    }
                    .padding(topPadding),
            ) {
                Image(
                    painter = painterResource(
                        id = R.drawable.hamburger
                    ),
                    contentDescription = "",
                    Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Fast Food",
                    style = MaterialTheme.typography.body2,
                    color = if (index == selectedIndex) Color.White else MyDarkGray,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }

    }
}


@Composable
fun FoodItemList() {

    LazyRow(
        Modifier
            .fillMaxSize()
            .padding(bottom = topPadding)

    ) {
        items(3) { index ->

            val endPadding = if (index == 2) {
                rootPadding
            } else {
                0.dp
            }

            //single row item
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(
                        start = rootPadding,
                        end = endPadding
                    )
                    .background(
                        ChipsBackgroundColor,
                        shape = RoundedCornerShape(cornerDimen)
                    )
            ) {

                //top image
                Image(
                    modifier = Modifier
                        .width(260.dp)
                        .fillMaxHeight(0.68f)
                        .clip(
                            shape = RoundedCornerShape(
                                topStart = cornerDimen,
                                topEnd = cornerDimen
                            )
                        ),
                    painter = painterResource(id = R.drawable.food_placeholder),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )


                //bottom section
                Column(
                    Modifier
                        .width(260.dp)
                        .padding(16.dp)

                ) {


                    Text(
                        text = "Meaty Pizza\nwith beef",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.SemiBold,
                        color = MainTextColor
                    )

                    Spacer(modifier = Modifier.height(topPadding))

                    Row(
                        Modifier
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Amount
                        Icon(
                            painter = painterResource(id = R.drawable.ic_money),
                            contentDescription = "money",
                            tint = PrimaryColor
                        )

                        Text(
                            text = "6.30",
                            style = MaterialTheme.typography.h6,
                            fontWeight = FontWeight.Black,
                            color = MainTextColor
                        )
                        //--

                        Spacer(modifier = Modifier.weight(1f))


                        //Rating 
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star),
                            contentDescription = "rating",
                            tint = GoldenColor
                        )

                        Text(
                            text = "4.9", style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.SemiBold,
                            color = MyDarkGray
                        )
                        //---


                    }
                }
            }
        }
    }
}






