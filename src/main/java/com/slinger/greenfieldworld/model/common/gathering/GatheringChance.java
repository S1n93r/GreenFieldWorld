package com.slinger.greenfieldworld.model.common.gathering;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor(staticName = "of")
public class GatheringChance {

    int chance;

}