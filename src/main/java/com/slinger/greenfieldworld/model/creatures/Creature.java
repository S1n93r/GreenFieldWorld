package com.slinger.greenfieldworld.model.creatures;

import lombok.Getter;

public abstract class Creature {

    @Getter
    protected final String name;
    @Getter
    protected final String species;

    @Getter
    protected final int attack;
    @Getter
    protected final int currentAttack;

    @Getter
    protected final int defense;
    @Getter
    protected final int currentDefense;

    @Getter
    protected final int constitution;
    @Getter
    protected final int currentConstitution;

    @Getter
    protected final int morale;
    @Getter
    protected final int currentMorale;

    protected Creature(String name, String species, int attack, int defense, int constitution, int morale) {

        this.name = name;
        this.species = species;

        this.attack = attack;
        currentAttack = this.attack;

        this.defense = defense;
        currentDefense = this.defense;

        this.constitution = defense;
        currentConstitution = this.constitution;

        this.morale = morale;
        currentMorale = this.morale;
    }

    abstract String getName();

    abstract String getSpecies();
}