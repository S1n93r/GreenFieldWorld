package com.slinger.greenfieldworld.model.world.regions.resources;

import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.tools.BareHanded;
import com.slinger.greenfieldworld.model.items.tools.Tool;

import java.util.ArrayList;
import java.util.List;

public class ResourceDeposit {

    private final List<Resource> availableResources = new ArrayList<>();

    public void addResource(Resource resource) {
        availableResources.add(resource);
    }

    public List<Item> gather() {
        return gather(new BareHanded());
    }

    public List<Item> gather(Tool tool) {

        List<Item> gatheredItems = new ArrayList<>();

        for (Resource resource : availableResources) {

            Item item = resource.gather(tool);

            if (item != null)
                gatheredItems.add(item);
        }

        return gatheredItems;
    }
}