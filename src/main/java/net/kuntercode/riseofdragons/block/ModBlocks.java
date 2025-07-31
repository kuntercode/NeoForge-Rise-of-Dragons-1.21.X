package net.kuntercode.riseofdragons.block;

import net.kuntercode.riseofdragons.RiseOfDragons;
import net.kuntercode.riseofdragons.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RiseOfDragons.MOD_ID);


    public static final DeferredBlock<Block> VENGESTONE_BLOCK = registerBlock("vengestone_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    public static final DeferredBlock<Block> VENGESTONE_ORE = registerBlock("vengestone_ore",
            () -> new DropExperienceBlock(UniformInt.of(6, 9),
                    BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));


    public static final DeferredBlock<Block> DEEPSLATE_VENGESTONE_ORE = registerBlock("deepslate_vengestone_ore",
            () -> new DropExperienceBlock(UniformInt.of(10, 13),
                    BlockBehaviour.Properties.of().strength(8f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
