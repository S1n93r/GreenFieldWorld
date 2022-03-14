package com.slinger.greenfieldworld.model.player.inventory;

import com.slinger.greenfieldworld.model.common.MessageUtil;
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
            backpackSlot.equip((Backpack) item);
            return MessageUtil.format("You put {0} on your back.", item.getNameWithArticle());
        } else if (item instanceof BeltBag) {
            beltBagSlot.equip((BeltBag) item);
            return MessageUtil.format("You strap {0} to your belt.", item.getNameWithArticle());
        }

        return MessageUtil.format("You can't equip {0} right now.", item.getNameWithArticle());
    }
}