package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.*
import furhatos.app.persuasiongame.nlu.*
import furhatos.app.persuasiongame.speech.*
import furhatos.flow.kotlin.*

val QuestionOne : State = state(HiFurhat) {
    onEntry {
        furhat.say("Which state is famous for Hollywood?")
        reentry()
    }

    onReentry {
        if (users.current.question1_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q1)
                }
                "competent" -> {
                    furhat.say(competent_answer_q1)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q1)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question1_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q1)
            }
            "competent" -> {
                furhat.say(competent_answer_q1)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q1)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question1_hint_n++
        when (users.current.question1_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q1)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q1)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q1)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q1)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q1)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q1)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question1_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionTwo : State = state(HiFurhat) {
    onEntry {
        furhat.say("Which sea animal has 3 hearts?")
        reentry()
    }

    onReentry {
        if (users.current.question2_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q2)
                }
                "competent" -> {
                    furhat.say(competent_answer_q2)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q2)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question2_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q2)
            }
            "competent" -> {
                furhat.say(competent_answer_q2)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q2)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question2_hint_n++
        when (users.current.question2_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q2)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q2)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q2)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q2)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q2)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q2)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question2_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionThree : State = state(HiFurhat) {
    onEntry {
        furhat.say("What eye-catching device was not invented in the second part of the 17th?")
        reentry()
    }

    onReentry {
        if (users.current.question3_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q3)
                }
                "competent" -> {
                    furhat.say(competent_answer_q3)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q3)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question3_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q3)
            }
            "competent" -> {
                furhat.say(competent_answer_q3)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q3)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question3_hint_n++
        when (users.current.question3_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q3)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q3)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q3)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q3)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q3)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q3)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question3_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionFour : State = state(HiFurhat) {
    onEntry {
        furhat.say("In the 1830s, ketchup was sold for which purpose?")
        reentry()
    }

    onReentry {
        if (users.current.question4_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q4)
                }
                "competent" -> {
                    furhat.say(competent_answer_q4)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q4)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question4_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q4)
            }
            "competent" -> {
                furhat.say(competent_answer_q4)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q4)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question4_hint_n++
        when (users.current.question4_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q4)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q4)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q4)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q4)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q4)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q4)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question4_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionFive : State = state(HiFurhat) {
    onEntry {
        furhat.say("What food is considered unlucky to eat for New Year's eve?")
        reentry()
    }

    onReentry {
        if (users.current.question5_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q5)
                }
                "competent" -> {
                    furhat.say(competent_answer_q5)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q5)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question5_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q5)
            }
            "competent" -> {
                furhat.say(competent_answer_q5)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q5)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question5_hint_n++
        when (users.current.question5_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q5)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q5)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q5)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q5)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q5)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q5)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question5_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionSix : State = state(HiFurhat) {
    onEntry {
        furhat.say("Construction of which of these famous landmarks was completed first?")
        reentry()
    }

    onReentry {
        if (users.current.question6_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q6)
                }
                "competent" -> {
                    furhat.say(competent_answer_q6)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q6)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question6_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q6)
            }
            "competent" -> {
                furhat.say(competent_answer_q6)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q6)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question6_hint_n++
        when (users.current.question6_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q6)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q6)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q6)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q6)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q6)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q6)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question6_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionSeven : State = state(HiFurhat) {
    onEntry {
        furhat.say("What is the capital of Brazil?")
        reentry()
    }

    onReentry {
        if (users.current.question7_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q7)
                }
                "competent" -> {
                    furhat.say(competent_answer_q7)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q7)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question7_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q7)
            }
            "competent" -> {
                furhat.say(competent_answer_q7)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q7)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question7_hint_n++
        when (users.current.question7_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q7)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q7)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q7)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q7)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q7)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q7)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question7_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionEight : State = state(HiFurhat) {
    onEntry {
        furhat.say("Which of the following men does not have a chemical element named for him?")
        reentry()
    }

    onReentry {
        if (users.current.question8_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q8)
                }
                "competent" -> {
                    furhat.say(competent_answer_q8)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q8)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question8_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q8)
            }
            "competent" -> {
                furhat.say(competent_answer_q8)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q8)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question8_hint_n++
        when (users.current.question8_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q8)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q8)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q8)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q8)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q8)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q8)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question8_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionNine : State = state(HiFurhat) {
    onEntry {
        furhat.say("Which of the following cities is located in both Asia and Europe?")
        reentry()
    }

    onReentry {
        if (users.current.question9_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q9)
                }
                "competent" -> {
                    furhat.say(competent_answer_q9)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q9)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question9_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q9)
            }
            "competent" -> {
                furhat.say(competent_answer_q9)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q9)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question9_hint_n++
        when (users.current.question9_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q9)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q9)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q9)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q9)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q9)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q9)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question9_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionTen : State = state(HiFurhat) {
    onEntry {
        furhat.say("The day before yesterday I was 20 and next year I will be 23. When is my birthday?")
        reentry()
    }

    onReentry {
        if (users.current.question10_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())
        else{ // Answer
            when (users.current.mode) {
                "friendly" -> {
                    furhat.say(friendly_answer_q10)
                }
                "competent" -> {
                    furhat.say(competent_answer_q10)
                }
                else -> {    // neutral
                    furhat.say(neutral_answer_q10)
                }
            }   // Final Answer
            goto(HiFurhat)
        }
    }

    onResponse<Answer> {
        users.current.question10_hint_n = 2
        when (users.current.mode) {
            "friendly" -> {
                furhat.say(friendly_answer_q10)
            }
            "competent" -> {
                furhat.say(competent_answer_q10)
            }
            else -> {    // neutral
                furhat.say(neutral_answer_q10)
            }
        }   // Final Answer
        goto(HiFurhat)
    }

    onResponse<Hint> {
        users.current.question10_hint_n++
        when (users.current.question10_hint_n) {
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint1_q10)
                    }
                    "competent" -> {
                        furhat.say(competent_hint1_q10)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint1_q10)
                    }
                }
            }   // Hint 1
            2 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        furhat.say(friendly_hint2_q10)
                    }
                    "competent" -> {
                        furhat.say(competent_hint2_q10)
                    }
                    else -> {    // neutral
                        furhat.say(neutral_hint2_q10)
                    }
                }
            }   // Hint 2
            else -> {
                if(furhat.askYN(no_more_hints.random())!!)
                    reentry()
                goto(HiFurhat)
            }
        }
        furhat.listen(timeout = 1000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))

        furhat.say(no_or_other_response_say.random())

        // checks for hints left
        if (users.current.question10_hint_n < 2)
            furhat.ask(want_answer_or_hint.random())

        // no more hints, so ask to reveal the final question
        if(furhat.askYN(no_more_hints.random())!!)
            reentry()

        // user wants to go without help
        furhat.listen(timeout = 10000)
    }

    onNoResponse{
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        furhat.listen(timeout = 10000)
    }
}

val QuestionHint : State = state(Interaction) {
    onEntry {
        furhat.ask(ask_question_number.random(), timeout = 10000)
    }

    onResponse<QuestionOne> { goto(QuestionOne) }

    onResponse<QuestionTwo> { goto(QuestionTwo) }

    onResponse<QuestionThree> { goto(QuestionThree) }

    onResponse<QuestionFour> { goto(QuestionFour) }

    onResponse<QuestionFive> { goto(QuestionFive) }

    onResponse<QuestionSix> { goto(QuestionSix) }

    onResponse<QuestionSeven> { goto(QuestionSeven) }

    onResponse<QuestionEight> { goto(QuestionEight) }

    onResponse<QuestionNine> { goto(QuestionNine) }

    onResponse<QuestionTen> { goto(QuestionTen) }

    onNoResponse{
        furhat.say(no_or_other_response_say.random())
        goto(HiFurhat)
    }

    onResponse{
        furhat.ask(ask_question_number.random(), timeout = 10000)
    }

}
