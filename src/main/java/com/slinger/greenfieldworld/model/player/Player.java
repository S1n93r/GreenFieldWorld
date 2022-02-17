package com.slinger.greenfieldworld.model.player;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PACKAGE)
public class Player {

    @Getter
    private PlayerId playerId;

    @Getter
    private PlayerName playerName;
}