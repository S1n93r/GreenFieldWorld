package com.slinger.greenfieldworld.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.world.Coordinate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(access = AccessLevel.PROTECTED)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @Getter
    private final String name;

    @Getter
    private Coordinate currentPosition;

    private Player(String name, Coordinate currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public void spawn(Coordinate coordinate) {
        currentPosition = coordinate;
    }
}