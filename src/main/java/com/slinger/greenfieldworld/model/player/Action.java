package com.slinger.greenfieldworld.model.player;

import lombok.Getter;

public abstract class Action {

    @Getter
    protected final String triggerWord;

    protected final Player player;

    protected Action(Player player) {

        this.triggerWord = setTriggerWord();

        this.player = player;
    }

    abstract String setTriggerWord();

    public abstract String use(String parameter);
}