package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.Direction;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.regions.Region;

public class Look extends Action {

    public static final String LOOK_DIRECTION_PROMPT = "You look {0} and see a {1}.";
    private static final String TRIGGER_WORD = "look";

    public Look(Player player) {
        super(player);
    }

    @Override
    String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        Direction direction = Direction.fromString(parameter);

        Region currentRegion = player.getRegion();

        int xShift = 0;
        int yShift = 0;

        switch (direction) {

            case NORTH:
                yShift = -1;
                break;

            case EAST:
                xShift = 1;
                break;

            case SOUTH:
                yShift = 1;
                break;

            case WEST:
                xShift = -1;
                break;

            case NONE:
                return MessageUtil.format("You did not look in any direction.");

            default:
                throw new SwitchCaseNotDefinedException(MessageUtil.format("Case {0} not found.", direction));
        }

        World world = player.getWorld();

        Region targetRegion = world.getRegion(Coordinate.of(
                currentRegion.getCoordinate().getX() + xShift,
                currentRegion.getCoordinate().getY() + yShift));

        if (targetRegion == null)
            return MessageUtil.format("To the {0} you can see... The end of the world.", direction);

        return MessageUtil.format(LOOK_DIRECTION_PROMPT, direction, targetRegion.getRegionTypeName());
    }
}