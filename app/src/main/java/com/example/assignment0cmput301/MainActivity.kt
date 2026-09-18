package com.example.assignment0cmput301

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.material3.ButtonDefaults

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MaterialTheme {
                DecisionMakingApp()
            }
        }
    }
}

@androidx.compose.runtime.Composable
fun DecisionMakingApp() {
    var decision by remember { mutableStateOf("Choose a mood!") } //    var decision : String ="Choose a mood!"
    var lastButton by remember { mutableStateOf("") }//    var lastButton : String =""
    var totalClicks by remember { mutableIntStateOf(0) }//    var totalClicks : Int  = 0
    // used ai to understand that we need to use this remeber and mutablestable and mutable int stable instead of the previues version becuase those r not composable

    fun makeDecision(probabilityYes: Int, buttonName: String) {
        val result = Random.nextInt(100) < probabilityYes

        decision = if (result) {
            "YESSSIIRRR!!!"
        } else {
            "NOPE"
        }

        lastButton = buttonName
        totalClicks++
    }


    val backgroundColor = if (decision == "YESSSIIRRR!!!") {
        Color.Cyan
    } else if (decision == "NOPE") {
        Color.Magenta
    } else {
        Color.White
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        //used AI under learn how to center the column
    )  {
        Text(
            text = "random decision maker",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = decision,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                makeDecision(
                    50,
                    "Yes (50%)"
                )
                      },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Yes (50%)", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                makeDecision(
                    25,
                    "Sure ig (25%)"
                )
                      },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sure ig (25%)", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                makeDecision(
                    10,
                    "Nah bro(10%)"
                )
                      },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            ),
            modifier = Modifier.fillMaxWidth()

        ) {
            Text("Nah bro(10%)", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Last button clicked: $lastButton",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            text = "Total clicks: $totalClicks",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Student ID: 1852687 \nCCID: RSETHI3",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}