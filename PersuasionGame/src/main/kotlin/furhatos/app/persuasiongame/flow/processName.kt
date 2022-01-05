package furhatos.app.persuasiongame.flow

import furhatos.app.persuasiongame.gestures.FriendlySmile
import furhatos.app.persuasiongame.name
import furhatos.app.persuasiongame.nlu.TellNameBriefly
import furhatos.app.persuasiongame.speech.*
import furhatos.flow.kotlin.*
import furhatos.gestures.Gestures
import furhatos.nlu.common.TellName

/*
Introduction and self-presentation of furhat
 */
val SelfPresent : State = state{
    onEntry {
        furhat.say(self_present.random())
        goto(FetchUserName)
    }
}

/*
Catch user's name
 */
val CatchName: State = state(Interaction){
    /*
    Tell name in brief fashion
     */
    onResponse<TellNameBriefly> {
        users.current.name = "${it.intent.name}"
        goto(process_name("${it.intent.name}"))
    }

    /*
    Tell your name in extensive fashion
     */
    onResponse<TellName> {
        users.current.name = "${it.intent.name}"
        goto(process_name("${it.intent.name}"))
    }

    /*
    Tell new name
     */
    onResponse {
        if (users.current.name == null) {
            random(
                {
                    furhat.say(utterance {
                        + "Did you say:"
                        + it.text
                        + "?" })},
                {
                    furhat.say(utterance {
                        +"I heard:"
                        +it.text
                        +"?"})}
            )

            val validate: Boolean? = furhat.askYN(utterance {
                + delay(100)
                + "Is that your name?"
            })

            if (validate == true) {
                users.current.name = it.text
                random(
                    {
                        furhat.say(utterance {
                            + "${users.current.name}, what a wonderful name I just learned."
                            + blocking {furhat.gesture(FriendlySmile, async = false)}})
                    },
                    {
                        furhat.say(utterance {
                            + "${users.current.name}... Ohh one more beautiful name I learned."
                            + blocking {furhat.gesture(Gestures.Wink, async = false)}})
                    }
                )
                goto(PresentGame)
            } else {
                random(
                    { furhat.ask("So what is your name?") },
                    { furhat.ask("Okay, could you repeat your name then?") },
                    { furhat.ask("Oh sorry, so what is your name?") }
                )
            }
        } else {
            random(
                { furhat.ask("Sorry, what did you say?") },
                { furhat.ask("Sorry, I didn't understand that. Could you repeat that?") },
                { furhat.ask("Sorry, could you repeat that?") }
            )
        }
    }
}

val FetchUserName : State = state(CatchName) {
    onEntry {
        if(users.current.name == null) {
            furhat.ask(ask_for_name.random())
        }
        else {
            goto(Idle)
        }
    }

    onReentry {
        if(users.current.name == null) {
            random(
                { furhat.ask("What is your name?") },
                { furhat.ask("What was your name?") },
                { furhat.ask("Your name is what?") })
        }
        else {
            goto(Idle)
        }
    }

    onNoResponse {
        if(users.current.name == null) {
            random(
                {furhat.say("Hello? Sorry, you might have missed that.")},
                {furhat.say("Hello, somebody out there?") },
                {furhat.say("Did you say something?")})
            furhat.ask("My name is $robotName, what is yours?")
        }
    }
}


/*
Process name of user
 */
fun process_name(userName : String) : State = state {
    onEntry {
        if (userName == robotName) {
            random(
                {
                    furhat.say(utterance {
                        + "Your name is also ${users.current.name}?"
                        + blocking {furhat.gesture(Gestures.Surprise, async = false)}
                        + "What a funny coincidence!"
                    })
                },
                {
                    furhat.say(utterance {
                        + "What? Your name is also ${users.current.name}?"
                        + blocking {furhat.gesture(Gestures.BigSmile, async = false)}
                        + "How funny!"
                    })
                },
                {
                    furhat.say(utterance {
                        + "We are both named ${users.current.name}?"
                        + blocking {furhat.gesture(Gestures.Surprise, async = false)}
                        + "What a funny coincidence!"
                    })
                }
            )
        } else {
            random(
                {
                    furhat.say(utterance {
                        + "${users.current.name}, what a wonderful name"
                        + blocking {furhat.gesture(Gestures.BigSmile, async = false)}
                    })
                },
                {
                    furhat.say(utterance {
                        + "${users.current.name}... I like that name!"
                        + blocking {furhat.gesture(Gestures.Wink, async = false)}
                    })
                }
            )
        }
        goto(PresentGame)
    }
}