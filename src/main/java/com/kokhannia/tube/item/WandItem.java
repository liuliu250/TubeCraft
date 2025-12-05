package com.kokhannia.tube.item;

import com.kokhannia.tube.custom.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class WandItem extends Item {
    private static final Map<Block, Block> WAND_MAP = Map.of(
            Blocks.GRAVEL, ModBlocks.PLASTIC_GRAVEL.get(),
            Blocks.DIAMOND_BLOCK, ModBlocks.TUBE_BLOCK.get()
    );


    public WandItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block blockClicked = level.getBlockState(context.getClickedPos()).getBlock();

        if(WAND_MAP.containsKey(blockClicked)) {
            if(!level.isClientSide()) {
                Block newBlock = WAND_MAP.get(blockClicked);
                level.setBlockAndUpdate(context.getClickedPos(), newBlock.defaultBlockState());
                context.getItemInHand().hurtAndBreak(1, (ServerLevel) level, context.getPlayer(),
                        item -> {
                            if (context.getPlayer() != null) context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
                        });
                level.playSound(null, context.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
            }
            return InteractionResult.sidedSuccess(level.isClientSide());
        }

        return super.useOn(context);
    }
}
