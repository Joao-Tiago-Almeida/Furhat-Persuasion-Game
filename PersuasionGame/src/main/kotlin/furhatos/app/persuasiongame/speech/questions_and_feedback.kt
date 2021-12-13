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

val competent_correct_answer = listOf(
    "Oh congratulations",
    "Nice job",
    "you chose wisely"
)

val competent_incorrect_answer = listOf(
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

val competent_persuading = listOf(
    "I am competent ROBOT and I am going to persuade you",
    "I am competent ROBOT and I am going to persuade you"
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
    fun writeToFile(name:String, n_question:Int, mode: String?, n_hint_1:Int, n_hint_2:Int,
                    n_hint_3:Int, n_hint_4:Int, n_hint_5:Int, n_hint_6:Int, n_hint_7:Int,
                    n_hint_8:Int, n_hint_9:Int, n_hint_10:Int, n_correct:Int, n_incorrect:Int)
    {
        if (!file.exists()) {
            file.createNewFile()
        }

        file.writeText(
            "User name: $name\n" +
                    "Questions answered: $n_question\n" +
                    "Robot mode: $mode\n" +
                    "$n_hint_1 in question 1\n" +
                    "$n_hint_2 in question 2\n" +
                    "$n_hint_3 in question 3\n" +
                    "$n_hint_4 in question 4\n" +
                    "$n_hint_5 in question 5\n" +
                    "$n_hint_6 in question 6\n" +
                    "$n_hint_7 in question 7\n" +
                    "$n_hint_8 in question 8\n" +
                    "$n_hint_9 in question 9\n" +
                    "$n_hint_10 in question 10\n" +
                    "Correct answers: $n_correct\n" +
                    "Incorrect answers: $n_incorrect"
        )
    }

}