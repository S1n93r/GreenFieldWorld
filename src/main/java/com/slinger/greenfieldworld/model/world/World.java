package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.player.Player;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Jacksonized
@Builder(access = AccessLevel.PROTECTED)
@JsonIgnoreProperties(ignoreUnknown = true)
public class World {

    private static final int DEFAULT_REGION_GRID_SIDE_LENGTH = 5;

    private final Map<Coordinate, Region> regionMap = new HashMap<>();

    @Getter
    private long id;

    @Getter
    private String name;

    @Getter
    private Player player;

    @Getter
    @Builder.Default
    private int regionGridSideLength = DEFAULT_REGION_GRID_SIDE_LENGTH;

    private World(long id, String name, Player player, int regionGridSideLength) {

        this.id = id;
        this.name = name;
        this.player = player;
        this.regionGridSideLength = regionGridSideLength;
    }

    public Map<Coordinate, Region> getUnmodifiableRegionMap() {
        return Collections.unmodifiableMap(regionMap);
    }

    public void addRegion(Region region) {

        Region checkRegion = regionMap.get(region.getCoordinate());

        /* TODO: Use logger here. */
        if (checkRegion != null)
            System.out.println("WARNING: Cluster already exists.");

        regionMap.put(region.getCoordinate(), region);
    }

    public Region getRegion(Coordinate coordinate) {
        return regionMap.get(coordinate);
    }

    public void spawnPlayerAtCenter(Player player) {

        this.player = player;

        int spawnSideValue = regionGridSideLength / 2;

        player.spawn(new Coordinate(spawnSideValue, spawnSideValue));
    }

    public void movePlayerNorth() {

        checkWorldHasPlayer();
    }

    private void checkWorldHasPlayer() {

        if (this.player == null)
            throw new IllegalStateException("You must spawn a player before trying to use any actions.");
    }
}