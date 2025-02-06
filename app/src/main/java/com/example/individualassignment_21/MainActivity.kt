package com.example.individualassignment_21

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.individualassignment_21.ui.theme.IndividualAssignment_21Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IndividualAssignment_21Theme {
                MakeCard()
            }
        }
    }
}

//Makes the clock icon with text overlapping the bottom.
//Used for the prep and cook time sections.
@Composable
fun drawClock(label: String) {
    Box(
        modifier = Modifier.size(width = 120.dp, height = 70.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.heroicons_clock),
            contentDescription = "clock icon",
            colorFilter = ColorFilter.tint(Color.Gray),
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(70.dp)
        )
        Text(
            text = label,
            modifier = Modifier.align(Alignment.BottomCenter),
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            lineHeight = 14.sp
        )
    }
}

//Makes a bulleted list of text from the given array of strings.
@Composable
fun bulletList(elements: Array<String>, modifier: Modifier) {
    val bullet = "\u2022"
    var final = ""
    for(str in elements) {
        final = final + bullet + " " + str + "\n"
    }
    Text(
        text = final,
        fontSize = 20.sp,
        fontFamily = FontFamily.SansSerif,
        color = Color.DarkGray,
        lineHeight = 36.sp,
        modifier = modifier
    )
}

//Make a card object containing a column of elements for the recipe card.
@Composable
fun MakeCard() {
    //A gray rectangular card with rounded corners
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray,
        ),
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 24.dp,
                vertical = 24.dp
            ),
        shape = RoundedCornerShape(
            size = 10.dp
        )

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 12.dp,
                    vertical = 12.dp
                )
        ) {
            Text(
                text = "Gramma's Bread-Free Toast",
                fontSize = 40.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.DarkGray,
                lineHeight = 40.sp
            )
            Divider(
                thickness = 8.dp,
                color = Color.Transparent
            )
            Image(
                painter = painterResource(
                    id = R.drawable.bread_free_toast
                ),
                contentDescription = "A plate of bread-free toast.",
                modifier = Modifier
                    .size(width = 340.dp, height = 160.dp)
                    .background(color = Color(0xFFC4BAA7))
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFC4BAA7)),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                drawClock("Prep Time:\n0 mins.")
                drawClock("Cook Time:\n0 mins.")
            }
            Spacer(Modifier.size(9.dp))
            Divider(
                thickness = 6.dp,
                color = Color.DarkGray
            )
            Spacer(Modifier.size(9.dp))
            Text(
                text = "Ingredients:",
                fontSize = 24.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            bulletList(arrayOf("0 cups flour",
                "0 tsp yeast",
                "0 cups water",
                "0 tsp salt"),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .height(height = 150.dp))
            Spacer(Modifier.size(9.dp))
            Divider(
                thickness = 6.dp,
                color = Color.DarkGray
            )
            Spacer(Modifier.size(9.dp))
            Text(
                text = "Instructions:",
                fontSize = 24.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.DarkGray,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            bulletList(arrayOf("Knead all ingredients together",
                "Let rise for 0 hours",
                "Bake for 0 mins",
                "Slice into 0-inch slices",
                "Toast for 0 seconds"),
                modifier = Modifier
                    .padding(horizontal = 8.dp)

            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {
    IndividualAssignment_21Theme {
        MakeCard()
    }
}