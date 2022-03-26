package com.slinger.greenfieldworld.controller;

import com.slinger.greenfieldworld.model.common.MessageUtil;

import java.util.ArrayList;
import java.util.List;

public class RecentInputs {

    private static final int DEFAUlT_MAX_COVERABLE_INPUTS = 10;
    private final List<String> recoveableInputs = new ArrayList<>();

    private int indexPreviousInput;
    private int indexNextInput;

    private int maxRecoverableInput = DEFAUlT_MAX_COVERABLE_INPUTS;

    public RecentInputs() {
    }

    public RecentInputs(int maxRecoverableInput) {
        this.maxRecoverableInput = maxRecoverableInput;
    }

    public void addInput(String input) {

        if (recoveableInputs.size() == maxRecoverableInput) {
            recoveableInputs.remove(0);
        }

        recoveableInputs.add(input);
        setIndexCurrentInput(recoveableInputs.indexOf(input) + 1);
    }

    public String getPreviousInput() {

        if (recoveableInputs.isEmpty())
            return MessageUtil.emptyString();

        if (recoveableInputs.size() == 1)
            return recoveableInputs.get(0);

        if (indexPreviousInput < 0)
            return MessageUtil.emptyString();

        String previousInput = recoveableInputs.get(indexPreviousInput);

        setIndexCurrentInput(indexPreviousInput);

        return previousInput;
    }

    public String getNextInput() {

        if (recoveableInputs.isEmpty())
            return MessageUtil.emptyString();

        if (recoveableInputs.size() == 1)
            return MessageUtil.emptyString();

        if (indexNextInput > recoveableInputs.size() - 1)
            return MessageUtil.emptyString();

        String nextInput = recoveableInputs.get(indexNextInput);

        setIndexCurrentInput(indexNextInput);

        return nextInput;
    }

    private void setIndexCurrentInput(int indexCurrentInput) {
        indexPreviousInput = indexCurrentInput - 1;
        indexNextInput = indexCurrentInput + 1;
    }
}