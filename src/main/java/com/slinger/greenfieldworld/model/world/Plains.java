package com.slinger.greenfieldworld.model.world;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(access = AccessLevel.PACKAGE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plains {

    @Getter
    private final RegionName regionName = RegionName.PLAINS;

    @Getter
    private long id;

    private Plains(long id) {
        this.id = id;
    }
}