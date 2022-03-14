package com.slinger.greenfieldworld.model.exceptions;

public class SwitchCaseNotDefinedException extends RuntimeException {

    public SwitchCaseNotDefinedException() {}

    public SwitchCaseNotDefinedException(String message) {
        super(message);
    }
}