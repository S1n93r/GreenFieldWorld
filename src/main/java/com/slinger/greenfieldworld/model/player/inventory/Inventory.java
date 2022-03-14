package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.common.MessageUtil;
import com.slinger.greenfieldworld.model.exceptions.SwitchCaseNotDefinedException;
import com.slinger.greenfieldworld.model.items.Item;
import com.slinger.greenfieldworld.model.items.storage.Backpack;
import com.slinger.greenfieldworld.model.items.storage.BeltBag;
import com.slinger.greenfieldworld.model.player.inventory.equipment.*;

public class Inventory {

    private final HeadSlot headSlot = new HeadSlot();
    private final ChestSlot chestSlot = new ChestSlot();
    private final LegsSlot legsSlot = new LegsSlot();

    private final AccessorySlot accessorySlotA = new AccessorySlot();
    private final AccessorySlot accessorySlotB = new AccessorySlot();

    private final BackpackSlot backpackSlot = new BackpackSlot();
    private final BeltBagSlot beltBagSlot = new BeltBagSlot();

    public String storeInBackpack(Item item) {
        return backpackSlot.store(item);
    }

    public String storeInBeltBag(Item item) {
        return beltBagSlot.store(item);
    }

    public String equip(Item item) {

        if (item instanceof Backpack) {

            /* TODO: Needs to go to hand slot, when stripped of. */
            Backpack previousBackpack = backpackSlot.equip((Backpack) item);

            if (previousBackpack == null)
                return MessageUtil.format("You put {0} on your back.", item.getNameWithArticle());
            else
                return MessageUtil.format("You swap your old {0} for a new {1}.",
                        previousBackpack.getName(), item.getName());

        } else if (item instanceof BeltBag) {

            /* TODO: Needs to go to hand slot, when stripped of. */
            BeltBag previousBeltBag = beltBagSlot.equip((BeltBag) item);

            if (previousBeltBag == null)
                return MessageUtil.format("You strap {0} to your belt.", item.getNameWithArticle());
            else
                return MessageUtil.format("You swap your old {0} for a new {1}.",
                        previousBeltBag.getName(), item.getName());
        }

        throw new SwitchCaseNotDefinedException("The item you try to equip is of a type not known to the equip " +
                "function.");
    }
}