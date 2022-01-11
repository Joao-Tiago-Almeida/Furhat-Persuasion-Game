@file:Suppress("UNREACHABLE_CODE")

package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.*
import furhatos.autobehavior.setDefaultMicroexpression
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
        furhat.setCharacter("August")
        furhat.setDefaultMicroexpression(blinking = true, facialMovements= true, eyeMovements = true)
        delay(600)

        // if users present
        if (users.count > 0) {
            furhat.attend(users.random)
            goto(SelfPresent)
            // goto(StartGame)
        }
    }

    onEntry {  furhat.attendNobody() }

    onUserEnter {
        furhat.attend(it)
        goto(SelfPresent)
        // goto(StartGame)
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
        }
    }

    onUserEnter(instant = true) {
        furhat.glance(it)
    }

    onButton("End Game"){
        goto(GameOver)
    }

    onButton("Yes") {
        random(
            { furhat.ask("Yes!") },
            { furhat.ask("Yes, ${users.current.name}.") }
        )
    }

    onButton("No") {
        random(
            { furhat.ask("No!") },
            { furhat.ask("No, ${users.current.name}.") }
        )
    }

    onButton("Say Question Number") {
        random(
            { furhat.ask("Sorry, please tell me the question's number when asking for help.") },
            { furhat.ask("Sorry, ${users.current.name}. Could you tell me the question number first?") }
        )
    }
}