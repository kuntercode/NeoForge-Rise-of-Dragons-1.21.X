package net.kuntercode.riseofdragons.item;

import net.kuntercode.riseofdragons.RiseOfDragons;
import net.kuntercode.riseofdragons.item.custom.DragonChiselItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RiseOfDragons.MOD_ID);


    public static final DeferredItem<Item> VENGESTONE_INGOT = ITEMS.register("vengestone_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> VENGESTONE_NUGGET = ITEMS.register("vengestone_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_VENGESTONE = ITEMS.register("raw_vengestone",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> DRAGON_CHISEL = ITEMS.register("dragon_chisel",
            () -> new DragonChiselItem(new Item.Properties().durability(32)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
