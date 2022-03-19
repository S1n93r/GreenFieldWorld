package com.slinger.greenfieldworld.controller.inputparser.subparser;

import lombok.NonNull;

import java.util.function.Consumer;

/* TODO: Maye this class should check basics and then just pass params to action, meaning only this class is
    necessary as a concrete. No subs. */
public abstract class Parser {

    protected final Consumer<String> submitOutputConsumer;

    protected Parser(@NonNull Consumer<String> submitOutputConsumer) {
        this.submitOutputConsumer = submitOutputConsumer;
    }

    public abstract void parse(String[] params);
}