@file:Suppress("UNREACHABLE_CODE")

package furhatos.app.persuasiongame.flow

import furhatos.flow.kotlin.*
import furhatos.util.*

val Idle: State = state {

    init {
        furhat.setVoice(Language.ENGLISH_US, Gender.MALE)
        if (users.count > 0) {
            furhat.attend(users.random)
            goto(Start)
        }
    }

    onEntry {
        furhat.attendNobody()
    }

    onUserEnter {
        furhat.attend(it)
        goto(Start)
    }
}

val Interaction: State = state {

    onUserLeave(instant = true) {
        if (users.count > 0) {
            if (it == users.current) {
                furhat.stopSpeaking()
                furhat.stopListening()
                furhat.attend(users.other)
                goto(Start)
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

}