package furhatos.app.persuasiongame.nlu

import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

class One : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "one",
            "first",
            "question one",
            "first question"
        )
    }
}

class QuestionOne(val number : One? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}

class Two : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "two",
            "second",
            "question two",
            "second question"
        )
    }
}

class QuestionTwo(val number : Two? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}

class Three : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "three",
            "third",
            "question three",
            "third question"
        )
    }
}

class QuestionThree(val number : Three? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}

class Four : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "four",
            "forth",
            "question four",
            "forth question"
        )
    }
}

class QuestionFour(val number : Four? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}

class Five : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "five",
            "fifth",
            "question five",
            "fifth question"
        )
    }
}

class QuestionFive(val number : Five? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}

class Six : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "six",
            "sixth",
            "question six",
            "sixth question"
        )
    }
}

class QuestionSix(val number : Six? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}

class Seven : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "seven",
            "seventh",
            "question seven",
            "seventh question"
        )
    }
}

class QuestionSeven(val number : Seven? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}

class Eight : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "eight",
            "eighth",
            "question eight",
            "eighth question"
        )
    }
}

class QuestionEight(val number : Eight? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}

class Nine : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "nine",
            "ninth",
            "question nine",
            "ninth question"
        )
    }
}

class QuestionNine(val number : Nine? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}

class Ten : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "ten",
            "tenth",
            "question ten",
            "tenth question"
        )
    }
}

class QuestionTen(val number : Ten? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number"
        )
    }
}