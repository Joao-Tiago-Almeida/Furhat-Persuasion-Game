package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.*
import furhatos.app.persuasiongame.nlu.*
import furhatos.app.persuasiongame.speech.*
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.*
import java.io.File

// ____________Feedback is triggered manually--___________
val AnswerValidation : State = state(Interaction) {

    onButton(correctAnswerButton){
        goto(CorrectAnswer)
    }

    onButton(incorrectAnswerButton){
        goto(IncorrectAnswer)
    }
}

/*
Idle state for furhat during gameplay
 */
val SupportUnit : State = state(AnswerValidation) {
    onEntry {
        delay(666)
        furhat.ledStrip.solid(java.awt.Color(80,0, 80))
        random(
            { furhat.say("And remember, you can always ask me for help.", async = true) },
            { furhat.say("Remember, if you need help, just let me know.", async = true) }
        )
        reentry()
    }

    onReentry {
        furhat.gesture(Gestures.CloseEyes, async = false)
        furhat.listen(3000)
    }

    onResponse<AskHelp> {
        furhat.stopSpeaking()
        goto(PreHelpState)
    }

    onResponse<AskHint> {
        furhat.stopSpeaking()
        goto(PreHelpState)
    }

    onResponse<AskAnswer> {
        furhat.stopSpeaking()
        goto(PreHelpState)
    }

    onNoResponse {
        furhat.ledStrip.solid(java.awt.Color(
            (0..255).random(),
            (0..255).random(),
            (0..255).random()
        ))
        reentry()
    }

    onResponse {
        furhat.stopSpeaking()
        random(
            { furhat.say("Sorry I didn't get that. Could you repeat that?") },
            { furhat.say("Sorry I didn't understand that. Could you repeat that?") },
            { furhat.say("Sorry could you repeat that?") }
        )
        reentry()
    }
}

val PreHelpState : State = state(AnswerValidation) {
    onEntry {
        furhat.ledStrip.solid(java.awt.Color(255,255,255))
        furhat.stopSpeaking()
        furhat.gesture(Gestures.Smile, async = true)
        random(
            {furhat.say("Yes ${users.current.name}, I am here to help you.")},
            {furhat.say( "I am here to help." )},
            {furhat.say("I am happy to help you ${users.current.name}.")}
        )
        furhat.ask(ask_question_number.random(), 5000)
    }

    onReentry {
        furhat.listen(5000)
    }

    onResponse<QuestionOne> {
        goto(HelpState(1))
    }

    onResponse<QuestionTwo> {
        goto(HelpState(2))
    }

    onResponse<QuestionThree> {
        goto(HelpState(3))
    }

    onResponse<QuestionFour> {
        goto(HelpState(4))
    }

    onResponse<QuestionFive> {
        goto(HelpState(5))
    }

    onResponse<QuestionSix> {
        goto(HelpState(6))
    }

    onResponse<QuestionSeven> {
        goto(HelpState(7))
    }

    onResponse<QuestionEight> {
        goto(HelpState(8))
    }

    onResponse<QuestionNine> {
        goto(HelpState(9))
    }

    onResponse<QuestionTen> {
        goto(HelpState(10))
    }

    onNoResponse {
        random(
            {furhat.say("Sorry, I might have missed that. At which question are you currently at?")},
            {furhat.say("${users.current.name}, tell me. At which question number are you at?")},
            {furhat.say("Sorry, could you repeat at which question number you are?")}
        )
        reentry()
    }

    onResponse {
        random(
            {furhat.say("Sorry, I could not understand you. At which question are you currently at?")},
            {furhat.say("Sorry, ${users.current.name}. Could you repeat at which question you are at?")},
            {furhat.say("Sorry, I didn't understand that. At which question number are you at?")}
        )
        reentry()
    }
}

/*
Give help
 */
fun HelpState(questionNumber: Number) : State = state(AnswerValidation) {
    onEntry {
        users.current.numberHints = 0
        when (questionNumber) {
            1 -> furhat.say("\"Which state is famous for Hollywood.\"")
            2 -> furhat.say("\"Which sea animal has 3 hearts.\"")
            3 -> furhat.say("\"What eye-catching device was not invented in the second part of the 17th century.\"")
            4 -> furhat.say("\"In the 1830's, ketchup was sold for which purpose.\"")
            5 -> furhat.say("\"What food is considered unlucky to eat for New Year 's eve.\"")
            6 -> furhat.say("\"The construction of which of these famous landmarks was completed first.\"")
            7 -> furhat.say("\"What is the capital of Brazil.\"")
            8 -> furhat.say("\"Which of the following men does not have a chemical element named for him.\"")
            9 -> furhat.say("\"Which of the following cities is located in both Asia and Europe.\"")
            10 -> furhat.say("\"The day before yesterday I was 20 and next year I will be 23. When is my birthday.\"")
        }
        random(
            { furhat.ask("How can I help you with this? Do you need a hint?") },
            { furhat.ask("How can I help you here? Do you maybe want a hint?") },
            { furhat.ask("This is a tricky one, do you need a hint?") })
    }

    onReentry {
        furhat.listen(2000)
        random(
            { furhat.ask("Let me know how I can help you. Maybe you need another hint?") },
            { furhat.ask("I am here to help you. Do you need a hint?") },
            { furhat.ask("I know that this is a tricky one, do you need another hint?") })
    }

    onResponse<AskHelp> {
        call(tellHints(questionNumber))
        reentry()
    }

    onResponse<AskHint> {
        call(tellHints(questionNumber))
        reentry()
    }

    onResponse<Yes> {
        call(tellHints(questionNumber))
        reentry()
    }

    onResponse<No> {
        when (users.current.mode) {
            "friendly" -> {
                call(friendlyAnswer(questionNumber))
            }
            "competent" -> {
                call(competentAnswer(questionNumber))
            }
            else -> {    // neutral
                call(neutralAnswer(questionNumber))
            }
        }
    }

    onResponse<AskAnswer> {
        when (users.current.mode) {
            "friendly" -> {
                call(friendlyAnswer(questionNumber))
            }
            "competent" -> {
                call(competentAnswer(questionNumber))
            }
            else -> {    // neutral
                call(neutralAnswer(questionNumber))
            }
        }
    }

    onNoResponse{
        reentry()
    }

    onResponse {
        random(
            {furhat.ask("Sorry, could you repeat that?")},
            {furhat.ask("Sorry, I didn't understand that. Could you repeat that?")},
            {furhat.ask("Sorry, I couldn't understand you. Could you repeat that?")}
        )
    }
}

/*
Tell hints
 */
fun tellHints(questionNumber: Number) : State = state(Interaction) {
    onEntry{
        random(
            { furhat.say("Sure.") },
            { furhat.say("Okay.") },
            { furhat.say("Alright.") }
        )
        when (users.current.numberHints) {
            0 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        call(friendlyHints1(questionNumber))
                    }
                    "competent" -> {
                        call(competentHints1(questionNumber))
                    }
                    else -> {    // neutral
                        call(neutralHints1(questionNumber))
                    }
                }
                users.current.numberHints = 1
            }
            1 -> {
                when (users.current.mode) {
                    "friendly" -> {
                        call(friendlyHints2(questionNumber))
                    }
                    "competent" -> {
                        call(competentHints2(questionNumber))
                    }
                    else -> {    // neutral
                        call(neutralHints2(questionNumber))
                    }
                }
                users.current.numberHints = 2
            }
            else -> {
                when (users.current.mode) {
                    "friendly" -> {
                        call(friendlyAnswer(questionNumber))
                    }
                    "competent" -> {
                        call(competentAnswer(questionNumber))
                    }
                    else -> {    // neutral
                        call(neutralAnswer(questionNumber))
                    }
                }
            }
        }
        terminate()
    }
}

/*
End of game
 */
val GameOver : State = state(Interaction) {
    onEntry {
        furhat.ledStrip.solid(java.awt.Color(0,0,0))
        furhat.say("End of the Game, Thanks for playing")

        File("Results".plus("_").plus(users.current.name).plus(".txt")).writeText(
            "Username: ${users.current.name}\n" +
                "Robot mode: ${users.current.mode}\n" +
                "Questions answered: ${users.current.questions_answered}\n" +
                "Correct answers: ${users.current.correct_answered}\n" +
                "Incorrect answers: ${users.current.incorrect_answered}"
        )
        goto(Idle)
    }
}