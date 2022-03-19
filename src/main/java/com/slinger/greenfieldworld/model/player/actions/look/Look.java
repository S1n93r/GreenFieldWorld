package com.slinger.greenfieldworld.model.player.actions.look;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.Action;
import com.slinger.greenfieldworld.model.world.Coordinate;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.regions.Region;

public class Look extends Action {

    protected static final String LOOK_DIRECTION_PROMPT = "You look {0} and see a {1}.";
    protected static final String TRIGGER_WORD = "look";

    public Look(Player player) {
        super(player);
    }

    @Override
    protected String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        LookParam lookParam = LookParam.fromString(parameter);

        Region currentRegion = player.getRegion();

        int xShift = 0;
        int yShift = 0;

        switch (lookParam) {

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
                return MessageUtil.format("You did not look in any direction.");
        }

        World world = player.getWorld();

        Region targetRegion = world.getRegion(Coordinate.of(
                currentRegion.getCoordinate().getX() + xShift,
                currentRegion.getCoordinate().getY() + yShift));

        if (targetRegion == null)
            return MessageUtil.format("To the {0} you can see... The end of the world.", lookParam);

        return MessageUtil.format(LOOK_DIRECTION_PROMPT, lookParam, targetRegion.getRegionTypeName());
    }
}