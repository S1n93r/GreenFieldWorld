package com.slinger.greenfieldworld.controller;

import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.function.Consumer;

public class RootController {

    private final InputParser inputParser;

    @FXML
    private TextArea console;
    @FXML
    private TextField input;

    public RootController() {

        WorldGenerator worldGenerator = new WorldGenerator();
        World world = worldGenerator.generateWorld("Test", 10);

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        inputParser = new InputParser(player, world, generateOutputConsumer());
    }

    private Consumer<String> generateOutputConsumer() {
        return output -> {

            console.appendText(output + System.lineSeparator());

            console.appendText(input.getText() + System.lineSeparator());
            input.clear();
        };
    }

    @FXML
    private void onSubmitButtonPressed() {
        submit();
    }

    @FXML
    private void onEnterPressed(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER)
            submit();
    }

    private void submit() {
        inputParser.submitInput(input.getText());
    }
}