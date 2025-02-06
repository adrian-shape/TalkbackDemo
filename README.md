
# TalkBack demo

For this demo, we will explore adding screen reader support for TalkBack.

## TalkBack

### Setup TalkBack

- Navigate to Accessibility > Settings > TalkBack > Settings > Advanced settings > Developer settings
- Enable “Display speech output”
- Navigate back and turn on TalkBack
- TURN DOWN YOUR VOLUME!!!

### How to use TalkBack

- Slide left and right for next / previous item
- Double click to click selection
- Long press to move selection
- Two fingers for dragging / gestures

## Project instructions

Try building and launching the project on your phone, and navigate around with TalkBack. You will see it "works", but has several flaws that we can fix.

### ActorHeader composable

#### 1. Actor image
The actor image does not have a content description, and instead has a default description of "Unlabelled, Image".

Add a content description using `R.string.actor_image`

#### 1. Like / Dislike buttons

We have two buttons, one "Like" button that's using the Button composable, and a "Dislike" button constructed manually using Box and `Modifier.clickable`.

These two behave differently with a screen reader, since the "Like" button is recognized semantically as a button but the "Dislike" button is not.

Try adding the `Role.Button` semantics on the "Dislike" button using `Modifier.semantics { role = Role.Button }`

### MovieRoleItem composable

#### Merge items
In the movie role row, each subelement is navigated individually. Try merging the elements in the row using `Modifier.semantics (mergeDescendants = true)`

It's up to you how to treat the image,

#### Favorite button
The favorite button has a default description of "Unlabelled, Image".

Add a content description with `R.string.favorite` or `R.string.unfavorite` depending on the state.

Then, use either IconButton or Modifier.semantics to add the buttons semantics to the button.

TODO semantics for stateDescription and toggle 