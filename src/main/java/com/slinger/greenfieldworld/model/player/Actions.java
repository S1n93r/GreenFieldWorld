package com.slinger.greenfieldworld.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.world.World;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Actions {

    private final Player player;

    private final World world;

    @Getter
    private final Movement movement;

    public Actions(Player player) {

        this.player = player;

        world = player.getWorld();
        movement = new Movement(this.player);
    }
}