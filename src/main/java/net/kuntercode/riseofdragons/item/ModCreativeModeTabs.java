package net.kuntercode.riseofdragons.item;

import net.kuntercode.riseofdragons.RiseOfDragons;
import net.kuntercode.riseofdragons.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RiseOfDragons.MOD_ID);

    public static final Supplier<CreativeModeTab> VENGESTONE_ITEMS_TAB = CREATIVE_MODE_TAB.register("vengestone_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.VENGESTONE_INGOT.get()))
                    .title(Component.translatable("creativetab.riseofdragons.vengestone_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RAW_VENGESTONE);
                        output.accept(ModItems.VENGESTONE_INGOT);
                        output.accept(ModItems.VENGESTONE_NUGGET);

                        output.accept(ModBlocks.VENGESTONE_BLOCK);
                        output.accept(ModBlocks.VENGESTONE_ORE);
                        output.accept(ModBlocks.DEEPSLATE_VENGESTONE_ORE);

                    })

                    .build());

    public static final Supplier<CreativeModeTab> WEAPONS_ITEMS_TAB = CREATIVE_MODE_TAB.register("weapons_items_tab",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RiseOfDragons.MOD_ID, "vengestone_items_tab"))
                    .icon(() -> new ItemStack(ModBlocks.VENGESTONE_BLOCK.get()))
                    .title(Component.translatable("creativetab.riseofdragons.weapons_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.VENGESTONE_INGOT);
                        output.accept(ModItems.DRAGON_CHISEL);

                    })

                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
