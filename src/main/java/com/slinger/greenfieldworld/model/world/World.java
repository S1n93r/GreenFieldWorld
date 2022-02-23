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

    private static final int DEFAULT_REGION_GRID_SIDE_LENGTH = 3;
    private static final int DEFAULT_CLUSTER_GRID_SIDE_LENGTH = 5;

    private final Map<Coordinate, Region> regionMap = new HashMap<>();

    @Getter
    private long id;

    @Getter
    private String name;

    @Getter
    @Builder.Default
    private int regionGridSideLength = DEFAULT_REGION_GRID_SIDE_LENGTH;

    @Getter
    @Builder.Default
    private int clusterGridSideLength = DEFAULT_CLUSTER_GRID_SIDE_LENGTH;

    private World(long id, String name, int regionGridSideLength, int clusterGridSideLength) {

        this.id = id;
        this.name = name;
        this.regionGridSideLength = regionGridSideLength;
        this.clusterGridSideLength = clusterGridSideLength;
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

        int spawnSideValue = regionGridSideLength / 2;

        Region startRegion = getRegion(new Coordinate(spawnSideValue, spawnSideValue));

        player.spawn(this, startRegion);
    }

    public void movePlayerNorth(Player player) {

    }
}