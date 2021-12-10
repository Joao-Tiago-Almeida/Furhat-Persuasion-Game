package furhatos.app.persuasiongame.speech

import furhatos.util.CommonUtils

val ask_question_number = listOf(
    "In which question are you in?",
    "What is the number of your question",
    "Which is your question's number?"
)

val neutral_correct_answer = listOf(
    "Oh congratulations",
    "Nice job",
    "you chose wisely"
)

val neutral_incorrect_answer = listOf(
    "Dumb",
    "oh shit",
    "you chose poorly"
)

val friendly_correct_answer = listOf(
    "Oh congratulations",
    "Nice job",
    "you chose wisely"
)

val friendly_incorrect_answer = listOf(
    "Dumb",
    "oh shit",
    "you chose poorly"
)

val commanding_correct_answer = listOf(
    "Oh congratulations",
    "Nice job",
    "you chose wisely"
)

val commanding_incorrect_answer = listOf(
    "Dumb",
    "oh shit",
    "you chose poorly"
)

val friendly_persuading = listOf(
    "I am friendly ROBOT and I am going to persuade you",
    "I am friendly ROBOT and I am going to persuade you"
)

val neutral_persuading = listOf(
    "I am Neutral ROBOT and I am going to persuade you",
    "I am Neutral ROBOT and I am going to persuade you"
)

val commanding_persuading = listOf(
    "I am Commanding ROBOT and I am going to persuade you",
    "I am Commanding ROBOT and I am going to persuade you"
)

object ROBOT {

    /**
     * File to save the command mode.
     * Can be found in the user's home directory/.furhat/launcher/SDK/skills/Furhat-Persuasion-Game/PersuasionGame/src/main/kotlin/furhatos/app/persuasiongame/speech/ROBOT.tex when running on SDK.
     */
    private val file = CommonUtils.getAppDataDir("launcher/SDK/skills/Furhat-Persuasion-Game/PersuasionGame/src/main/kotlin/furhatos/app/persuasiongame/speech/ROBOT.tex")

    /**
     * Writes the current list of jokes to a file
     */
    fun writeToFile(name:String, n_question:Int, mode: String?) {
        if (!file.exists()) {
            file.createNewFile()
        }

        file.writeText(
            "User name: $name\n" +
                    "Questions answered: $n_question\n" +
                    "Robot mode: $mode\n"
        )
    }

}