package furhatos.app.persuasiongame.nlu

import furhatos.nlu.Intent
import furhatos.util.Language


class ForceExit(val name : Name? = null): Intent() {
    override fun getExamples(lang: Language): List<String> {
        return listOf(
            "titanic"
        )
    }
}
