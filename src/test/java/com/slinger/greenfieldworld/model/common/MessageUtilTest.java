package com.slinger.greenfieldworld.model.common;

import com.slinger.greenfieldworld.model.world.Coordinate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageUtilTest {

    @Test
    public void argumentsAreTurnedIntoCleanMessage() {

        /* Given, When*/
        String output = MessageUtil.format("Here you can see an integer {0}, a String {1} and a coordinate {2}", 3,
                "Test", Coordinate.of(3, 3));

        String expectedOutput = "Here you can see an integer 3, a String Test and a coordinate Coordinate(x=3, y=3)";

        /* Then */
        assertEquals(expectedOutput, output);
    }
}