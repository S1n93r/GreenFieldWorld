package com.slinger.greenfieldworld.controller.inputparser.subparser;

import lombok.NonNull;

import java.util.function.Consumer;

public abstract class Parser {

    protected final Consumer<String> submitOutputConsumer;

    protected Parser(@NonNull Consumer<String> submitOutputConsumer) {
        this.submitOutputConsumer = submitOutputConsumer;
    }

    public abstract void parse(String[] params);
}