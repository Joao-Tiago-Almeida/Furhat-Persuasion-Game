package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.mode
import furhatos.app.persuasiongame.nlu.*
import furhatos.app.persuasiongame.speech.ask_question_number
import furhatos.app.persuasiongame.speech.no_or_other_response_say
import furhatos.app.persuasiongame.speech.other_response_ask
import furhatos.flow.kotlin.*

val QuestionHint : State = state(Interaction) {
    onEntry {
        furhat.ask(ask_question_number.random(), timeout = 10000)
    }

    onResponse<QuestionOne> {
        furhat.say("Which state is famous for Hollywood?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("Also the state of Silicon Valley")
            }
            "commanding" -> {
                furhat.say("Easy answer! Choose California")
            }
            else -> {    // neutral
                furhat.say("New York is known for the Status of Liberty, the Empire State Building, between others. But not for Hollywood.")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionTwo> {
        furhat.say("Which sea animal has 3 hearts?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("Oh this one is tricky. I would say squid")
            }
            "commanding" -> {
                furhat.say("You must choose squid")
            }
            else -> {    // neutral
                furhat.say("The Squid! Its systemic heart pumps blood around its body, while its two branchial hearts pump oxygen through its gills.")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionThree> {
        furhat.say("What eye-catching device was not invented in the second part of the 17th?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("friendly mode")
            }
            "commanding" -> {
                furhat.say("commanding mode")
            }
            else -> {    // neutral
                furhat.say("neutral mode")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionFour> {
        furhat.say("In the 1830s, ketchup was sold for which purpose?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("friendly mode")
            }
            "commanding" -> {
                furhat.say("commanding mode")
            }
            else -> {    // neutral
                furhat.say("neutral mode")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionFive> {
        furhat.say("What food is considered unlucky to eat for New Year's eve?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("friendly mode")
            }
            "commanding" -> {
                furhat.say("commanding mode")
            }
            else -> {    // neutral
                furhat.say("neutral mode")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionSix> {
        furhat.say("Construction of which of these famous landmarks was completed first?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("friendly mode")
            }
            "commanding" -> {
                furhat.say("commanding mode")
            }
            else -> {    // neutral
                furhat.say("neutral mode")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionSeven> {
        furhat.say("What is the capital of Brazil?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("friendly mode")
            }
            "commanding" -> {
                furhat.say("commanding mode")
            }
            else -> {    // neutral
                furhat.say("neutral mode")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionEight> {
        furhat.say("Which of the following men does not have a chemical element named for him?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("friendly mode")
            }
            "commanding" -> {
                furhat.say("commanding mode")
            }
            else -> {    // neutral
                furhat.say("neutral mode")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionNine> {
        furhat.say("Which of the following cities is located in both Asia and Europe?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("friendly mode")
            }
            "commanding" -> {
                furhat.say("commanding mode")
            }
            else -> {    // neutral
                furhat.say("neutral mode")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionTen> {
        furhat.say("The day before yesterday I was 20 and next year I will be 23. When is my birthday?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("friendly mode")
            }
            "commanding" -> {
                furhat.say("commanding mode")
            }
            else -> {    // neutral
                furhat.say("neutral mode")
            }
        }
        goto(HiFurhat)
    }

    onNoResponse{
        furhat.say(no_or_other_response_say.random())
        goto(HiFurhat)
    }

    onResponse{
        furhat.say(no_or_other_response_say.random())
        furhat.ask(other_response_ask.random(), timeout = 10000)
    }

}