package com.slinger.greenfieldworld.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.Direction;
import com.slinger.greenfieldworld.model.world.Region;
import com.slinger.greenfieldworld.model.world.World;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder(access = AccessLevel.PROTECTED)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @Getter
    private final String name;

    @Getter
    private Region currentRegion;

    private Player(String name, Region currentRegion) {
        this.name = name;
        this.currentRegion = currentRegion;
    }

    public void spawn(Region region) {
        currentRegion = region;
    }

    public String move(World world, Direction direction) {

        Coordinate currentPosition = currentRegion.getCoordinate();

        Coordinate targetPosition = currentRegion.move(direction);

        if (targetPosition.equals(currentPosition))
            return MessageUtil.format("You can't got {0} from here.", direction);

        Region previousRegion = currentRegion;

        currentRegion = world.getRegion(targetPosition);

        return MessageUtil.format("You moved from region {} ({}) to {} ({})", previousRegion, currentPosition,
                currentRegion, targetPosition);
    }
}