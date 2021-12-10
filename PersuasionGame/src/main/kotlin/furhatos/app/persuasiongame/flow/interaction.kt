package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.mode
import furhatos.app.persuasiongame.name
import furhatos.app.persuasiongame.nlu.*
import furhatos.flow.kotlin.*
import furhatos.app.persuasiongame.speech.*
import furhatos.gestures.Gestures


val Start : State = state(Interaction) {

    onEntry {
        // Interrogates the user to start the game
        val playGame = furhat.askYN(play_game_question.random()){}

        if(playGame == true){
            users.current.mode = random("neutral", "friendly", "commanding")
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
        furhat.ledStrip.solid(java.awt.Color(0,0,0))
        goto(QuestionHint)
    }

    onResponse<ForceExit> {
        furhat.ledStrip.solid(java.awt.Color(0,0,0))
        furhat.say("Game is Over")
        goto(Idle)
    }

    onNoResponse{
        val margin = 20
        furhat.ledStrip.solid(
            java.awt.Color(
                (80-margin..80+margin).random(),
                0,
                (80-margin..80+margin).random()
            )
        )
        furhat.listen(timeout = 1000)
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