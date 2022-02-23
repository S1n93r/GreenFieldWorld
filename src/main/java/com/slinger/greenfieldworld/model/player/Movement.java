package com.slinger.greenfieldworld.model.player;

import com.slinger.greenfieldworld.model.world.World;

public class Movement {

    private final Player player;

    private final World world;

    public Movement(Player player) {

        this.player = player;

        world = player.getWorld();
    }

    public void goNorth(World world) {

    }

    public void goEast(World world) {

    }

    public void goSouth(World world) {

    }

    public void goWest(World world) {

    }
}