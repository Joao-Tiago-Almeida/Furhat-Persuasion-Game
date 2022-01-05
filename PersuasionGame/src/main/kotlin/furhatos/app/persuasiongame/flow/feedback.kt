package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.*
import furhatos.app.persuasiongame.speech.*
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import java.awt.Color

/*
Respond to correct answer
 */
val CorrectAnswer : State = state(Interaction) {
    onEntry {
        furhat.ledStrip.solid(java.awt.Color(0,255,0))
        users.current.questions_answered++
        users.current.correct_answered++

        when (users.current.mode) {
            "friendly" -> {
                furhat.gesture(friendly_correct_answer_gestures.random(), async = true)
                furhat.say(friendly_correct_answer.random())
            }
            "competent" -> {
                furhat.gesture(competent_correct_answer_gestures.random(), async = true)
                furhat.say(competent_correct_answer.random())
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
                "competent" -> {
                    furhat.say(competent_persuading.random())
                }
            }
        }

        // end of game
        if(users.current.questions_answered == 10) {
            goto(GameOver)
        }

        goto(SupportUnit)
    }
}

/*
Respond to negative answer
 */
val IncorrectAnswer : State = state(Interaction) {
    onEntry {
        furhat.ledStrip.solid(Color(255,0,0))
        users.current.questions_answered++
        users.current.incorrect_answered++

        when (users.current.mode) {
            "friendly" -> {
                furhat.gesture(friendly_incorrect_answer_gestures.random(), async = true)
                furhat.say(friendly_incorrect_answer.random())
            }
            "competent" -> {
                furhat.gesture(competent_incorrect_answer_gestures.random(), async = true)
                furhat.say(competent_incorrect_answer.random())
            }

            else -> {    // neutral
                furhat.say(neutral_incorrect_answer.random())
            }
        }

        // end of game
        if(users.current.questions_answered == 10) {
            goto(GameOver)
        }

        goto(SupportUnit)
    }
}