package com.slinger.greenfieldworld.controller;

import com.slinger.greenfieldworld.controller.inputparser.InputParser;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.PlayerGenerator;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.WorldGenerator;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.function.Consumer;

public class RootController {

    private static final String INPUT_MARKER = " > ";

    private final InputParser inputParser;

    private RecentInputs recentInputs = new RecentInputs();

    @FXML
    private TextArea console;
    @FXML
    private TextField input;

    public RootController() {

        WorldGenerator worldGenerator = new WorldGenerator();
        World world = worldGenerator.generateWorld("Test", 10);

        PlayerGenerator playerGenerator = new PlayerGenerator();
        Player player = playerGenerator.generatePlayer("Sl1ng3r");

        world.spawnPlayerAtCenter(player);

        inputParser = new InputParser(player, generateOutputConsumer());
    }

    private Consumer<String> generateOutputConsumer() {
        return output -> {

            String currentInput = input.getText();

            recentInputs.addInput(currentInput);

            console.appendText(INPUT_MARKER + currentInput + System.lineSeparator());

            console.appendText(output + System.lineSeparator());

            input.clear();
        };
    }

    @FXML
    private void onSubmitButtonPressed() {
        submit();
    }

    @FXML
    private void onKeyPressed(KeyEvent keyEvent) {

        switch (keyEvent.getCode()) {

            case ENTER:
                submit();
                break;

            case UP:
                String previousInput = recentInputs.getPreviousInput();

                if (!MessageUtil.isBlankOrEmpty(previousInput))
                    input.setText(previousInput);
                break;

            case DOWN:
                String nextInput = recentInputs.getNextInput();

                if (!MessageUtil.isBlankOrEmpty(nextInput))
                    input.setText(nextInput);
                break;

            default: //Nothing happens for unregistered keys.
        }
    }

    private void submit() {
        inputParser.submitInput(input.getText());
    }
}