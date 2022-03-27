package com.slinger.greenfieldworld.model.world.regions.resources;

import com.slinger.greenfieldworld.model.items.Item;

import java.util.List;

public abstract class Resource {

    private final String name;

    protected Resource() {
        this.name = setName();
    }

    abstract List<Item> gather();

    abstract String setName();
}