package com.slinger.greenfieldworld.model.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.world.Region;
import com.slinger.greenfieldworld.model.world.World;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {

    @Getter
    @JsonIgnore
    private final Map<String, Action> availableActions = new HashMap<>();

    @Getter
    private final String name;

    @Setter
    @JsonIgnore
    private Region region;

    @Getter
    @JsonIgnore
    private World world;

    protected Player(String name) {

        this.name = name;

        addBasicActions();
    }

    private void addBasicActions() {
        addAction(new Move(this));
    }

    public void spawn(World world, Region region) {
        this.world = world;
        this.region = region;
    }

    public Region getRegion() {

        if (region == null)
            throw new IllegalStateException(MessageUtil.format("Region not set. Player {0} was not spawned" +
                    " in world."));

        return region;
    }

    public void addAction(Action action) {
        availableActions.put(action.getTriggerWord(), action);
    }

    public Action getAction(String input) {
        return availableActions.get(input);
    }
}