package com.slinger.greenfieldworld.model.common;

public final class DiceUtil {

    private DiceUtil() {
        /* Util */
    }

    public static int rollDice(int sides) {
        return (int) (Math.random() * sides + 1);
    }
}