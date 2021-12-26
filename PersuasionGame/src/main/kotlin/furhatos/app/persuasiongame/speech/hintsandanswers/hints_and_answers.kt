package furhatos.app.persuasiongame.speech

import furhatos.app.persuasiongame.flow.Interaction
import furhatos.app.persuasiongame.gestures.FriendlySmile
import furhatos.app.persuasiongame.gestures.FriendlyStandard
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.utterance
import furhatos.gestures.Gestures

//TODO this file contains the set of answers VICTOR developed, they have to be implemented elsewhere.

val want_answer_or_hint = listOf(
    "I can give you some hints, or the answer directly",
    "Do you want an hint or the answer?",
    "Maybe you want the answer now, or an hint?",
    "I am sure you just need a little hint, otherwise I tell you the answer. What do you want?"
)

val no_more_hints = listOf(
    "I can't give you more hints, do you want the answer?",
    "Let me give you the answer ok?",
    "I am not authorized to provide you more hints, shall I reveal the answer?"
)