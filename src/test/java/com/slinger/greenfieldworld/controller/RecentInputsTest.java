package com.slinger.greenfieldworld.controller;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecentInputsTest {

    @Test
    public void askingForPreviousInputsReturnsCorrectInputs() {

        /* Given */
        RecentInputs sut = new RecentInputs(3);

        sut.addInput("Input 1");
        sut.addInput("Input 2");
        sut.addInput("Input 3");
        sut.addInput("Input 4");

        List<String> actualInputs = new ArrayList<>();

        /* When */
        actualInputs.add(sut.getPreviousInput());
        actualInputs.add(sut.getPreviousInput());
        actualInputs.add(sut.getPreviousInput());

        /* Then */
        List<String> expectedInputs = new ArrayList<>();

        expectedInputs.add("Input 3");
        expectedInputs.add("Input 2");
        expectedInputs.add("");

        assertEquals(expectedInputs, actualInputs);
    }

    @Test
    public void askingForNextInputsReturnsCorrectInputs() {

        /* Given */
        RecentInputs sut = new RecentInputs(3);

        sut.addInput("Input 1");
        sut.addInput("Input 2");
        sut.addInput("Input 3");
        sut.addInput("Input 4");

        List<String> actualInputs = new ArrayList<>();

        /* When */
        actualInputs.add(sut.getNextInput());
        actualInputs.add(sut.getPreviousInput());
        actualInputs.add(sut.getPreviousInput());
        actualInputs.add(sut.getNextInput());

        /* Then */
        List<String> expectedInputs = new ArrayList<>();

        expectedInputs.add("");
        expectedInputs.add("Input 3");
        expectedInputs.add("Input 2");
        expectedInputs.add("Input 3");

        assertEquals(expectedInputs, actualInputs);
    }

    @Test
    public void getPreviousWithEmptyListReturnEmptyInput() {

        /* Given */
        RecentInputs sut = new RecentInputs();

        /* When */
        String actualInput = sut.getPreviousInput();

        /* Then */
        assertEquals("", actualInput);
    }

    @Test
    public void getNextWithEmptyListReturnEmptyInput() {

        /* Given */
        RecentInputs sut = new RecentInputs();

        sut.addInput("Input 1");

        /* When */
        String actualInput = sut.getNextInput();

        /* Then */
        assertEquals("", actualInput);
    }

    @Test
    public void getPreviousWithOneElementInListReturnEmptyInput() {

        /* Given */
        RecentInputs sut = new RecentInputs();

        sut.addInput("Input 1");

        /* When */
        String actualInput = sut.getPreviousInput();

        /* Then */
        assertEquals("Input 1", actualInput);
    }

    @Test
    public void getNextWithOneElementInListReturnEmptyInput() {

        /* Given */
        RecentInputs sut = new RecentInputs();

        /* When */
        String actualInput = sut.getNextInput();

        /* Then */
        assertEquals("", actualInput);
    }
}