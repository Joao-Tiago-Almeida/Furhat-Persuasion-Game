package furhatos.app.persuasiongame

import furhatos.app.persuasiongame.flow.*
import furhatos.skills.Skill
import furhatos.flow.kotlin.*

class PersuasiongameSkill : Skill() {
    override fun start() {
        Flow().run(Idle)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
