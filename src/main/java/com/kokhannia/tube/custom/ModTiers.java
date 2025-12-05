package com.kokhannia.tube.custom;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModTiers {
    public static final Tier TUBE = new SimpleTier(
            ModTags.INCORRECT_FOR_TUBE_TOOL,
            2346,
            10.0f,
            5.0f,
            25,
            () -> Ingredient.of(ModItems.HARDENED_TUBE)
    );
}
