package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.Backpack;
import com.slinger.greenfieldworld.model.items.storage.BeltBag;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;

public class Equip extends InventoryInteraction {

    private static final String TRIGGER_WORD = "equip";

    public Equip(Player player, Inventory inventory) {
        super(player, inventory);
    }

    @Override
    String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        if (parameter.replaceAll("[0-9]", "").length() == 0)
            return equipByItemIndex(Integer.parseInt(parameter));
        else
            return equipByItemName(parameter);
    }

    private String equipByItemName(String itemName) {

        Item item = null;

        if (player.getAvailableLootBag() != null)
            item = player.getAvailableLootBag().fetchItem(itemName);

        if (item == null)
            inventory.fetchItem(itemName);

        if (item == null)
            return MessageUtil.format("Item '{0}' not found.", itemName);

        Item previousItemEquipped = inventory.equip(item);

        if (previousItemEquipped == null)
            return MessageUtil.format("You equip {0}.", item.getNameWithArticle());

        Backpack backpack = inventory.getBackpackSlot().getItem();
        BeltBag beltBag = inventory.getBeltBagSlot().getItem();

        if (backpack.hasSpace()) {

            backpack.store(previousItemEquipped);

            return MessageUtil.format("You put your old {0} into your {1} and equip your new {2}.",
                    previousItemEquipped.getName(), backpack.getName(), item.getName());

        } else if (beltBag.hasSpace()) {

            backpack.store(previousItemEquipped);

            return MessageUtil.format("You put your old {0} into your {1} and equip your new {2}.",
                    previousItemEquipped.getName(), beltBag.getName(), item.getName());

        } else {

            if (player.getAvailableLootBag() == null)
                throw new IllegalStateException("The loot bag can only be null if the item was equipped from either " +
                        "backpack or belt bag. For some reason back pack and belt bag are full after equipping.");

            return MessageUtil.format("You put away your old {} and equip a new {}.",
                    previousItemEquipped.getName(), item.getName());
        }
    }

    private String equipByItemIndex(int itemIndex) {
        return MessageUtil.format("");
    }
}