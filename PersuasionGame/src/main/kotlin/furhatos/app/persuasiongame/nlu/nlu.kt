package furhatos.app.persuasiongame.nlu

import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

class Name : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "Joao", "Victor", "Philipp", "Katie", "Manuel", "Alex", "Sofia", "Olivia", "Liam", "Emma", "Noah", "Amelia",
            "Oliver", "Sophia", "Lucas", "Charlotte", "Levi", "James", "Dennis","Elsa", "Marcel-Robert", "Iolanda", "Thomas", "Manuel", "Arzu", "Emil", "Laura",
            "Edlidir", "Ola", "João", "Philip", "Kristin", "Isak", "Divya", "Alexander", "Mikael", "Miklovana", "Katie", "Elmira", "Ilaria")
    }
}

class TellNameBriefly(val name : Name? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@name",
            "I am @name",
            "My name is @name",
            "Yes, my name is @name",
            "Yes, I am @name"
        )
    }
}

// It was having lots of troubles listening this expression, so I create this class
class Help : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "help"
        )
    }
}

class AskHelp(val help : Help? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@help"
        )
    }
}

class ForceExit(val name : Name? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "titanic"
        )
    }
}

class HintWord : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("hint")
    }
}

class Hint(val hint : HintWord? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I want an @hint",
            "Please give me an @hint",
            "@hint",
            "an @hint",
            "I want one more @hint",
            "Can you give me one more @hint",
            "yes, an @hint please",
            "can I have one more @hint please",
            "can I another @hint",
            "please another @hint"
        )
    }
}

class AnswerWord : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf("answer")
    }
}

class Answer(val answer : AnswerWord? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "I want the @answer",
            "Please give me an @answer",
            "@answer",
            "the @answer",
            "Can you give me the @answer",
            "yes, the @answer please",
            "can I have the @answer please",
            "Ok give the @answer"
        )
    }
}