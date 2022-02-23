package com.slinger.greenfieldworld.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.world.Region;
import com.slinger.greenfieldworld.model.world.World;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @Getter
    private final String name;

    @Getter
    Region currentRegion;

    @Getter
    private Actions actions;

    @Getter
    private World world;

    public Player(String name) {
        this.name = name;
    }

    public void spawn(World world, Region region) {

        this.world = world;

        actions = new Actions(this);
        currentRegion = region;
    }
}