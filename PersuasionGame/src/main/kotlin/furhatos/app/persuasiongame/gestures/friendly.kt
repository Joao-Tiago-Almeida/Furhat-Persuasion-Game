package furhatos.app.persuasiongame.gestures

import furhatos.gestures.defineGesture
import furhatos.gestures.BasicParams.*

val FriendlyStandard = defineGesture("FriendlyStandard") {
    frame(0.3, persist = true) {
        SMILE_CLOSED to 0.3
        BROW_DOWN_LEFT to 0.6
        BROW_DOWN_RIGHT to 0.6
    }
}

val FriendlySmile = defineGesture("FriendlySmile") {
    frame(1.0, 1.5){
        //NECK_PAN to -20.0
        NECK_TILT to 8.0
        NECK_ROLL to 15.0
    }
    frame(0.32, 2.5) {
        SMILE_OPEN to 0.5
    }
    frame(0.2, 2.5){
        BROW_UP_LEFT to 1.0
        BROW_UP_RIGHT to 1.0
    }
    frame(0.16, 2.5){
        BLINK_LEFT to 0.1
        BLINK_RIGHT to 0.1
    }
    reset(3.0)
}