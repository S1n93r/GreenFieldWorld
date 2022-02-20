package com.slinger.greenfieldworld.model.player;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Builder(access = AccessLevel.PACKAGE)
public class Player {

    @Getter
    private long id;

    @Getter
    private String name;
}