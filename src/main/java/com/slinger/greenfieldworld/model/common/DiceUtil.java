package com.slinger.greenfieldworld.model.common;

public final class DiceUtil {

    private DiceUtil() {
        /* Util */
    }

    public static int rollDice(int sides) {
        return (int) (Math.random() * sides + 1);
    }

    public static int rollDice(int min, int max) {

        if (max <= min)
            throw new IllegalStateException("Value for 'max' can not be smaller or equal to 'min'.");

        return (int) (Math.random() * ((max - min) + 1) + min);
    }
}