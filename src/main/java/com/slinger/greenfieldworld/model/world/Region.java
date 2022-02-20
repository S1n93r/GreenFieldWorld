package com.slinger.greenfieldworld.model.world;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class Region {
    private final RegionName regionName;
}