package furhatos.app.persuasiongame.nlu

import furhatos.nlu.EnumEntity
import furhatos.nlu.Intent
import furhatos.util.Language

class Name : EnumEntity(stemming = false, speechRecPhrases = true) {
    override fun getEnum(lang: Language): List<String> {
        return listOf(
            "Joao", "Victor", "Philipp", "Katie", "Manuel", "Alex", "Sofia", "Olivia", "Liam", "Emma", "Noah", "Amelia",
            "Oliver", "Sophia", "Lucas", "Charlotte", "Levi", "James", "Dennis","Elsa", "Marcel-Robert", "Iolanda", "Thomas", "Manuel", "Arzu", "Emil", "Laura",
            "Edlidir", "Ola", "João", "Philip", "Kristin", "Isak", "Divya", "Alexander", "Mikael", "Miklovana", "Katie", "Elmira", "Ilaria", "Geremy")
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