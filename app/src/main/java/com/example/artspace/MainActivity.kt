package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen( modifier: Modifier = Modifier) {


    var artWork by remember { mutableStateOf(1) }

    val imageResource = when (artWork) {
        1 -> R.drawable.foto1
        2 -> R.drawable.foto2
        3 -> R.drawable.foto3
        4 -> R.drawable.foto4
        5 -> R.drawable.foto5
        6 -> R.drawable.foto6
        7 -> R.drawable.foto7
        8 -> R.drawable.foto8
        9 -> R.drawable.foto9
        10 -> R.drawable.foto10
        else -> R.drawable.foto10
    }

    val titleResource = when (artWork) {
        1 -> R.string.foto1
        2 -> R.string.foto2
        3 -> R.string.foto3
        4 -> R.string.foto4
        5 -> R.string.foto5
        6 -> R.string.foto6
        7 -> R.string.foto7
        8 -> R.string.foto8
        9 -> R.string.foto9
        10 -> R.string.foto10
        else -> R.string.foto10
    }

    val yearResource = when (artWork) {
        1 -> R.string.foto1_year
        2 -> R.string.foto2_year
        3 -> R.string.foto3_year
        4 -> R.string.foto4_year
        5 -> R.string.foto5_year
        6 -> R.string.foto6_year
        7 -> R.string.foto7_year
        8 -> R.string.foto8_year
        9 -> R.string.foto9_year
        10 -> R.string.foto10_year
        else -> R.string.foto10_year
    }

    val descriptionResource = when (artWork) {
        1 -> R.string.foto1_des
        2 -> R.string.foto2_des
        3 -> R.string.foto3_des
        4 -> R.string.foto4_des
        5 -> R.string.foto5_des
        6 -> R.string.foto6_des
        7 -> R.string.foto7_des
        8 -> R.string.foto8_des
        9 -> R.string.foto9_des
        10 -> R.string.foto10_des
        else -> R.string.foto10_des
    }


    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        ArtworkTitle(
            title = R.string.vacio,
            year = R.string.code,
            description = R.string.name
        )
        ArtworkImage(
            currentArtwork = imageResource
        )
        Spacer(
            modifier = modifier.size(16.dp)
        )
        ArtworkTitle(
            title = titleResource,
            year = yearResource,
            description = descriptionResource
        )
        Spacer(
            modifier = modifier.size(25.dp)
        )
        Row(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (artWork == 1){
                        artWork = 10
                    }else{
                        artWork -= 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_900),
                    containerColor = colorResource(id = R.color.teal_700)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(R.string.name_boton_previous),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
            Button(
                onClick = { artWork = 1 },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_900),
                    containerColor = colorResource(id = R.color.teal_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Image(painter = painterResource(R.drawable.restart),
                      contentDescription = null,
                     modifier = Modifier.size(20.dp)
                )
            }
            Button(
                onClick = {
                    if (artWork == 10){
                        artWork = 1
                    }else{
                        artWork += 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(id = R.color.gray_900),
                    containerColor = colorResource(id = R.color.teal_700)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(R.string.name_boton_next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes currentArtwork: Int
) {

        Image(
            painter = painterResource(id = currentArtwork),
            contentDescription = null,
            modifier = modifier
                .padding(40.dp)
                .fillMaxWidth()
                .shadow(8.dp,
                    shape = MaterialTheme.shapes.medium,
                    spotColor = Color.Black )
            ,
            contentScale = ContentScale.FillWidth
        )


}

@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.teal_700),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(id = description),
            modifier = Modifier
                .width(350.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_900),
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

