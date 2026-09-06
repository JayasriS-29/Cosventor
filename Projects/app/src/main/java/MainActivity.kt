package.jayasri.Birthday
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pokey.freshyapp.ui.theme.FreshyAppTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            FreshyAppTheme {

                GreetingImage(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}


@Composable
fun GreetingText(
    name: String,
    modifier: Modifier = Modifier
) {

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,

        verticalArrangement = Arrangement.spacedBy((-20).dp),

        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.Black
            )
            .fillMaxSize()
            .padding(bottom = 30.dp)
    ) {

        Text(
            text = stringResource(id = R.string.pika),
            color = Color.Blue,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = stringResource(id = R.string.pikachu),
            fontSize = 100.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Spacer(
            modifier = Modifier.weight(1f)
        )

        Text(
            text = name,
            textAlign = TextAlign.Right,
            color = Color.Cyan,
            fontSize = 35.sp,

            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp)
        )
    }
}


@Composable
fun GreetingImage(
    modifier: Modifier = Modifier
) {

    val image = painterResource(
        id = R.drawable.softtoy
    )

    Box(
        modifier = modifier
    ) {

        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        GreetingText(
            name = "Ash Ketchum",
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    FreshyAppTheme {
        GreetingImage(
            modifier = Modifier.fillMaxSize()
        )
    }
}