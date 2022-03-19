package com.slinger.greenfieldworld.model.player.actions.move;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.regions.Region;

public class Move extends Action {

    private static final String TRIGGER_WORD = "move";

    public Move(Player player) {
        super(player);
    }

    @Override
    protected String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        MoveParam moveParam = MoveParam.fromString(parameter);

        Region currentRegion = player.getRegion();

        int xShift = 0;
        int yShift = 0;

        switch (moveParam) {

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

            default:
                return MessageUtil.format("You did not move.");
        }

        World world = player.getWorld();

        Region targetRegion = world.getRegion(Coordinate.of(
                currentRegion.getCoordinate().getX() + xShift,
                currentRegion.getCoordinate().getY() + yShift));

        if (targetRegion == null)
            return MessageUtil.format("Border reached. You can't go {0} from here.", moveParam);

        player.setRegion(targetRegion);

        return MessageUtil.format("You move {0}.", moveParam);
    }
}