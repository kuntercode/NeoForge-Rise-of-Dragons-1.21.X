package net.kuntercode.riseofdragons.item;

import net.kuntercode.riseofdragons.RiseOfDragons;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RiseOfDragons.MOD_ID);


    public static final DeferredItem<Item> VENGESTONE = ITEMS.register("vengestone",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
