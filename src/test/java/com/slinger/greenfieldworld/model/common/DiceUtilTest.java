package com.slinger.greenfieldworld.model.common;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DiceUtilTest {

    @Test
    public void diceResultsAreWithinRange() {

        List<Integer> diceResults = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            diceResults.add(DiceUtil.rollDice(6));
        }

        boolean resultsAreWithinRange = true;

        for (int diceResult : diceResults) {
            if (diceResult < 1 || diceResult > 6)
                resultsAreWithinRange = false;
        }

        assertTrue(resultsAreWithinRange);
    }
}