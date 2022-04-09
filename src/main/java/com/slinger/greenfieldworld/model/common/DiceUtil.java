package com.slinger.greenfieldworld.model.common;

public final class DiceUtil {

    private static final int DICE_SIDES_FOR_PERCENT = 100;

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

    public static int rollDiceForPercent() {
        return rollDice(DICE_SIDES_FOR_PERCENT);
    }
}