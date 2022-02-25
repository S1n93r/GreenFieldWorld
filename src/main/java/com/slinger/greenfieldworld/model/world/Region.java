package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public abstract class Region {

    @Getter
    private final Coordinate coordinate;

    @Getter
    private final RegionName regionName;

    @Builder.Default
    private boolean hasNorthExit = true;

    @Builder.Default
    private boolean hasEastExit = true;

    @Builder.Default
    private boolean hasSouthExit = true;

    @Builder.Default
    private boolean hasWestExit = true;

    /* TODO: Maybe moving should be entirely handled by an dedicated action or movement class?*/
    public Coordinate move(Direction direction) {

        int xShift = 0;
        int yShift = 0;

        switch (direction) {

            case NORTH:
                if (hasNorthExit)
                    yShift = -1;
                break;

            case EAST:
                if (hasEastExit)
                    xShift = 1;
                break;

            case SOUTH:
                if (hasSouthExit)
                    yShift = 1;
                break;

            case WEST:
                if (hasWestExit)
                    xShift = -1;
                break;

            default:
                throw new SwitchCaseNotDefinedException(MessageUtil.format("Case {0} not found.", direction));
        }

        return Coordinate.of(coordinate.getX() + xShift, coordinate.getY() + yShift);
    }
}