package com.slinger.greenfieldworld.controller;

import com.slinger.greenfieldworld.model.common.MessageUtil;

import java.util.ArrayList;
import java.util.List;

public class RecentInputs {

    private static final int DEFAUlT_MAX_COVERABLE_INPUTS = 10;
    private final List<String> recoveableInputs = new ArrayList<>();

    private int indexCurrentInput;

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
        indexCurrentInput = recoveableInputs.indexOf(input);
    }

    public String getPreviousInput() {

        if (recoveableInputs.isEmpty())
            return MessageUtil.emptyString();

        if (recoveableInputs.size() == 1)
            return recoveableInputs.get(0);

        if (indexCurrentInput == 0)
            return MessageUtil.emptyString();

        indexCurrentInput--;

        return recoveableInputs.get(indexCurrentInput);
    }

    public String getNextInput() {

        if (recoveableInputs.isEmpty())
            return MessageUtil.emptyString();

        if (recoveableInputs.size() == 1)
            return MessageUtil.emptyString();

        if (indexCurrentInput == recoveableInputs.size() - 1)
            return MessageUtil.emptyString();

        indexCurrentInput++;

        return recoveableInputs.get(indexCurrentInput);
    }
}