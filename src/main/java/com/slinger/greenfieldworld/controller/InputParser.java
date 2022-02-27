package com.slinger.greenfieldworld.controller;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.world.World;
import lombok.Getter;

import java.util.function.Consumer;

public class InputParser {

    private final Player player;
    private final World world;

    private final Consumer<String> submitOutputConsumer;

    @Getter
    private String currentOutput;

    public InputParser(Player player, World world, Consumer<String> submitOutputConsumer) {
        this.player = player;
        this.world = world;
        this.submitOutputConsumer = submitOutputConsumer;
    }

    public void submitInput(String input) {

        switch (input) {
            case "move":
                submitOutputConsumer.accept("Which direction?");
                break;
            default:
        }
    }
}