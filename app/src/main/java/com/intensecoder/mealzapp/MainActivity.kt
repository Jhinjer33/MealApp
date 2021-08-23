package com.intensecoder.mealzapp

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.lifecycle.viewmodel.compose.viewModel
import com.intensecoder.mealzapp.ui.meals_catagories.MealsListScreen
import com.intensecoder.mealzapp.ui.meals_catagories.MealsListViewModel
import com.intensecoder.mealzapp.ui.theme.MealzAppTheme
import com.intensecoder.mealzapp.ui.theme.PrimaryColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            MealzAppTheme {

                SystemUi(windows = this.window)

                MealsListScreen()
            }
        }
    }
}


@Composable
fun SystemUi(windows: Window) =
    MaterialTheme {
        windows.statusBarColor = PrimaryColor.toArgb()
    }



