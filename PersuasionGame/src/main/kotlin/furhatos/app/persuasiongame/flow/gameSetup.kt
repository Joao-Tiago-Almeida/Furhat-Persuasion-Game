package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.mode
import furhatos.app.persuasiongame.name
import furhatos.app.persuasiongame.nlu.ExpressReady
import furhatos.app.persuasiongame.questions_answered
import furhatos.app.persuasiongame.speech.*
import furhatos.flow.kotlin.*
import furhatos.nlu.common.*

/*
Present game
 */
val PresentGame : State = state(Interaction) {
    onEntry {
        furhat.say(
            utterance {
                + greeting.random()
                + users.current.name!!
                + delay(100)
                + game_setup1.random()
                + hi_furhat1.random()
            }
        )
        random(
            { furhat.ask("Are you ready to play the game?") },
            { furhat.ask("Are you ready to start the game?") },
            { furhat.ask("Okay, ${users.current.name}. Ready to start the game?") }
        )
    }

    onReentry {
        furhat.listen(3000)
    }

    onResponse<Yes> {
        goto(StartGame)
    }

    onResponse<No> {
        random(
            {furhat.say("For any questions, please ask the instructor.")},
            {furhat.say("If you have any questions, please ask the instructor.")},
            {furhat.say("Please refer to the instructor, if you have any questions.")}
        )
        furhat.say("Once you are ready, just let me know and we will start the game.")
        reentry()
    }

    onResponse<ExpressReady> {
        goto(StartGame)
    }

    onNoResponse {
        reentry()
    }

    onResponse {
        random(
            {furhat.ask("Sorry what did you say? Are you ready to play?")},
            {furhat.ask("Sorry I didn't understand that. Are you ready to play the game?")},
            {furhat.ask("Sorry could you repeat that? Are you ready for the game?")}
        )
    }
}

/*
Initiate start of the game
 */
val StartGame : State = state{
    onEntry {
        //ToDo: Make sure to set right mode (either: neutral/friendly/competent)
        users.current.mode = "friendly"
        users.current.questions_answered = 0
        furhat.say(
            utterance {
                + play_game.random()
                + delay(100)
                + ps_note.random()
                + delay(300)
            })

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

        goto(SupportUnit)
    }
}