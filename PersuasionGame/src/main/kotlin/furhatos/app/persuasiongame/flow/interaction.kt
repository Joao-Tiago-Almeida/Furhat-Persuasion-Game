package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.*
import furhatos.app.persuasiongame.nlu.*
import furhatos.flow.kotlin.*
import furhatos.app.persuasiongame.speech.*
import furhatos.gestures.Gestures

val Start : State = state(Interaction) {

    onEntry {
        // Interrogates the user to start the game
        val playGame = furhat.askYN(play_game_question.random()){}

        if(playGame == true){
            users.current.mode = random("neutral", "friendly", "competent")
            users.current.questions_answered = 0
            goto(Introduction)
        } else {
            furhat.say("OK, next time! Bye")
            goto(Idle)
        }
    }

    onNoResponse{
        furhat.say(no_or_other_response_say.random())
        furhat.ask(no_response_ask.random())
    }

    onResponse{
        furhat.say(no_or_other_response_say.random())
        furhat.ask(other_response_ask.random())
    }
}

val Introduction : State = state(Interaction) {

    onEntry {
        // Interrogates the user to start the game
        furhat.say(furhat_name.random())
        furhat.ask((ask_name.random()))
    }

    onResponse<TellNameBriefly> {
        users.current.name = "${it.intent.name}"
        goto(GeneralInformation)
    }

    onNoResponse{
        furhat.say(no_or_other_response_say.random())
        furhat.ask(no_response_ask.random())
    }

    onResponse{
        random(
            {furhat.say(utterance {
                +"Did you say:"
                +delay(100)
                +it.text
                +"?"
            })},
            {furhat.say(utterance {
                +"I heard:"
                +delay(100)
                +it.text
                +"?"
            })}
        )

        val validate: Boolean? = furhat.askYN(utterance {
            +delay(200)
            +"Is that your name?"
        })

        if (validate == true) {
            users.current.name = it.text
            goto(GeneralInformation)
        }
        else{
            random(
                {furhat.ask("So what is your name?")},
                {furhat.ask("Okay, could you repeat your name then?")},
                {furhat.ask("Oh sorry, so what is your name?")}
            )
        }
        goto(Idle)
    }
}

val GeneralInformation : State = state(Interaction) {
    onEntry {
        furhat.say(
            utterance {
                +greeting.random()
                +users.current.name!!
                +delay(100)
                +play_game.random()
                +hi_furhat1.random()
                +hi_furhat2.random()
                +magic_word
                +delay(500)
                +ps_note.random()
            }
        )

        delay(200)
        furhat.say("Game starts in Three")
        furhat.ledStrip.solid(java.awt.Color(204,50,50))
        delay(1000)
        furhat.say("Two")
        delay(1000)
        furhat.ledStrip.solid(java.awt.Color(231,180,22))
        furhat.say("One")
        delay(1000)
        furhat.ledStrip.solid(java.awt.Color(45,201,55))
        furhat.say("Go")
        delay(1000)
        furhat.ledStrip.solid(java.awt.Color(0,0,0))

        goto(HiFurhat)
    }
}

val HiFurhat : State = state(Interaction) {

    onEntry {
        furhat.ledStrip.solid(java.awt.Color(80,0, 80))
        furhat.listen(timeout = 1000)
    }

    onResponse<AskHelp> {
        furhat.ledStrip.solid(java.awt.Color(255,255,255))
        furhat.say("I am here to help.")
        furhat.gesture(Gestures.Smile)
        goto(QuestionHint)
    }

    onResponse<ForceExit> { goto(GameOver) }

    // ____________Feedback is triggered manually--___________
    onButton(correctAnswerButton){ goto(CorrectAnswer) }

    onButton(incorrectAnswerButton){ goto(IncorrectAnswer) }

    onNoResponse{
        val margin = 10
        furhat.ledStrip.solid(
            java.awt.Color(
                (80-margin..80+margin).random(),
                0,
                (80-margin..80+margin).random()
            )
        )
        furhat.listen(timeout = 5000)
    }

    onResponse{
        furhat.ledStrip.solid(java.awt.Color(0,240,240))
        furhat.say(
            utterance {
                +wrong_magic_word.random()
                +magic_word
            }
        )
        furhat.listen(timeout = 1000)
    }
}

// TODO complete with more info
val GameOver : State = state(Interaction) {
    onEntry {
        furhat.ledStrip.solid(java.awt.Color(0,0,0))
        furhat.say("End of the Game, Thanks for playing")
        ROBOT.writeToFile(
            users.current.name.toString(),
            users.current.questions_answered,
            users.current.mode.toString(),
            users.current.question1_hint_n,
            users.current.question2_hint_n,
            users.current.question3_hint_n,
            users.current.question4_hint_n,
            users.current.question5_hint_n,
            users.current.question6_hint_n,
            users.current.question7_hint_n,
            users.current.question8_hint_n,
            users.current.question9_hint_n,
            users.current.question10_hint_n,
            users.current.correct_answered,
            users.current.incorrect_answered
        )
        goto(Idle)
    }

}