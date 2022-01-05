package furhatos.app.persuasiongame.nlu

import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

/*
Express number
 */
class ExpressNumber : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "Number",
            "number",
            "Question number",
            "question number",
            "I am at number",
            "I'm at number",
            "I am in number",
            "I'm in number",
            "Numero",
            "numero",
            "I am at",
            "I'm at",
            "I am in",
            "I'm in"
        )
    }
}

class One : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "one",
            "first",
            "question one",
            "first question",
            "1"
        )
    }
}

class QuestionOne(val number : One? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}

class Two : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "two",
            "second",
            "question two",
            "second question",
            "2",
            "to",
            "who"
        )
    }
}

class QuestionTwo(val number : Two? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}

class Three : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "three",
            "third",
            "question three",
            "third question",
            "3",
            "tree",
            "free"
        )
    }
}

class QuestionThree(val number : Three? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}

class Four : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "four",
            "forth",
            "question four",
            "forth question",
            "4",
            "for"
        )
    }
}

class QuestionFour(val number : Four? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}

class Five : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "five",
            "fifth",
            "question five",
            "fifth question",
            "5",
            "fight",
            "time",
            "price"
        )
    }
}

class QuestionFive(val number : Five? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}

class Six : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "six",
            "sixth",
            "question six",
            "sixth question",
            "6",
            "sex"
        )
    }
}

class QuestionSix(val number : Six? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}

class Seven : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "seven",
            "seventh",
            "question seven",
            "seventh question",
            "7"
        )
    }
}

class QuestionSeven(val number : Seven? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}

class Eight : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "eight",
            "eighth",
            "question eight",
            "eighth question",
            "8",
            "a",
            "at"
        )
    }
}

class QuestionEight(val number : Eight? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}

class Nine : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "nine",
            "ninth",
            "question nine",
            "ninth question",
            "9"
        )
    }
}

class QuestionNine(val number : Nine? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}

class Ten : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "ten",
            "tenth",
            "question ten",
            "tenth question",
            "10",
            "ben"
        )
    }
}

class QuestionTen(val number : Ten? = null, val expressnumber : ExpressNumber? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "@number", "@expressnumber @number"
        )
    }
}