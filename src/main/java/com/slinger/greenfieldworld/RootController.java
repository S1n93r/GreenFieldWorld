package com.slinger.greenfieldworld;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class RootController {

    @FXML
    private TextArea console;
    @FXML
    private TextField input;

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
        console.appendText(input.getText() + System.lineSeparator());
        input.clear();
    }
}