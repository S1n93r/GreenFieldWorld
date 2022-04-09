package com.slinger.greenfieldworld.model.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.storage.LootBag;
import com.slinger.greenfieldworld.model.player.actions.Action;
import com.slinger.greenfieldworld.model.player.actions.check.Check;
import com.slinger.greenfieldworld.model.player.actions.equip.Equip;
import com.slinger.greenfieldworld.model.player.actions.gather.Gather;
import com.slinger.greenfieldworld.model.player.actions.look.Look;
import com.slinger.greenfieldworld.model.player.actions.move.Move;
import com.slinger.greenfieldworld.model.player.actions.unequip.Remove;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;
import com.slinger.greenfieldworld.model.world.World;
import com.slinger.greenfieldworld.model.world.regions.Region;
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

    private final Inventory inventory = new Inventory();

    @Setter
    @JsonIgnore
    private Region region;

    @Getter
    @JsonIgnore
    private World world;

    @Getter
    @Setter
    @JsonIgnore
    private LootBag availableLootBag;

    protected Player(String name) {

        this.name = name;

        addBasicActions();
    }

    private void addBasicActions() {

        addAction(new Move(this));
        addAction(new Look(this));
        addAction(new Check(this, inventory));
        addAction(new Equip(this, inventory));
        addAction(new Remove(this, inventory));
        addAction(new Gather(this, inventory));
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