package com.kokhannia.tube.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {

    public static final TagKey<Block> NEEDS_TUBE_TOOL = Blocks.create("minecraft", "needs_tube_tool");
    public static final TagKey<Block> INCORRECT_FOR_TUBE_TOOL = Blocks.create("minecraft", "incorrect_for_tube_tool");

    public static class Blocks {
        public static TagKey<Block> create(String namespace, String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(namespace, name));
        }
    }

    public static class Items {
        public static TagKey<Item> create(String namespace, String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(namespace, name));
        }
    }

}
