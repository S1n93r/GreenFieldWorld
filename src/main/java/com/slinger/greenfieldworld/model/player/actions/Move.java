package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.Direction;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.regions.Region;

public class Move extends Action {

    private static final String TRIGGER_WORD = "move";

    public Move(Player player) {
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
                return MessageUtil.format("You did not move.");

            default:
                throw new SwitchCaseNotDefinedException(MessageUtil.format("Case {0} not found.", direction));
        }

        World world = player.getWorld();

        Region targetRegion = world.getRegion(Coordinate.of(
                currentRegion.getCoordinate().getX() + xShift,
                currentRegion.getCoordinate().getY() + yShift));

        if (targetRegion == null)
            return MessageUtil.format("Border reached. You can't go {0} from here.", direction);

        player.setRegion(targetRegion);

        return MessageUtil.format("You move {0}.", direction);
    }
}