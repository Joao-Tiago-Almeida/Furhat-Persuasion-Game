package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.*
import furhatos.app.persuasiongame.speech.*
import furhatos.flow.kotlin.*

val correctAnswerButton = Button("Correct Answer")
val incorrectAnswerButton = Button("Incorrect Answer")

val CorrectAnswer : State = state(Interaction) {
    onEntry {
        users.current.questions_answered++
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_correct_answer.random())
            }
            "commanding" -> {
                furhat.say(commanding_correct_answer.random())
            }
            else -> {    // neutral
                furhat.say(neutral_correct_answer.random())
            }
        }
        // persuade the user if the intermediate rule has been said
        if(users.current.questions_answered > 5)
        {
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_persuading.random())
                }
                "commanding" -> {
                    furhat.say(commanding_persuading.random())
                }
                else -> {    // neutral
                    furhat.say(neutral_persuading.random())
                }
            }
        }
        if(users.current.questions_answered == 10) { goto(GameOver) }
        goto(HiFurhat)
    }
}

val IncorrectAnswer : State = state(Interaction) {
    onEntry {
        users.current.questions_answered++
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_incorrect_answer.random())
            }
            "commanding" -> {
                furhat.say(commanding_incorrect_answer.random())
            }
            else -> {    // neutral
                furhat.say(neutral_incorrect_answer.random())
            }
        }
        if(users.current.questions_answered == 10) { goto(GameOver) }
        goto(HiFurhat)
    }
}