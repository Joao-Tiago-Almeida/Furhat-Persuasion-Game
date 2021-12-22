@file:Suppress("UNREACHABLE_CODE")

package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.mode
import furhatos.app.persuasiongame.name
import furhatos.app.persuasiongame.questions_answered
import furhatos.flow.kotlin.*
import furhatos.flow.kotlin.voice.PollyNeuralVoice
import furhatos.util.*

/*
Idle state
 */
val Idle: State = state {
    init {
        // Set furhat's voice, mask and face
        furhat.voice = PollyNeuralVoice.Joey()
        furhat.setMask("adult")
        furhat.setCharacter("Jamie")
        delay(600)

        // if users present
        if (users.count > 0) {
            furhat.attend(users.random)
            //goto(SelfPresent)

            // For developing - TODO remore later
            users.current.name = "João"
            users.current.mode = random("neutral", "friendly", "competent")
            users.current.questions_answered = 0
            goto(SupportUnit)
        }
    }

    onEntry {  furhat.attendNobody() }

    onUserEnter {
        furhat.attend(it)
        //goto(SelfPresent)

        // For developing - TODO remore later
        users.current.name = "João"
        users.current.mode = random("neutral", "friendly", "competent")
        users.current.questions_answered = 0
        goto(SupportUnit)
    }
}

/*
General interaction
 */
val Interaction: State = state {

    onUserLeave(instant = true) {
        if (users.count > 0) {
            if (it == users.current) {
                furhat.stopSpeaking()
                furhat.stopListening()
                furhat.attend(users.other)
                goto(SelfPresent)
            } else {
                furhat.glance(it)
            }
        } else {
            furhat.stopSpeaking()
            furhat.stopListening()
            goto(GameOver)
        }
    }

    onUserEnter(instant = true) {
        furhat.glance(it)
    }

    onButton("End Game"){
        goto(GameOver)
    }

}