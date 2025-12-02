package com.kokhannia.tube.block;

import com.kokhannia.tube.TubeCraft;
import com.kokhannia.tube.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TubeCraft.MOD_ID);

    public static final DeferredBlock<Block> PLASTIC_GRAVEL = registerBlock("plastic_gravel",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.GRAVEL)
                    ));

    public static final DeferredBlock<Block> TUBE_BLOCK = registerBlock("tube_block",
            () -> new Block(Block.Properties.of()
                    .strength(1.0f, 2.0f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
            ));

    private static <T extends Block> void registerBlockItems(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new BlockItem.Properties()));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> blocks = BLOCKS.register(name, block);
        registerBlockItems(name, blocks);
        return blocks;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
