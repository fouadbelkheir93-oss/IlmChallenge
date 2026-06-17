package com.example.islamquiznl.utils

object ChallengeCodeUtils {

    private const val CHARSET = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"
    private const val CODE_LENGTH = 6

    /** Genereer een willekeurige 6-tekens code */
    fun generateCode(): String {
        return (1..CODE_LENGTH).map { CHARSET.random() }.joinToString("")
    }

    /** Normaliseer invoer: uppercase, verwijder spaties/streepjes */
    fun normalize(input: String): String {
        return input.uppercase().replace(" ", "").replace("-", "")
    }

    /** Valideer een genormaliseerde code */
    fun isValid(code: String): Boolean {
        val normalized = normalize(code)
        if (normalized.length != CODE_LENGTH) return false
        return normalized.all { it in CHARSET }
    }

    /**
     * Zet code om naar een stabiele Long seed.
     * Deterministisch: zelfde code = zelfde seed op elke telefoon.
     */
    fun toSeed(code: String): Long {
        val normalized = normalize(code)
        var result = 0L
        for (ch in normalized) {
            result = result * 37L + ch.code.toLong()
        }
        return result
    }
}
