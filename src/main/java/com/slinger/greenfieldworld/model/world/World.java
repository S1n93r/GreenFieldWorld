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

    private final Map<Coordinate, Region> regionsMap = new HashMap<>();

    @Getter
    private long id;

    @Getter
    private String name;

    private World(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Map<Coordinate, Region> getUnmodifiableRegionsMap() {
        return Collections.unmodifiableMap(regionsMap);
    }

    public void addRegion(Coordinate coordinate, Region region) {
        regionsMap.put(coordinate, region);
    }

    public Region getRegion(Coordinate coordinate) {
        return regionsMap.get(coordinate);
    }
}