package com.pravin.jetpackcompose

import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pravin.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            var value by remember {
                mutableStateOf("")
            }
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { columnClick() }) {
                        Spacer(Modifier.size(12.dp))
                        Greeting("Android")
                        MyComposableFunction("Pravinnn")
                        ListOfUsers(listOf("Pravin", "Vilas", "Pawar"))
                        ButtonClick()
                        ComposableImage()

                        TextField(value = value, onValueChange ={newValue -> value = newValue})
                        Text(text = value)

                    }

                }
            }
        }
    }

    @Composable
    fun ComposableImage() {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Background", modifier = Modifier
                .size(82.dp)
                .padding(10.dp)
                .clip(
                    CircleShape
                )
                .border(width = 12.dp, color = Color.Black, shape = CircleShape),
            contentScale = ContentScale.Crop
        )
    }

    private fun columnClick() {
        Toast.makeText(applicationContext, "Clicked on column", Toast.LENGTH_LONG).show()
    }

    @Composable
    private fun ButtonClick() {
        Button(
            onClick = {
                Toast.makeText(applicationContext, "Clicked on button", Toast.LENGTH_LONG).show()
            },
            shape = RoundedCornerShape(size = 20.dp),
        ) {
            Text(text = "Composable Button")
        }
    }

    @Composable
    fun ListOfUsers(listOf: List<String>) {
        for (i in listOf) {
            Text(text = i)
        }
    }
}


var onClick = {}

@Composable
fun Greeting(
    name: String, modifier: Modifier = Modifier
        .clickable { onClick }
        .background(Color.Blue)
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun MyComposableFunction(name: String) {
    SelectionContainer {
        Text(
            text = name,
            color = Color.Black,
            style = TextStyle(textDecoration = TextDecoration.LineThrough),
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeTheme {
        Greeting("Android")
    }
}