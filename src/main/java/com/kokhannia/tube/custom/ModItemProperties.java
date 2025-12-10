package com.kokhannia.tube.custom;

import com.kokhannia.tube.TubeCraft;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {

    public static void addItemProperties() {

        ItemProperties.register(ModItems.TUBE_WAND.get(), ResourceLocation.fromNamespaceAndPath(TubeCraft.MOD_ID, "used"),
                ((stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1.0f : 0.0f));

    }

}
