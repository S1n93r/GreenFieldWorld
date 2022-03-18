package com.slinger.greenfieldworld.model.player.actions;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;
import com.slinger.greenfieldworld.model.player.inventory.equipment.BackpackSlot;
import com.slinger.greenfieldworld.model.player.inventory.equipment.BeltBagSlot;

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

        return equipITem(item);
    }

    private String equipByItemIndex(int itemIndex) {
        Item item = null;

        if (player.getAvailableLootBag() != null)
            item = player.getAvailableLootBag().fetchItem(itemIndex);

        if (item == null)
            inventory.fetchItem(itemIndex);

        if (item == null)
            return MessageUtil.format("Item at index '{0}' not found.", itemIndex);

        return equipITem(item);
    }

    private String equipITem(Item item) {

        Item previousItemEquipped = inventory.equip(item);

        if (previousItemEquipped == null)
            return MessageUtil.format("You equip {0}.", item.getNameWithArticle());

        BackpackSlot backpack = inventory.getBackpackSlot();
        BeltBagSlot beltBag = inventory.getBeltBagSlot();

        if (backpack.hasBagSpace()) {

            backpack.store(previousItemEquipped);

            return MessageUtil.format("You put your old {0} into your {1} and equip your new {2}.",
                    previousItemEquipped.getName(), backpack.getBagName(), item.getName());

        } else if (beltBag.hasSpace()) {

            backpack.store(previousItemEquipped);

            return MessageUtil.format("You put your old {0} into your {1} and equip your new {2}.",
                    previousItemEquipped.getName(), beltBag.getBagName(), item.getName());

        } else {

            if (player.getAvailableLootBag() == null)
                throw new IllegalStateException("The loot bag can only be null if the item was equipped from either " +
                        "backpack or belt bag. For some reason back pack and belt bag are full after equipping.");

            return MessageUtil.format("You put away your old {} and equip a new {}.",
                    previousItemEquipped.getName(), item.getName());
        }
    }
}