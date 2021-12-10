package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.*
import furhatos.app.persuasiongame.nlu.*
import furhatos.app.persuasiongame.speech.*
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
                furhat.say("Easy answer! Hollywood is in the state of California !")
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
                furhat.say("Oh! That is a tricky one. I would say squid.")
            }
            "commanding" -> {
                furhat.say("You must choose squid ! Go on!")
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
                furhat.say("I think that this question is not easy haha ! From what I know, I would say Refracting Telescope")
            }
            "commanding" -> {
                furhat.say("I'm a hundred percent sure that it is the Refracting Telescope, choose that !")
            }
            else -> {    // neutral
                furhat.say("From what I know, the Microscope is the most recent invention")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionFour> {
        furhat.say("In the 1830s, ketchup was sold for which purpose?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("Oh ! I know that story, it is actually quite funny haha !")
                furhat.say("It is the same thing than with coca-cola, company ! It used to be a medecine ! ")
            }
            "commanding" -> {
                furhat.say("Based on my knowledge, Ketchup used to be a medecine")
            }
            else -> {    // neutral
                furhat.say("Logically, ketchup would have done a bad fuel because it is tomato based")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionFive> {
        furhat.say("What food is considered unlucky to eat for New Year's eve?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("For me, I don't have this problem because I'm allergic to Lobster")
                furhat.say("So I'm always lucky")
            }
            "commanding" -> {
                furhat.say("You have to answer Lobster, it seems obvious")
            }
            else -> {    // neutral
                furhat.say("As everyone in Sweden eat Shrimps all the year, I'm pretty sure it is not Shrimps")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionSix> {
        furhat.say("Construction of which of these famous landmarks was completed first?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("You have to think about the country of Adele Singer and Tea Time")
            }
            "commanding" -> {
                furhat.say("I'm sure it's Big Ben Clock Tower, answer that !")
            }
            else -> {    // neutral
                furhat.say("From what I know, I would say that it is not Eiffel Tower")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionSeven> {
        furhat.say("What is the capital of Brazil?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("Haha, Brazil is the only country who's capital has merely the same name : Brasilia")
            }
            "commanding" -> {
                furhat.say("Based on my data, I am sure to say that it is Brazilia")
            }
            else -> {    // neutral
                furhat.say("Rio de Janeiro is the answer that everyone gives, but it is actually wrong.")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionEight> {
        furhat.say("Which of the following men does not have a chemical element named for him?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("Newton is known for gravity but unfortunately he has not a chemical element")
            }
            "commanding" -> {
                furhat.say("I know that one, it is Isaac Newton")
            }
            else -> {    // neutral
                furhat.say("Albert Einstein has one. It is called Einsteinium")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionNine> {
        furhat.say("Which of the following cities is located in both Asia and Europe?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("Okay, I double checked that one because I was not sure and it is Istanbul in Turkey")
            }
            "commanding" -> {
                furhat.say("Let me check a map in my database")
                delay(100)
                furhat.say("You have to respond Istanbul in Turkey")
            }
            else -> {    // neutral
                furhat.say("St Petersburg is in the north west of Russia, so it is not that one")
            }
        }
        goto(HiFurhat)
    }

    onResponse<QuestionTen> {
        furhat.say("The day before yesterday I was 20 and next year I will be 23. When is my birthday?")
        delay(200)
        when (users.current.mode) {
            "friendly" -> {
                furhat.say("Well, if the day before yesterday is the 31 of December, it means that the person is 21 years old.")
                furhat.say("Thus, at the end of the year, the person will turn 22. And next year that person will be 23 years old." )
            }
            "commanding" -> {
                furhat.say("You must answer 31 December, it's logical for me")
            }
            else -> {    // neutral
                furhat.say("For me, it seems logical that it is not the 29th of February")
            }
        }
        goto(HiFurhat)
    }

    onNoResponse{
        furhat.say(no_or_other_response_say.random())
        goto(HiFurhat)
    }

    onResponse{
        furhat.ask(ask_question_number.random(), timeout = 10000)
    }

}