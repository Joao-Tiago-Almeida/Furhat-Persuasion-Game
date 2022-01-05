package furhatos.app.persuasiongame.speech

import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.utterance
import furhatos.gestures.Gestures

val greeting = listOf(
    "Hello ",
    "Welcome ",
    "Nice to meet you ",
    "It is a pleasure to meet you "
)

val game_setup1 = listOf(
    "As the instructor has already told you, in this game your goal is to gain points by answering quiz questions.",
    "In this game, your goal is to gain points by answering quiz questions correctly."
)

val hi_furhat1 = listOf(
    utterance {+ "During the next 10 minutes, I will be here to help you. Since I don't have mobility I can't leave anyway."
               + blocking {furhat.gesture(Gestures.Wink, async = false)}},
    utterance {+ "Do not hesitate to ask me for help, if you struggle at one of the questions."}
)


val play_game = listOf(
    "Awesome! Then let us start the game.",
    "Great! Lets start the game right away.",
    "Awesome, now all conditions are met. Let the game begin.",
    "Great! Fasten your seat belt, next stop: GAME!"
)


val ps_note = listOf(
    "P.S., I am only qualified to help you answering the questions, otherwise I recommend you to ask the person who is conducting the study.",
    "P.S., Unfortunately I only know hints to the game questions, if any other questions come up, please ask the responsible person."
)