package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Jacksonized
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
public class Coordinate {

    @JsonProperty
    int x;

    @JsonProperty
    int y;
}