package com.slinger.greenfieldworld.controller.inputparser.subparser;

import com.slinger.greenfieldworld.model.player.Player;
import lombok.NonNull;

import java.util.function.Consumer;

public class EquipParser extends Parser {

    private final Player player;

    public EquipParser(@NonNull Consumer<String> submitOutputConsumer, @NonNull Player player) {

        super(submitOutputConsumer);

        this.player = player;
    }

    @Override
    public void parse(String[] words) {
        String actionWord = words[0];
    }
}