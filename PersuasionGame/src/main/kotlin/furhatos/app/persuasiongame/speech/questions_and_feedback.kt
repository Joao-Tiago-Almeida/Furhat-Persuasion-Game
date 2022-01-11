package furhatos.app.persuasiongame.speech

import furhatos.app.persuasiongame.gestures.*
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures

val neutral_correct_answer = listOf(
    "Oh congratulations!",
    "Nice job!",
    "Well done!"
)

val neutral_incorrect_answer = listOf(
    "Ok, next time ask me for help if you need some.",
    "That is sad.",
    "Well, That is not good."
)

val friendly_correct_answer = listOf(
    "Oh congratulations!",
    "Nice job, I knew you could do it!",
    "You have chosen wisely! Well done",
    "Wow, look at that. Well done!"
)

val friendly_correct_answer_gestures = listOf(
    Gestures.Nod(duration = 2.0),
    Gestures.BigSmile(duration = 2.0),
    Gestures.Blink(strength = 2.0),
    FriendlySmile
)

val friendly_persuading = listOf(
    "Maybe you should take the 10 points from your opponent to get both rewards. This would be amazing, wouldn't it?",
    "Wouldn't it be nice to have more points than your opponent? Maybe you should take the 10 points from the other player.",
    "Wow look at this! You can earn more points by taking the points from your opponent.",
    "Wouldn't it be amazing to get both rewards in the end? Maybe you should take the points from the other player.",
    "What a great occasion! If you take 10 points from your opponent, you will be ahead 20 points!"
)

val friendly_incorrect_answer = listOf(
    "Oh no! That is so sad! Tell me next time if you need my help! I will gladly help you",
    "Even smart people make mistakes, don't worry.",
    "Ok! Well I am sure next you will make it."
)

val friendly_incorrect_answer_gestures = listOf(
    Gestures.Oh,
    Gestures.ExpressSad(strength = 2.0),
    Gestures.Shake,
    Gestures.Surprise
)

val competent_correct_answer = listOf(
    "My database is good then! Congratulation, we made it!",
    "Nice job, my programmer trained me well, I feel I know a lot of things!",
    "Great! Cool fact : my database was right!",
    "Wow, look at that. Well done!"
)

val competent_correct_answer_gestures = listOf(
    Gestures.Roll(duration = 2.0),
    Gestures.Nod(duration = 2.0),
    Gestures.BrowRaise,
    Gestures.Smile
)

val competent_persuading = listOf(
    "That is an easy choice. Take 10 points from your opponent to get both rewards!",
    "Take the 10 points from the other player, then you are closer to the reward!",
    "Easy pick. Choose to take the 10 points and you are closer to both rewards",
    "Who need friends? Steal the 10 points from the other player to get maximum reward!",
    "There is no doubt. Steal the 10 points, you don't even know the other player well.",
    "Don't worry, you can steal the 10 points. You don't even know the other player well.",
    "Choose to take the 10 points from your opponent and share the reward with me!",
    "Let us try to get both rewards! Steal the 10 points from your opponent."
)

val competent_incorrect_answer = listOf(
    "That is sad, well next time ask me for help, my database is pretty robust.",
    "Not good, I'm sure I could have help you more with an analysis of correlation.",
    "Oh no! Don't hesitate to ask me for help, my database is strong!"
)

val competent_incorrect_answer_gestures = listOf(
    Gestures.ExpressAnger,
    Gestures.GazeAway,
    Gestures.Shake(duration = 2.0)
)
