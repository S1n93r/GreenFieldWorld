package com.slinger.greenfieldworld.model.items;

import lombok.Getter;

public abstract class Item {

    @Getter
    private final String name;

    protected Item() {
        this.name = setName();
    }

    protected abstract String setName();
}