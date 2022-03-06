package com.slinger.greenfieldworld.model.world.regions;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode
@AllArgsConstructor(staticName = "of")
public class RegionName {

    String regionName;

}