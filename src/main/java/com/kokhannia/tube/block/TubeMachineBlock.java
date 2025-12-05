package com.kokhannia.tube.block;

import com.kokhannia.tube.custom.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TubeMachineBlock extends RotatedPillarBlock {

    // 每个方块的声音冷却记录（客户端使用）
    private static final Map<BlockPos, Long> LAST_SOUND_TICK = new ConcurrentHashMap<>();
    // 冷却时间，单位为游戏刻（20 ticks = 1 秒）
    private static final long SOUND_COOLDOWN_TICKS = 30L; // 1.5 秒

    public TubeMachineBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (heldItem.getItem() == ModItems.TUBE.get()) {
            player.setItemInHand(hand, new ItemStack(ModItems.WATER_TUBE.get(), heldItem.getCount()));
            level.playSound(player, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0f, 1.0f);
        } else if (heldItem.getItem() == ModItems.WATER_TUBE.get()) {
            player.setItemInHand(hand, new ItemStack(ModItems.TUBE.get(), heldItem.getCount()));
            level.playSound(player, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0f, 1.0f);
        }
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem() == Items.COAL) {
                itemEntity.setItem(new ItemStack(ModItems.CHARCOAL_CALCULI.get(), itemEntity.getItem().getCount()));
                level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        }

        if (entity instanceof Player) {
            if (level.isClientSide()) {
                double cx = pos.getX() + 0.5;
                double cz = pos.getZ() + 0.5;
                // 把粒子生成在方块上方的不同高度，让粒子使用内置的下落速度（FALLING_WATER 自带下落行为）
                for (int i = 0; i < 6; i++) {
                    double ox = (Math.random() - 0.5) * 0.8;
                    double oz = (Math.random() - 0.5) * 0.8;
                    double px = cx + ox;
                    // 在 0.2 到 1.2 的高度区间生成，使其看起来像从上方滴落
                    double py = pos.getY() + 2.8 + Math.random() * 0.3;
                    double pz = cz + oz;
                    // 传入速度为 0，让粒子自身的下落逻辑生效
                    level.addParticle(ParticleTypes.FALLING_WATER, px, py, pz, 0.0, 0.0, 0.0);
                }

                long now = level.getGameTime();
                Long last = LAST_SOUND_TICK.get(pos);
                if (last == null || now - last >= SOUND_COOLDOWN_TICKS) {
                    entity.playSound(SoundEvents.WATER_AMBIENT, 1.0f, 1.0f);
                    LAST_SOUND_TICK.put(pos.immutable(), now);
                }
            }
        }

        super.stepOn(level, pos, state, entity);
    }

}
