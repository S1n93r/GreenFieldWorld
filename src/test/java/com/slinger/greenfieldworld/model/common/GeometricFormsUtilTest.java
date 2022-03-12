package com.slinger.greenfieldworld.model.common;

import com.slinger.greenfieldworld.model.world.Coordinate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeometricFormsUtilTest {

    @Test
    public void circleHasCorrectCoordinates() {

        /* Given, When */
        List<Coordinate> coordinateList = GeometricFormsUtil.midPointAlgorithmDrawCircle(0, 0, 2);

        List<Coordinate> expectedCoordinates = new ArrayList<>();

        expectedCoordinates.add(Coordinate.of(-1, 2));
        expectedCoordinates.add(Coordinate.of(0, 2));
        expectedCoordinates.add(Coordinate.of(1, 2));

        expectedCoordinates.add(Coordinate.of(2, 1));
        expectedCoordinates.add(Coordinate.of(2, 0));
        expectedCoordinates.add(Coordinate.of(2, -1));

        expectedCoordinates.add(Coordinate.of(1, -2));
        expectedCoordinates.add(Coordinate.of(0, -2));
        expectedCoordinates.add(Coordinate.of(-1, -2));

        expectedCoordinates.add(Coordinate.of(-2, -1));
        expectedCoordinates.add(Coordinate.of(-2, 0));
        expectedCoordinates.add(Coordinate.of(-2, 1));

        /* Then */
        assertEquals(12, coordinateList.size());
        assertTrue(coordinateList.containsAll(expectedCoordinates));
    }

    @Test
    public void filledCircleHasCorrectCoordinates() {

        /* Given, When */
        List<Coordinate> coordinateList = GeometricFormsUtil.midPointAlgorithmDrawCircleFilled(0, 0, 2);

        List<Coordinate> expectedCoordinates = new ArrayList<>();

        expectedCoordinates.add(Coordinate.of(-1, 2));
        expectedCoordinates.add(Coordinate.of(0, 2));
        expectedCoordinates.add(Coordinate.of(1, 2));

        expectedCoordinates.add(Coordinate.of(-2, 1));
        expectedCoordinates.add(Coordinate.of(-1, 1));
        expectedCoordinates.add(Coordinate.of(0, 1));
        expectedCoordinates.add(Coordinate.of(1, 1));
        expectedCoordinates.add(Coordinate.of(2, 1));

        expectedCoordinates.add(Coordinate.of(-2, 0));
        expectedCoordinates.add(Coordinate.of(-1, 0));
        expectedCoordinates.add(Coordinate.of(0, 0));
        expectedCoordinates.add(Coordinate.of(1, 0));
        expectedCoordinates.add(Coordinate.of(2, 0));

        expectedCoordinates.add(Coordinate.of(-2, -1));
        expectedCoordinates.add(Coordinate.of(-1, -1));
        expectedCoordinates.add(Coordinate.of(0, -1));
        expectedCoordinates.add(Coordinate.of(1, -1));
        expectedCoordinates.add(Coordinate.of(2, -1));

        expectedCoordinates.add(Coordinate.of(-1, -2));
        expectedCoordinates.add(Coordinate.of(0, -2));
        expectedCoordinates.add(Coordinate.of(1, -2));

        /* Then */
        assertEquals(21, coordinateList.size());
        assertTrue(coordinateList.containsAll(expectedCoordinates));
    }

    @Test
    public void getHorizontalLineWithDifferentYValuesThrowsException() {

        Coordinate start = Coordinate.of(-2, 6);
        Coordinate end = Coordinate.of(3, 7);

        assertThrows(IllegalStateException.class, () -> GeometricFormsUtil.getCoordinatesOfHorizontalLine(start, end));
    }

    @Test
    public void getHorizontalLineWithStartXAndEndXSwappedThrowsException() {

        Coordinate start = Coordinate.of(3, 7);
        Coordinate end = Coordinate.of(-2, 7);

        assertThrows(IllegalStateException.class, () -> GeometricFormsUtil.getCoordinatesOfHorizontalLine(start, end));
    }

    @Test
    public void getHorizontalLineHasCorrectCoordinates() {

        Coordinate start = Coordinate.of(-2, 7);
        Coordinate end = Coordinate.of(3, 7);

        List<Coordinate> coordinateList = GeometricFormsUtil.getCoordinatesOfHorizontalLine(start, end);

        List<Coordinate> expectedCoordinates = new ArrayList<>();
        expectedCoordinates.add(Coordinate.of(-2, 7));
        expectedCoordinates.add(Coordinate.of(-1, 7));
        expectedCoordinates.add(Coordinate.of(0, 7));
        expectedCoordinates.add(Coordinate.of(1, 7));
        expectedCoordinates.add(Coordinate.of(2, 7));
        expectedCoordinates.add(Coordinate.of(3, 7));

        assertEquals(6, coordinateList.size());
        assertTrue(coordinateList.containsAll(expectedCoordinates));
    }
}