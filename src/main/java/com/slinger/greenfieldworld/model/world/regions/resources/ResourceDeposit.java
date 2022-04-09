package com.slinger.greenfieldworld.model.world.regions.resources;

import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.tools.BareHanded;
import com.slinger.greenfieldworld.model.items.tools.Tool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResourceDeposit {

    private final List<Resource<? extends Item>> availableResources = new ArrayList<>();

    public ResourceDeposit(Resource<? extends Item>... availableResources) {
        Collections.addAll(this.availableResources, availableResources);
    }

    public List<Item> gather() {
        return gather(new BareHanded());
    }

    public List<Item> gather(Tool tool) {

        List<Item> gatheredItems = new ArrayList<>();

        for (Resource<? extends Item> resource : availableResources) {

            Item item = resource.gather(tool);

            if (item != null)
                gatheredItems.add(item);
        }

        return gatheredItems;
    }
}