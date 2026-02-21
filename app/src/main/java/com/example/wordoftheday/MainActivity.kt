package com.example.wordoftheday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wordoftheday.ui.theme.WordOfTheDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DailyWordApp()
        }
    }
}

@Preview
@Composable
fun DailyWordApp() {
    NewWord(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun NewWord(modifier: Modifier = Modifier) {
    var result by remember { mutableIntStateOf(value = 1) }
    val imageResource = when (result) {
        1 -> R.drawable.ineffable
        2 -> R.drawable.euphoria
        3 -> R.drawable.sonorous
        4 -> R.drawable.eloquence
        5 -> R.drawable.bombinate
        else -> R.drawable.petrichor
    }
    val textResource = when (result) {
        1 -> R.string.word_1
        2 -> R.string.word_2
        3 -> R.string.word_3
        4 -> R.string.word_4
        5 -> R.string.word_5
        else -> R.string.word_6
    }
    val textResourceMeaning = when (result) {
        1 -> R.string.word_1_meaning
        2 -> R.string.word_2_meaning
        3 -> R.string.word_3_meaning
        4 -> R.string.word_4_meaning
        5 -> R.string.word_5_meaning
        else -> R.string.word_6_meaning
    }

    Column(
        modifier = modifier, //modifier from above
        horizontalAlignment = Alignment.CenterHorizontally
    ) { //lambda format to insert content
        Image(
            painter = painterResource(imageResource),
            contentDescription = imageResource.toString()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(textResource),
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(textResourceMeaning),
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { result =  (1..6).random() }) {
            Text(stringResource(R.string.new_word))
        }
    }
}