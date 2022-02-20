package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(access = AccessLevel.PACKAGE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class World {

    @Getter
    private long id;

    @Getter
    private String name;
}