package com.slinger.greenfieldworld.model.player.actions.unequip;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.player.Player;
import com.slinger.greenfieldworld.model.player.actions.InventoryInteraction;
import com.slinger.greenfieldworld.model.player.inventory.Inventory;
import com.slinger.greenfieldworld.model.player.inventory.equipment.BackpackSlot;
import com.slinger.greenfieldworld.model.player.inventory.equipment.BeltBagSlot;
import com.slinger.greenfieldworld.model.player.inventory.equipment.EquipmentSlot;

public class Remove extends InventoryInteraction {

    private static final String TRIGGER_WORD = "remove";

    private static final String OUTPUT_SLOT_IS_EMPTY = "You don't wear anything on your {0}.";

    private static final String OUTPUT_ACTION_PARAM_UNKNOWN = "You don't know how to remove '{0}'.";

    private static final String OUTPUT_REMOVE_SUCCESS_THE = "You remove your {0} from your {1} and put it to the {2}.";
    private static final String OUTPUT_REMOVE_SUCCESS_YOUR = "You remove your {0} from your {1} and put it to your " +
            "{2}.";

    public Remove(Player player, Inventory inventory) {
        super(player, inventory);
    }

    @Override
    protected String setTriggerWord() {
        return TRIGGER_WORD;
    }

    @Override
    public String use(String parameter) {

        RemoveParam removeParam = RemoveParam.fromString(parameter);

        switch (removeParam) {

            case ACCESSORY_ONE:
            case ACCESSORY_TWO:
                return removeBySlot(inventory.getAccessorySlots());

            case BODY_ARMOR:
                return removeBySlot(inventory.getBodyArmorSlot());

            case HEADGEAR:
                return removeBySlot(inventory.getHeadgearSlot());

            case LEG_ARMOR:
                return removeBySlot(inventory.getLegArmorSlot());

            case UNKNOWN:
                return MessageUtil.format(OUTPUT_ACTION_PARAM_UNKNOWN, parameter);

            default:
                throw new SwitchCaseNotDefinedException();
        }
    }

    private String removeBySlot(EquipmentSlot<?> equipmentSlot) {

        Item removedItem = equipmentSlot.remove();

        /* TODO: EquipmentSlot type needed here. */
        if (removedItem == null)
            return MessageUtil.format(OUTPUT_SLOT_IS_EMPTY, equipmentSlot);

        BackpackSlot backpack = inventory.getBackpackSlot();
        BeltBagSlot beltBag = inventory.getBeltBagSlot();

        String bagNameForItemDrop;

        if (backpack.hasBagSpace()) {

            backpack.store(removedItem);
            bagNameForItemDrop = backpack.getBagName();

        } else if (beltBag.hasSpace()) {

            beltBag.store(removedItem);
            bagNameForItemDrop = beltBag.getBagName();

        } else
            return MessageUtil.format(OUTPUT_REMOVE_SUCCESS_THE, removedItem.getName(), equipmentSlot.getClass(),
                    player.getRegion().getRegionInventory().getName());


        /* TODO: Add slot type name to EquipmentSlot class. */
        return MessageUtil.format(OUTPUT_REMOVE_SUCCESS_YOUR, removedItem.getName(), equipmentSlot.getClass(),
                bagNameForItemDrop);
    }
}