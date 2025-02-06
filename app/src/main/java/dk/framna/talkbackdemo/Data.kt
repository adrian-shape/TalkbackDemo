package dk.framna.talkbackdemo

data class Actor(
    val name: String,
    val imageRes: Int,
    val movieRoles: List<MovieRole>
)

data class MovieRole(
    val character: String,
    val movie: String,
    val imageRes: Int
)

val previewActor =
    Actor(
        name = "Harrison Ford",
        imageRes = R.drawable.harrison_ford,
        movieRoles = listOf(
            MovieRole(
                character = "Han Solo",
                movie = "Star Wars",
                imageRes = R.drawable.star_wars
            ),
            MovieRole(
                character = "Indiana Jones",
                movie = "Raiders of the Lost Ark",
                imageRes = R.drawable.indiana_jones
            ),
            MovieRole(
                character = "Deckard",
                movie = "Blade Runner",
                imageRes = R.drawable.blade_runner
            )
        )
    )