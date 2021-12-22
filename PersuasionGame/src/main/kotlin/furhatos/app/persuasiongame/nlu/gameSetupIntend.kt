package furhatos.app.persuasiongame.nlu

import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

/*
Express readiness
 */
class ReadyToStart : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "Ready",
            "ready",
            "Good to go",
            "good to go",
            "All set",
            "all set"
        )
    }
}

class ExpressReady(val ready: ReadyToStart?= null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("I am @ready", "I am @ready to start", "I am @ready to play", "I am @ready to start the game",
        "I am @ready to play the game", "@ready to start", "@ready to play", "@ready to start the game", "@ready to play the game",
        "ready")
    }
}