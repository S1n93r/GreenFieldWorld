package com.slinger.greenfieldworld.model.creatures;

import com.slinger.greenfieldworld.model.common.DiceUtil;

public class Goblin extends Creature {

    private static final String SPECIES = "Goblin";

    private static final NameChest NAME_CHEST = new NameChest("Slasz", "Gnogz", "Glez", "Zik", "Blurd", "Domozz",
            "Zrulx", "Frolb", "Burd", "Tugz");

    protected Goblin() {
        super(NAME_CHEST.giveRandomName(), SPECIES,
                DiceUtil.rollDice(2), DiceUtil.rollDice(2),
                DiceUtil.rollDice(2), DiceUtil.rollDice(2));
    }

    @Override
    String getName() {
        return NAME_CHEST.giveRandomName();
    }

    @Override
    String getSpecies() {
        return SPECIES;
    }
}
