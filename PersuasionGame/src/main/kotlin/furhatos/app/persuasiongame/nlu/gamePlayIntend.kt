package furhatos.app.persuasiongame.nlu

import furhatos.app.persuasiongame.speech.robotName
import furhatos.flow.kotlin.furhat
import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

/*
Asking for something
 */
class AskFor : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "I want",
            "I need",
            "Want",
            "want",
            "Need",
            "need",
            "Tell",
            "tell",
            "Say",
            "say",
            "Tell me",
            "tell me",
            "Give me",
            "give me",
            "Can I have",
            "can I have",
            "I require",
            "Please",
            "please",
            "Could you",
            "could you",
            "Can you",
            "can you"
        )
    }
}

/*
Ask for help
 */
class Help : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "Help",
            "help",
            "Halp",
            "halp",
            "Hint",
            "hint",
            "Stuck",
            "stuck",
            "Helper",
            "helper",
            "Support",
            "support",
            robotName,
            "Hello",
            "Hi",
            "There"
        )
    }
}

class AskHelp(val help : Help? = null, val askfor : AskFor? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@askfor @help", "Please @askfor @help", "please @askfor @help", "@help", "@help please", "@askfor @help please",
            "@askfor @help me please", "$robotName @askfor @help"
        )
    }
}

/*
Ask for a hint
 */
class HintWord : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "Hint",
            "hint",
            "Hind",
            "hind",
            "Hints",
            "hints",
            "a hint",
            "A hint",
            "one more hint",
            "one more hints",
            "more hint",
            "more hints",
            "another hint",
            "please",
            "I do want a hint"

        )
    }
}

class AskHint(val hint : HintWord? = null, val askfor : AskFor? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@askfor @hint", "Please @askfor @hint", "please @askfor @hint", "@hint", "@hint please", "@askfor @hint please",
            "@askfor @hint me please"
        )
    }
}

/*
Ask for answer
 */
class AnswerWord : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "Answer",
            "answer",
            "Correct answer",
            "correct answer",
            "Correct",
            "correct",
            "Answers",
            "answers",
            "Truth",
            "truth",
            "The answer",
            "the answer",
            "An answer",
            "an answer",
            "The answers",
            "the answers"
        )
    }
}

class AskAnswer(val answer : AnswerWord? = null, val askfor : AskFor? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf("@askfor @answer", "Please @askfor @answer", "please @askfor @answer", "@answer", "@answer please", "@askfor @answer please",
            "@askfor @answer please", "just @askfor @answer"
        )
    }
}