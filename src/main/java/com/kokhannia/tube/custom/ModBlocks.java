package com.kokhannia.tube.custom;

import com.kokhannia.tube.TubeCraft;
import com.kokhannia.tube.block.GravityBlock;
import com.kokhannia.tube.block.TubeMachineBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TubeCraft.MOD_ID);

    public static final DeferredBlock<Block> PLASTIC_GRAVEL = registerBlock("plastic_gravel",
            () -> new GravityBlock(BlockBehaviour.Properties.of()
                    .strength(0.6f, 0.7f)
                    .sound(SoundType.GRAVEL)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> NETHER_PLASTIC_GRAVEL = registerBlock("nether_plastic_gravel",
            () -> new GravityBlock(BlockBehaviour.Properties.of()
                    .strength(0.6f, 0.7f)
                    .sound(SoundType.GRAVEL)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> TUBE_BLOCK = registerBlock("tube_block",
            () -> new Block(Block.Properties.of()
                    .strength(1.0f, 2.0f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> TUBE_MACHINE = registerBlock("tube_machine",
            () -> new TubeMachineBlock(BlockBehaviour.Properties.of()
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
