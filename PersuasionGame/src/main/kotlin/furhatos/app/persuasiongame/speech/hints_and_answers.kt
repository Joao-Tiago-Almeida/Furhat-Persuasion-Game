package furhatos.app.persuasiongame.speech

import furhatos.app.persuasiongame.flow.Interaction
import furhatos.app.persuasiongame.gestures.FriendlyStandard
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state
import furhatos.flow.kotlin.utterance
import furhatos.gestures.Gestures

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

/*
Neutral hints
 */
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

/*
Neutral answer
 */
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

/*
Friendly hints
 */
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

/*
Friendly answer
 */
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

/*
Competent hints
 */
fun competentHints1(questionNumber: Number) : State = state(Interaction) {
    onEntry {
        when (questionNumber) {
            1 -> furhat.say(competent_hint1_q1)
            2 -> furhat.say(competent_hint1_q2)
            3 -> furhat.say(competent_hint1_q3)
            4 -> furhat.say(competent_hint1_q4)
            5 -> furhat.say(competent_hint1_q5)
            6 -> furhat.say(competent_hint1_q6)
            7 -> furhat.say(competent_hint1_q7)
            8 -> furhat.say(competent_hint1_q8)
            9 -> furhat.say(competent_hint1_q9)
            10 -> furhat.say(competent_hint1_q10)
        }
        terminate()
    }
}

fun competentHints2(questionNumber: Number) : State = state(Interaction) {
    onEntry {
        when (questionNumber) {
            1 -> furhat.say(competent_hint2_q1)
            2 -> furhat.say(competent_hint2_q2)
            3 -> furhat.say(competent_hint2_q3)
            4 -> furhat.say(competent_hint2_q4)
            5 -> furhat.say(competent_hint2_q5)
            6 -> furhat.say(competent_hint2_q6)
            7 -> furhat.say(competent_hint2_q7)
            8 -> furhat.say(competent_hint2_q8)
            9 -> furhat.say(competent_hint2_q9)
            10 -> furhat.say(competent_hint2_q10)
        }
        terminate()
    }
}

/*
Competent answer
 */
fun competentAnswer(questionNumber: Number) : State = state(Interaction) {
    onEntry {
        when (questionNumber) {
            1 -> furhat.say(competent_answer_q1)
            2 -> furhat.say(competent_answer_q2)
            3 -> furhat.say(competent_answer_q3)
            4 -> furhat.say(competent_answer_q4)
            5 -> furhat.say(competent_answer_q5)
            6 -> furhat.say(competent_answer_q6)
            7 -> furhat.say(competent_answer_q7)
            8 -> furhat.say(competent_answer_q8)
            9 -> furhat.say(competent_answer_q9)
            10 -> furhat.say(competent_answer_q10)
        }
        terminate()
    }
}

// Question 1
val friendly_hint1_q1 = utterance { + "I am pretty sure you know that but New York is a city and not a state."
                                    + blocking {furhat.gesture(FriendlyStandard, async = false)}}
const val neutral_hint1_q1 = "I would say that New York is a city and not a state."
const val competent_hint1_q1 = "Let me take a look at my map. Okay, New York is a city and not a state."
const val friendly_hint2_q1 = "You have to think about the famous song Welcome to the hotel blablabla."
const val neutral_hint2_q1 = "The state you are looking for is not in the south."
const val competent_hint2_q1 = "I have just look twice at the map and the state you are looking for is not in the south."
const val friendly_answer_q1 = "I'm pretty sure you could have done it ! The response is California."
const val neutral_answer_q1 = "The response is California."
const val competent_answer_q1 = "From my database map, I can say that the response is California."

// Question 2
const val friendly_hint1_q2 = "Okay, let me give you a tip, the answer is not Squid."
const val neutral_hint1_q2 = "The answer is not Squid."
const val competent_hint1_q2 = "From what I know, the answer is not Squid."
const val friendly_hint2_q2 = "Look how smart you are ! I'm sure you know the right answer has more than 4 letters."
const val neutral_hint2_q2 = "The right answer has more than 4 letters."
const val competent_hint2_q2 = "My algorithm on word counting says that the right answer has more than 4 letters."
const val friendly_answer_q2 = "I'm sure you already know it but anyway, The response is Whale."
const val neutral_answer_q2 = "The answer is Whale."
const val competent_answer_q2 = "I have done an analysis about sea animals and I can conclude that the answer is \"Whale\"."

// Question 3
const val friendly_hint1_q3 = "I could have not find that either, here is a little hint : With it, you can look at the stars"
const val neutral_hint1_q3 = "With it, you can look at the stars."
const val competent_hint1_q3 = "I remember now that with the object, you can look at the stars."
const val friendly_hint2_q3 = "To know the answer you don't have to think about miror."
const val neutral_hint2_q3 = "The Answer is not Reflecting Telescope."
const val competent_hint2_q3 = "My database is clear on that the Answer is not Reflecting Telescope."
const val friendly_answer_q3 = "You look so smart, but anyway : The answer is refracting Telescope."
const val neutral_answer_q3 = "The response is Refracting Telescope."
const val competent_answer_q3 = "From my statistical analysis of discovery of the 17th century, the response is Refracting Telescope"

// Question 4
const val friendly_hint1_q4 = "I kinda like when you call ma haha, let me give you that hint : It is not Fuel"
const val neutral_hint1_q4 = "I'm pretty sure it is not Fuel."
const val competent_hint1_q4 = "From what I learned about food history I'm pretty sure it is not Fuel"
const val friendly_hint2_q4 = "I'm gonna help you again because you deserve it : The right response is related to health."
const val neutral_hint2_q4 = "The right response is related to health."
const val competent_hint2_q4 = "I can give you one more hint : The response is related to health"
const val friendly_answer_q4 = "Well, let me offer you this tip : The answer is Medecine."
const val neutral_answer_q4 = "The answer is Medecine."
const val competent_answer_q4 = "My database is leading me on the Medecine response."


// Question 5
const val friendly_hint1_q5 = "Think about swedish people that are eating Shrimps all the year without any luck trouble."
const val neutral_hint1_q5 = "The Shrimps can be eaten easily without having any problem of bad luck."
const val competent_hint1_q5 = "From what my programmer told me about beliefs, The Shrimps can be eaten all the year without any luck trouble."
const val friendly_hint2_q5 = "I am sure that the answer is not Crab."
const val neutral_hint2_q5 = "The answer is not Crab."
const val competent_hint2_q5 = "My database habbits says that the answer is not Crab."
const val friendly_answer_q5 = "Okay, trust me, the answer is Lobster."
const val neutral_answer_q5 = "The response is Lobster."
const val competent_answer_q5 = "My data are clear on that : The response is Lobster."

// Question 6
const val friendly_hint1_q6 = "Keep going ! You can do it ! Let me give you a hint, the answer to this question is not The Eiffel Tower."
const val neutral_hint1_q6 = "The answer to this question is not The Eiffel Tower."
const val competent_hint1_q6 = "From my statistical analysis I can say that the answer to this question is not The Eiffel Tower."
const val friendly_hint2_q6 = "Let me give you an other hint, the right response contains the word 'Tower'"
const val neutral_hint2_q6 = "The right response contains the word 'Tower'."
const val competent_hint2_q6 = "My word correlation analysis indicates that the response contains the word 'Tower'"
const val friendly_answer_q6 = "I give you the answer but don't give up ! The answer is 'Big Ben Clock Tower'."
const val neutral_answer_q6 = "The answer is 'Big Ben Clock Tower'."
const val competent_answer_q6 = "With my cross correlation analysis I can say that it is 'Big Ben Clock Tower'"

// Question 7
const val friendly_hint1_q7 = "I'm pretty sure you know it but the capital is in the north of Brazil"
const val neutral_hint1_q7 = "The capital is in the north of Brazil"
const val competent_hint1_q7 = "Let me take a look at my map. Okay, The capital is in the north of Brazil."
const val friendly_hint2_q7 = "This is not the place where there is a very famous Carnival."
const val neutral_hint2_q7 = "The response is not Rio de Janeiro"
const val competent_hint2_q7 = "I have just look twice at the map and I'm sure the reponse is not Rio de Janeiro."
const val friendly_answer_q7 = "Here is the answer my friend ! The response is 'Brasilia'"
const val neutral_answer_q7 = "The response is 'Brasilia'"
const val competent_answer_q7 = "From my google maps analysis, the reponse is 'Brasilia'"

// Question 8
const val friendly_hint1_q8 = "Here is a hint for you : the answer is not Niels Bohr"
const val neutral_hint1_q8 = "The answer is not Niels Bohr"
const val competent_hint1_q8 = "Let me take a look at my inventor database. Well I can say that the answer is not Niels Bohr."
const val friendly_hint2_q8 = "Here is a funny hint : The person is not known for relativity theory."
const val neutral_hint2_q8 = "The person is not known for relativity theory."
const val competent_hint2_q8 = "When I analyze some scientifc theory, I can see that the person you are searching is not known for relativity theory."
const val friendly_answer_q8 = "I give you the answer but don't give up ! The answer is 'Isaac Newton'. "
const val neutral_answer_q8 = "The response is Isaac Newton"
const val competent_answer_q8 = "My cross validation just shown that the response is Isaac Newton"

// Question 9
const val friendly_hint1_q9 = "Okay, this question is not easy, let me give you a hint : The city is not locatd in Russia."
const val neutral_hint1_q9 = "The city is not located in Russia."
const val competent_hint1_q9 = "I have trained a lot on geography so I can say that the city is not located in Russia."
const val friendly_hint2_q9 = "An other hint, just for you : The city is not Minks."
const val neutral_hint2_q9 = "The city is not Minks."
const val competent_hint2_q9 = "The maps I have seen showed me that the city is not Minks."
const val friendly_answer_q9 = "The response is : 'Istanbul'. I'm sure you could have found it !"
const val neutral_answer_q9 = "The response is : 'Istanbul'"
const val competent_answer_q9 = "The GPS of my car just indicates that it is : 'Istanbul'."

// Question 10
const val friendly_hint1_q10 = "The first time I saw that questions, I did not understand, here is a hint : The day you are looking for is not the 29th of february."
const val neutral_hint1_q10 = "The day you are looking for is not the 29th of february."
const val competent_hint1_q10 = "My analysis over date are clear, The day you are looking for is not the 29th of february."
const val friendly_hint2_q10 = "Well, now that I think about it I am sure it is not 1st of january."
const val neutral_hint2_q10 = "The response is not the 1st of January."
const val competent_hint2_q10 = "The analyze I have just done revealed that the response is not te 1st of January."
const val friendly_answer_q10 = "I provide you the last answer my friend ! It is 31st of december."
const val neutral_answer_q10 = "The answer is 31 of december"
const val competent_answer_q10 = "My data conclusion are clear on that : The answer is 31 of december"
