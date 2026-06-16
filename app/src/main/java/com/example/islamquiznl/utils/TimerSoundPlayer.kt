package com.example.islamquiznl.utils

import android.media.AudioManager
import android.media.ToneGenerator

class TimerSoundPlayer {

    private var toneGenerator: ToneGenerator? = null
    private var lastPlayedSecond: Int? = null

    init {
        toneGenerator = ToneGenerator(AudioManager.STREAM_MUSIC, 60)
    }

    fun playTick(remainingSeconds: Int, soundEnabled: Boolean) {
        if (!soundEnabled) return
        if (remainingSeconds !in 1..10) return
        if (lastPlayedSecond == remainingSeconds) return

        lastPlayedSecond = remainingSeconds

        toneGenerator?.startTone(
            ToneGenerator.TONE_PROP_BEEP,
            80
        )
    }

    fun playTimeUp(soundEnabled: Boolean) {
        if (!soundEnabled) return

        toneGenerator?.startTone(
            ToneGenerator.TONE_PROP_NACK,
            250
        )
    }

    fun reset() {
        lastPlayedSecond = null
    }

    fun release() {
        toneGenerator?.release()
        toneGenerator = null
    }
}
