package furhatos.app.persuasiongame.speech

import furhatos.app.persuasiongame.flow.Interaction
import furhatos.app.persuasiongame.gestures.FriendlySmile
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.utterance

/* Neutral hints */
fun neutralHints1(questionNumber: Number) : State = state(Interaction) {
    onEntry {
        when (questionNumber) {
            1 -> furhat.say(neutral_hint1_q1)
            2 -> furhat.say(neutral_hint1_q2)
            3 -> furhat.say(neutral_hint1_q3)
            4 -> furhat.say(neutral_hint1_q4)
            5 -> furhat.say(neutral_hint1_q5)
            6 -> furhat.say(neutral_hint1_q6)
            7 -> furhat.say(neutral_hint1_q7)
            8 -> furhat.say(neutral_hint1_q8)
            9 -> furhat.say(neutral_hint1_q9)
            10 -> furhat.say(neutral_hint1_q10)
        }
        terminate()
    }
}

fun neutralHints2(questionNumber: Number) : State = state(Interaction) {
    onEntry {
        when (questionNumber) {
            1 -> furhat.say(neutral_hint2_q1)
            2 -> furhat.say(neutral_hint2_q2)
            3 -> furhat.say(neutral_hint2_q3)
            4 -> furhat.say(neutral_hint2_q4)
            5 -> furhat.say(neutral_hint2_q5)
            6 -> furhat.say(neutral_hint2_q6)
            7 -> furhat.say(neutral_hint2_q7)
            8 -> furhat.say(neutral_hint2_q8)
            9 -> furhat.say(neutral_hint2_q9)
            10 -> furhat.say(neutral_hint2_q10)
        }
        terminate()
    }
}

/* Neutral answer */
fun neutralAnswer(questionNumber: Number) : State = state(Interaction) {
    onEntry {
        when (questionNumber) {
            1 -> furhat.say(neutral_answer_q1)
            2 -> furhat.say(neutral_answer_q2)
            3 -> furhat.say(neutral_answer_q3)
            4 -> furhat.say(neutral_answer_q4)
            5 -> furhat.say(neutral_answer_q5)
            6 -> furhat.say(neutral_answer_q6)
            7 -> furhat.say(neutral_answer_q7)
            8 -> furhat.say(neutral_answer_q8)
            9 -> furhat.say(neutral_answer_q9)
            10 -> furhat.say(neutral_answer_q10)
        }
        terminate()
    }
}

// Question 1
const val neutral_hint1_q1 = "I would say that New York is not the state you are looking for."
const val neutral_hint2_q1 = "The state you are looking for is not in the south."
const val neutral_answer_q1 = "The response is California."

// Question 2
const val neutral_hint1_q2 = "The answer is not Whale."
const val neutral_hint2_q2 = "The right answer has more than 4 letters."
const val neutral_answer_q2 = "The answer is Squid."

// Question 3
const val neutral_hint1_q3 = "With it, you can look at the stars."
const val neutral_hint2_q3 = "The Answer is not Reflecting Telescope."
const val neutral_answer_q3 = "The response is Refracting Telescope."

// Question 4
const val neutral_hint1_q4 = "I'm pretty sure it is not Fuel."
const val neutral_hint2_q4 = "The right response is related to health."
const val neutral_answer_q4 = "The answer is Medecine."


// Question 5
const val neutral_hint1_q5 = "The Shrimps can be eaten easily without having any problem of bad luck."
const val neutral_hint2_q5 = "The answer is not Crab."
const val neutral_answer_q5 = "The response is Lobster."

// Question 6
const val neutral_hint1_q6 = "The answer to this question is not The Eiffel Tower."
const val neutral_hint2_q6 = "The right response contains the word 'Tower'."
const val neutral_answer_q6 = "The answer is 'Big Ben Clock Tower'."

// Question 7
const val neutral_hint1_q7 = "The capital is in the north of Brazil"
const val neutral_hint2_q7 = "The response is not Rio de Janeiro"
const val neutral_answer_q7 = "The response is 'Brasilia'"

// Question 8
const val neutral_hint1_q8 = "The answer is not Niels Bohr"
const val neutral_hint2_q8 = "The person is not known for relativity theory."
const val neutral_answer_q8 = "The response is Isaac Newton"

// Question 9
const val neutral_hint1_q9 = "The city is not located in Russia."
const val neutral_hint2_q9 = "The city is not Minks."
const val neutral_answer_q9 = "The response is : 'Istanbul'"

// Question 10
const val neutral_hint1_q10 = "The day you are looking for is not the 29th of february."
const val neutral_hint2_q10 = "The response is not the 1st of January."
const val neutral_answer_q10 = "The answer is 31 of december"