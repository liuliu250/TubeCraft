package com.kokhannia.tube.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;

public class GravityBlock extends FallingBlock {
    public GravityBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return MapCodec.unit(this);
    }
}
