package furhatos.app.persuasiongame

import furhatos.flow.kotlin.NullSafeUserDataDelegate
import furhatos.flow.kotlin.UserDataDelegate
import furhatos.records.User

var User.name : String? by UserDataDelegate()
var User.mode : String? by UserDataDelegate()
var User.questions_answered by NullSafeUserDataDelegate { 0 }
var User.correct_answered by NullSafeUserDataDelegate { 0 }
var User.incorrect_answered by NullSafeUserDataDelegate { 0 }
var User.numberHints by NullSafeUserDataDelegate { 0 }

