package com.slinger.greenfieldworld.model.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceUtilTest {

    /* TODO: Improve test to find missing values as well. Currently it is only tested that min and max are kept.*/
    @Test
    public void diceRollWithXSidesIsWithinRange() {

        /* Given */
        List<Integer> diceResults = new ArrayList<>();

        /* When */
        for (int i = 0; i < 100; i++) {
            diceResults.add(DiceUtil.rollDice(6));
        }

        /* Then */
        boolean resultsAreWithinRange = true;

        for (int diceResult : diceResults) {
            if (diceResult < 1 || diceResult > 6)
                resultsAreWithinRange = false;
        }

        assertTrue(resultsAreWithinRange);
    }

    /* TODO: Improve test to find missing values as well. Currently it is only tested that min and max are kept.*/
    @ParameterizedTest
    @CsvSource({"0,5", "2,4"})
    public void diceRollWithXMinAndXMaxIsWithinRange(int min, int max) {

        /* Given */
        List<Integer> diceResults = new ArrayList<>();

        /* When */
        for (int i = min; i < 100; i++) {
            diceResults.add(DiceUtil.rollDice(min, max));
        }

        /* Then */
        boolean resultsAreWithinRange = true;

        for (int diceResult : diceResults) {
            if (diceResult < min || diceResult > max)
                resultsAreWithinRange = false;
        }

        assertTrue(resultsAreWithinRange);
    }
}