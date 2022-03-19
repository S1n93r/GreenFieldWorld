package com.slinger.greenfieldworld.model.player.actions.equip;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.LootBag;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.InventoryInteraction;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;
import com.slinger.greenfieldworld.model.player.inventory.equipment.BackpackSlot;
import com.slinger.greenfieldworld.model.player.inventory.equipment.BeltBagSlot;

public class Equip extends InventoryInteraction {

    private static final String TRIGGER_WORD = "equip";

    private static final String OUTPUT_ITEM_NAME_NOT_FOUND = "Item '{0}' not found.";
    private static final String OUTPUT_ITEM_INDEX_NOT_FOUND = "Item at index '{0}' not found.";

    private static final String OUTPUT_EQUIP = "You equip {0}.";
    private static final String OUTPUT_EQUIP_SWAP = "You put your old {0} into your {1} and equip your new {2}.";
    private static final String OUTPUT_EQUIP_SWAP_LOOT = "You put your old {0} into the {1} and equip your new {2}.";

    public Equip(Player player, Inventory inventory) {
        super(player, inventory);
    }

    @Override
    protected String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        EquipParam equipParam = EquipParam.fromString(parameter);

        switch (equipParam) {

            case BY_NAME:
                return equipByItemName(parameter);

            case BY_INDEX:
                return equipByItemIndex(Integer.parseInt(parameter));

            default:
                throw new SwitchCaseNotDefinedException();
        }
    }

    private String equipByItemName(String itemName) {

        Item item = null;

        if (player.getAvailableLootBag() != null)
            item = player.getAvailableLootBag().fetchItem(itemName);

        if (item == null)
            item = inventory.fetchItem(itemName);

        if (item == null)
            return MessageUtil.format(OUTPUT_ITEM_NAME_NOT_FOUND, itemName);

        return equipItem(item);
    }

    private String equipByItemIndex(int itemIndex) {
        Item item = null;

        if (player.getAvailableLootBag() != null)
            item = player.getAvailableLootBag().fetchItem(itemIndex);

        if (item == null)
            inventory.fetchItem(itemIndex);

        if (item == null)
            return MessageUtil.format(OUTPUT_ITEM_INDEX_NOT_FOUND, itemIndex);

        return equipItem(item);
    }

    private String equipItem(Item item) {

        Item previousItemEquipped = inventory.equip(item);

        if (previousItemEquipped == null)
            return MessageUtil.format(OUTPUT_EQUIP, item.getNameWithArticle());

        BackpackSlot backpack = inventory.getBackpackSlot();
        BeltBagSlot beltBag = inventory.getBeltBagSlot();

        if (backpack.hasBagSpace()) {

            backpack.store(previousItemEquipped);

            return MessageUtil.format(OUTPUT_EQUIP_SWAP,
                    previousItemEquipped.getName(), backpack.getBagName(), item.getName());

        } else if (beltBag.hasSpace()) {

            beltBag.store(previousItemEquipped);

            return MessageUtil.format(OUTPUT_EQUIP_SWAP, previousItemEquipped.getName(), beltBag.getBagName(),
                    item.getName());

        } else {

            LootBag lootBag = player.getAvailableLootBag();

            if (lootBag == null)
                throw new IllegalStateException("The loot bag can only be null if the item was equipped from either " +
                        "backpack or belt bag. For some reason back pack and belt bag are full after equipping.");

            return MessageUtil.format(OUTPUT_EQUIP_SWAP_LOOT, previousItemEquipped.getName(), lootBag.getName(),
                    item.getName());
        }
    }
}