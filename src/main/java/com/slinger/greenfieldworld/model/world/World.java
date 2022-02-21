package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    private static final int DEFAULT_GRID_SIZE = 16;

    private final Map<Coordinate, Cluster> clusterMap = new HashMap<>();

    @Getter
    private long id;

    @Getter
    private String name;

    @Getter
    @Builder.Default
    private int gridSize = 16;

    private World(long id, String name, int gridSize) {

        this.id = id;
        this.name = name;
        this.gridSize = gridSize;
    }

    public Map<Coordinate, Cluster> getUnmodifiableClusterMap() {
        return Collections.unmodifiableMap(clusterMap);
    }

    public void addCluster(Cluster cluster) {

        Cluster checkCluster = clusterMap.get(cluster.getCoordinate());

        /* TODO: Use logger here. */
        if (checkCluster != null)
            System.out.println("WARNING: Cluster already exists.");

        clusterMap.put(cluster.getCoordinate(), cluster);
    }

    public Cluster getCluster(Coordinate coordinate) {
        return clusterMap.get(coordinate);
    }
}