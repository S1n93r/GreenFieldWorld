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
public class Cluster {

    private final Map<Coordinate, Region> regionsMap = new HashMap<>();

    @Getter
    private Coordinate coordinate;

    private Cluster(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Map<Coordinate, Region> getUnmodifiableRegionsMap() {
        return Collections.unmodifiableMap(regionsMap);
    }

    public void addRegion(Region region) {
        regionsMap.put(region.getCoordinate(), region);
    }

    public Region getRegion(Coordinate coordinate) {
        return regionsMap.get(coordinate);
    }
}