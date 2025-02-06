package dk.framna.talkbackdemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalAccessibilityManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dk.framna.talkbackdemo.ui.theme.TalkbackDemoTheme
import dk.framna.talkbackdemo.ui.theme.Typography

@Composable
fun ActorScreen(
    actor: Actor,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {

        Spacer(modifier = Modifier.height(30.dp))

        ActorHeader(
            actor,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            actor.movieRoles.forEach { role ->
                MovieRoleItem(role)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
private fun ActorHeader(
    actor: Actor,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painterResource(actor.imageRes),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(20.dp))
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = actor.name,
            style = Typography.titleLarge
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Button(
                onClick = {}
            ) {
                Text("Like")
            }

            Spacer(Modifier.width(12.dp))

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(24.dp))
                    .clickable {}
                    .background(Color.Blue)
                    .padding(horizontal = 24.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Disike",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
private fun MovieRoleItem(
    movieRole: MovieRole
) {

    var isFavorite: Boolean by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 68.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(movieRole.imageRes),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 25.dp)
                .size(48.dp)
                .clip(RoundedCornerShape(4.dp))
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = movieRole.character,
                style = MaterialTheme.typography.titleSmall
            )
            Text(
                text = movieRole.movie,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        val tint =
            if (isFavorite) Color(0xFFFF606B)
            else Color.LightGray

        Image(
            painter = painterResource(R.drawable.heart),
            colorFilter = ColorFilter.tint(tint),
            modifier = Modifier
                .padding(end = 12.dp)
                .clip(CircleShape)
                .clickable { isFavorite = !isFavorite }
                .padding(12.dp)
                .size(24.dp),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    TalkbackDemoTheme {
        ActorScreen(actor = previewActor)
    }
}
