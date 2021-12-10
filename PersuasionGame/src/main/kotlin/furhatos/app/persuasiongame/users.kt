package furhatos.app.persuasiongame

import furhatos.flow.kotlin.UserDataDelegate
import furhatos.records.User

var User.name : String? by UserDataDelegate()
var User.mode : String? by UserDataDelegate()