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

var User.question1_hint_n by NullSafeUserDataDelegate { 0 }
var User.question2_hint_n by NullSafeUserDataDelegate { 0 }
var User.question3_hint_n by NullSafeUserDataDelegate { 0 }
var User.question4_hint_n by NullSafeUserDataDelegate { 0 }
var User.question5_hint_n by NullSafeUserDataDelegate { 0 }
var User.question6_hint_n by NullSafeUserDataDelegate { 0 }
var User.question7_hint_n by NullSafeUserDataDelegate { 0 }
var User.question8_hint_n by NullSafeUserDataDelegate { 0 }
var User.question9_hint_n by NullSafeUserDataDelegate { 0 }
var User.question10_hint_n by NullSafeUserDataDelegate { 0 }

