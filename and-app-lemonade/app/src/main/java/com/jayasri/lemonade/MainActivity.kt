package com.jayasri.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jayasri.lemonade.ui.theme.LemonadeTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}
@Composable
fun LemonadeApp() {
    // Current step
    var step by remember {
        mutableStateOf(1)
    }
    // How many times lemon is tapped
    var squeezeCount by remember {
        mutableStateOf(0)
    }
    // taps required: 2, 3 or 4
    var requiredSqueezes by remember {
        mutableStateOf(2)
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Top bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(Color.Yellow),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Lemonade",
                fontSize = 20.sp,
                fontWeight =FontWeight.Bold
            )
        }
        // MAIN CONTENT
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            when (step) {
                // STEP 1
                1 -> {

                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = "Lemon tree",
                        modifier = Modifier
                            .size(150.dp)
                            .clickable {
                                step = 2
                                squeezeCount = 0
                                requiredSqueezes =
                                    Random.nextInt(2, 5)
                            }
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Tap the lemon tree to select a lemon"
                    )
                }
                // STEP 2
                2 -> {

                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = "Lemon",
                        modifier = Modifier
                            .size(150.dp)
                            .clickable {

                                squeezeCount++

                                if (squeezeCount >= requiredSqueezes) {
                                    step = 3
                                }
                            }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Keep tapping the lemon to squeeze it"
                    )
                }
                // STEP 3
                3 -> {

                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = "Lemonade",
                        modifier = Modifier
                            .size(150.dp)
                            .clickable {

                                step = 4
                            }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Tap the lemonade to drink it"
                    )
                }
                // step 4
                4 -> {

                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = "Empty glass",
                        modifier = Modifier
                            .size(150.dp)
                            .clickable {

                                step = 1
                                squeezeCount = 0
                            }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Tap the empty glass to start again"
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}