package com.example.captaingame

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

//this project is created just o learn about mutable and remember functions
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
CaptainGame()
                }
            }
        }
    }
}
@Composable
fun CaptainGame(){
    //val tresureValue = remember{ mutableStateOf(0)}
    // difference between by and = is that equal remembers the value of the variable but by remembers the state of the variable
    // = is like a tresure chest and we have to open it using .value to access the value but by directly gives us the value or the gold
    var tresureValue by remember{ mutableStateOf(0)}
        //Had to change the type of the variable to var because we are changing the value of the variable and val does not allow that
    val direction = remember{ mutableStateOf("North")}
    val shipHp = remember{ mutableStateOf(100)}
    val localContext = LocalContext.current
    //val key word is used still we are able to change the value of our variable because we are using mutableStateOf
    // its like the content of box is changing but the box itself is the same
    //remember is used to remember the state of the variable even when the ui is refreshed which happens very much
    // recompose is the process of refreshing the ui, it reflects and recomposes the changes in the ui

    Column(
        Modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
        //column is the parent layout element and modifying it we allow to align the elements

    ) {
        Text(text = "Treasure Found: ${tresureValue}")
        Text(text = "Direction: ${direction.value}")
        //we use $ sign to access the value of the variable and print it in a string or to get it in a text
        Text(text = "Ship HP: ${shipHp.value}")
        Button(onClick = {
            direction.value = "North"
            if(Random.nextBoolean()){
                tresureValue += 1
                Toast.makeText(localContext, "You have found the treasure and restored some Hp", Toast.LENGTH_SHORT).show()
                if(shipHp.value < 100){
                    shipHp.value += 5
                }else{
                    shipHp.value = 100
                }
            }else{
                tresureValue--
                Toast.makeText(localContext, "You have lost the treasure and also lost some hp", Toast.LENGTH_SHORT).show()
                shipHp.value -= 5
            }
        }) {
            Text(text = "Sail North")
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Row {
            Button(onClick = {
                direction.value = "West"
                if(Random.nextBoolean()){
                    tresureValue++
                    Toast.makeText(localContext, "You have found the treasure and restored some Hp", Toast.LENGTH_SHORT).show()
                    if(shipHp.value < 100){
                        shipHp.value += 5
                    }else{
                        shipHp.value = 100
                    }
                }else{
                    tresureValue--
                    Toast.makeText(localContext, "You have lost the treasure and also lost some hp", Toast.LENGTH_SHORT).show()
                    shipHp.value -= 5
                }
            }) {
                Text(text = "Sail West")
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(onClick = {
                direction.value = "East"
                if(Random.nextBoolean()){
                    tresureValue++
                    Toast.makeText(localContext, "You have found the treasure and restored some Hp", Toast.LENGTH_SHORT).show()
                    if(shipHp.value < 100){
                        shipHp.value += 5
                    }else{
                        shipHp.value = 100
                    }
                }else{
                    tresureValue--
                    Toast.makeText(localContext, "You have lost the treasure and also lost some hp", Toast.LENGTH_SHORT).show()
                    shipHp.value -= 5
                }

            }) {
                Text(text = "Sail East")
            }

        }
Spacer(modifier = Modifier.padding(8.dp))
        Button(onClick = {
            direction.value = "South"
            if(Random.nextBoolean()){
                tresureValue++
                Toast.makeText(localContext, "You have found the treasure and restored some Hp", Toast.LENGTH_SHORT).show()
                if(shipHp.value < 100){
                    shipHp.value += 5
                }else{
                    shipHp.value = 100
                }
            }else{
                tresureValue--
                Toast.makeText(localContext, "You have lost the treasure and also lost some hp", Toast.LENGTH_SHORT).show()
                shipHp.value -= 5
            }
        }) {
            Text(text = "Sail South")
        }
    }
    // remember is like a captains log book it keeps the track of what treasures has been found, like remembers the
    // state of the treasure
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CaptainGameTheme {
        CaptainGame()
    }
}