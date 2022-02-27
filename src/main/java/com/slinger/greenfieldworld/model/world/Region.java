package com.slinger.greenfieldworld.model.world;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import lombok.Getter;

public abstract class Region {

    @Getter
    private final Coordinate coordinate;

    @Getter
    private final RegionName regionName;

    @Getter
    private boolean northExitAvailable = true;

    @Getter
    private boolean eastExitAvailable = true;

    @Getter
    private boolean southExitAvailable = true;

    @Getter
    private boolean westExitAvailable = true;

    protected Region(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.regionName = setRegionName();
    }

    /* TODO: Maybe moving should be entirely handled by an dedicated action or movement class?*/
    public Coordinate move(Direction direction) {

        int xShift = 0;
        int yShift = 0;

        switch (direction) {

            case NORTH:
                if (northExitAvailable)
                    yShift = -1;
                break;

            case EAST:
                if (eastExitAvailable)
                    xShift = 1;
                break;

            case SOUTH:
                if (southExitAvailable)
                    yShift = 1;
                break;

            case WEST:
                if (westExitAvailable)
                    xShift = -1;
                break;

            default:
                throw new SwitchCaseNotDefinedException(MessageUtil.format("Case {0} not found.", direction));
        }

        return Coordinate.of(coordinate.getX() + xShift, coordinate.getY() + yShift);
    }

    abstract RegionName setRegionName();
}