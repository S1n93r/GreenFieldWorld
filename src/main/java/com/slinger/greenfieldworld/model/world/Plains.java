package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Getter
@Jacksonized
@SuperBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plains extends Region {
    private final long id;
}