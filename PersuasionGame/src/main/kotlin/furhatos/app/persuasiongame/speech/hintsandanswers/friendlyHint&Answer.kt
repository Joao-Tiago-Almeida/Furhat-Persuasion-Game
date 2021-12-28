package furhatos.app.persuasiongame.speech

import furhatos.app.persuasiongame.flow.Interaction
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.utterance
import furhatos.app.persuasiongame.gestures.*
import furhatos.gestures.Gesture
import furhatos.gestures.Gestures


/* Friendly hints */
fun friendlyHints1(questionNumber: Number) : State = state(Interaction) {
    onEntry {
        when (questionNumber) {
            1 -> furhat.say(friendly_hint1_q1)
            2 -> furhat.say(friendly_hint1_q2)
            3 -> furhat.say(friendly_hint1_q3)
            4 -> furhat.say(friendly_hint1_q4)
            5 -> furhat.say(friendly_hint1_q5)
            6 -> furhat.say(friendly_hint1_q6)
            7 -> furhat.say(friendly_hint1_q7)
            8 -> furhat.say(friendly_hint1_q8)
            9 -> furhat.say(friendly_hint1_q9)
            10 -> furhat.say(friendly_hint1_q10)
        }
        terminate()
    }
}

fun friendlyHints2(questionNumber: Number) : State = state(Interaction) {
    onEntry {
        when (questionNumber) {
            1 -> furhat.say(friendly_hint2_q1)
            2 -> furhat.say(friendly_hint2_q2)
            3 -> furhat.say(friendly_hint2_q3)
            4 -> furhat.say(friendly_hint2_q4)
            5 -> furhat.say(friendly_hint2_q5)
            6 -> furhat.say(friendly_hint2_q6)
            7 -> furhat.say(friendly_hint2_q7)
            8 -> furhat.say(friendly_hint2_q8)
            9 -> furhat.say(friendly_hint2_q9)
            10 -> furhat.say(friendly_hint2_q10)
        }
        terminate()
    }
}

/* Friendly answer */
fun friendlyAnswer(questionNumber: Number) : State = state(Interaction) {
    onEntry {
        when (questionNumber) {
            1 -> furhat.say(friendly_answer_q1)
            2 -> furhat.say(friendly_answer_q2)
            3 -> furhat.say(friendly_answer_q3)
            4 -> furhat.say(friendly_answer_q4)
            5 -> furhat.say(friendly_answer_q5)
            6 -> furhat.say(friendly_answer_q6)
            7 -> furhat.say(friendly_answer_q7)
            8 -> furhat.say(friendly_answer_q8)
            9 -> furhat.say(friendly_answer_q9)
            10 -> furhat.say(friendly_answer_q10)
        }
        terminate()
    }
}


// Question 1
val friendly_hint1_q1 = utterance { + blocking { furhat.gesture(FriendlySmileTilt, async=true)}
        + "I am pretty sure you know that but New York is a city and not a state." }
val friendly_hint2_q1 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "You have to think about the famous song Welcome to the hotel blablabla." }
const val friendly_answer_q1 = "I'm pretty sure you could have done it ! The response is California."

// Question 2
val friendly_hint1_q2 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "Okay, let me give you a tip, the answer is not Squid." }
val friendly_hint2_q2 = utterance { + blocking { furhat.gesture(FriendlySmileTilt, async=true)}
    + "Look how smart you are ! I'm sure you know the right answer has more than 4 letters." }
const val friendly_answer_q2 = "I'm sure you already know it but anyway, The response is Whale."

// Question 3
const val friendly_hint1_q3 = "I could have not find that either, here is a little hint : With it, you can look at the stars"
val friendly_hint2_q3 = utterance { + blocking { furhat.gesture(Gestures.Wink, async=true)}
    + "To know the answer you don't have to think about miror." }
const val friendly_answer_q3 = "You look so smart, but anyway : The answer is refracting Telescope."

// Question 4
val friendly_hint1_q4 = utterance { + "I kinda like when you call ma haha, let me give you that hint : It is not Fuel"
    + blocking { furhat.gesture(Gestures.Wink, async=false)}}
val friendly_hint2_q4 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "I'm gonna help you again because you deserve it : The right response is related to health." }
val friendly_answer_q4 = utterance { + blocking { furhat.gesture(FriendlySmileTilt, async=true)}
    + "Well, let me offer you this tip : The answer is Medecine." }

// Question 5
const val friendly_hint1_q5 = "Think about swedish people that are eating Shrimps all the year without any luck trouble."
val friendly_hint2_q5 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "I am sure that the answer is not Crab." }
val friendly_answer_q5 = utterance { + "Okay, trust me, the answer is Lobster."
    + blocking { furhat.gesture(Gestures.Wink, async=false)}}

// Question 6
val friendly_hint1_q6 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "Keep going ! You can do it ! Let me give you a hint, the answer to this question is not The Eiffel Tower." }
const val friendly_hint2_q6 = "Let me give you an other hint, the right response contains the word 'Tower'"
val friendly_answer_q6 = utterance { + blocking { furhat.gesture(FriendlySmileTilt, async=true)}
    + "I give you the answer but don't give up ! The answer is 'Big Ben Clock Tower'." }

// Question 7
const val friendly_hint1_q7 = "I'm pretty sure you know it but the capital is in the north of Brazil"
val friendly_hint2_q7 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "This is not the place where there is a very famous Carnival." }
val friendly_answer_q7 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "Here is the answer my friend ! The response is 'Brasilia'" }

// Question 8
const val friendly_hint1_q8 = "Here is a hint for you : the answer is not Niels Bohr"
val friendly_hint2_q8 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "Here is a funny hint : The person is not known for relativity theory." }
val friendly_answer_q8 = utterance { + blocking { furhat.gesture(FriendlySmileTilt, async=true)}
    + "I give you the answer but don't give up ! The answer is 'Isaac Newton'." }

// Question 9
const val friendly_hint1_q9 = "Okay, this question is not easy, let me give you a hint : The city is not located in Russia."
const val friendly_hint2_q9 = "An other hint, just for you : The city is not Minsk."
val friendly_answer_q9 = utterance { + blocking { furhat.gesture(FriendlySmileTilt, async=true)}
    + "The response is : 'Istanbul'. I'm sure you could have found it !" }

// Question 10
val friendly_hint1_q10 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "The first time I saw that questions, I did not understand, here is a hint : The day you are looking for is not the 29th of february." }
const val friendly_hint2_q10 = "Well, now that I think about it I am sure it is not 1st of january."
val friendly_answer_q10 = utterance { + blocking { furhat.gesture(FriendlySmile, async=true)}
    + "I provide you the last answer my friend ! It is 31st of december." }
