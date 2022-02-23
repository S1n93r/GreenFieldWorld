package com.slinger.greenfieldworld.model.player;

public class PlayerGenerator {

    public Player generatePlayer(String name) {
        return Player.builder().name(name).build();
    }
}