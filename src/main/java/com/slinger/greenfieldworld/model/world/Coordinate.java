package com.slinger.greenfieldworld.model.world;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@Builder
@EqualsAndHashCode
public class Coordinate {

    int x;
    int y;
}