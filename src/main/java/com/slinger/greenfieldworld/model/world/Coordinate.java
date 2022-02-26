package com.slinger.greenfieldworld.model.world;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
public class Coordinate {

    int x;

    int y;
}