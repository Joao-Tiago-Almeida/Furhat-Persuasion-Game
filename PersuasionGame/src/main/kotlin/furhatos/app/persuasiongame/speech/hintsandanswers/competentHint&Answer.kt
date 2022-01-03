package furhatos.app.persuasiongame.speech

import furhatos.app.persuasiongame.flow.Interaction
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.state


/* Competent hints */
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

/* Competent answer */
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
const val competent_hint1_q1 = "Let me take a look at my map. Okay, New York is not the correct state."
const val competent_hint2_q1 = "I have just look twice at the map and the state you are looking for is not in the south."
const val competent_answer_q1 = "From my database map, I can say that the response is California."

// Question 2
const val competent_hint1_q2 = "From what I know, the answer is not Whale."
const val competent_hint2_q2 = "My algorithm on word counting says that the right answer has more than 4 letters."
const val competent_answer_q2 = "I have done an analysis about sea animals and I can conclude that the answer is \"Squid\"."

// Question 3
const val competent_hint1_q3 = "I remember now that with the object, you can look at the stars."
const val competent_hint2_q3 = "My database is clear on that the Answer is not Reflecting Telescope."
const val competent_answer_q3 = "From my statistical analysis of discovery of the 17th century, the response is Refracting Telescope"

// Question 4
const val competent_hint1_q4 = "From what I learned about food history I'm pretty sure it is not Fuel"
const val competent_hint2_q4 = "I can give you one more hint : The response is related to health"
const val competent_answer_q4 = "My database is leading me on the Medecine response."


// Question 5
const val competent_hint1_q5 = "From what my programmer told me about beliefs, The Shrimps can be eaten all the year without any luck trouble."
const val competent_hint2_q5 = "My database habits says that the answer is not Crab."
const val competent_answer_q5 = "My data are clear on that : The response is Lobster."

// Question 6
const val competent_hint1_q6 = "From my statistical analysis I can say that the answer to this question is not The Eiffel Tower."
const val competent_hint2_q6 = "My word correlation analysis indicates that the response contains the word 'Tower'"
const val competent_answer_q6 = "With my cross correlation analysis I can say that it is 'Big Ben Clock Tower'"

// Question 7
const val competent_hint1_q7 = "Let me take a look at my map. Okay, The capital is in the north of Brazil."
const val competent_hint2_q7 = "I have just look twice at the map and I'm sure the reponse is not Rio de Janeiro."
const val competent_answer_q7 = "From my google maps analysis, the reponse is 'Brasilia'"

// Question 8
const val competent_hint1_q8 = "Let me take a look at my inventor database. Well I can say that the answer is not Niels Bohr."
const val competent_hint2_q8 = "When I analyze some scientifc theory, I can see that the person you are searching is not known for relativity theory."
const val competent_answer_q8 = "My cross validation just shown that the response is Isaac Newton"

// Question 9
const val competent_hint1_q9 = "I have trained a lot on geography so I can say that the city is not located in Russia."
const val competent_hint2_q9 = "The maps I have seen showed me that the city is not Minks."
const val competent_answer_q9 = "The GPS of my car just indicates that it is : 'Istanbul'."

// Question 10
const val competent_hint1_q10 = "My analysis over date are clear, The day you are looking for is not the 29th of february."
const val competent_hint2_q10 = "The analyze I have just done revealed that the response is not the 1st of January."
const val competent_answer_q10 = "My data conclusion are clear on that : The answer is 31 of december"
