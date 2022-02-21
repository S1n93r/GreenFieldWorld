package com.slinger.greenfieldworld.model.world;

import java.util.Map;

public final class CoordinateRegionMapUtil {

    public static Coordinate findTopLeftCoordinate(Map<Coordinate, Region> coordinateRegionMap, int gridSize,
                                                   Coordinate exitCoordinate) {

        int x = 0;
        int y = 0;

        boolean searchingX = true;

        while (searchingX) {

            Region region = coordinateRegionMap.get(new Coordinate(x, y));

            if (region != null)
                x -= gridSize;
            else
                searchingX = false;
        }

        boolean searchingY = false;

        while (searchingY) {

            Region region = coordinateRegionMap.get(new Coordinate(x, y));

            if (region != null)
                y -= gridSize;
            else
                searchingY = false;
        }

        Coordinate topLeftCoordinate = new Coordinate(x, y);

        return topLeftCoordinate;

    }
}