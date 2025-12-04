package com.kokhannia.tube.datagen;

import com.kokhannia.tube.TubeCraft;
import com.kokhannia.tube.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, TubeCraft.MOD_ID, existingFileHelper);
    }

    public static final TagKey<Item> TUBE = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(TubeCraft.MOD_ID, "tube"));

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //samples
//        tag(ItemTags.COALS)
//                .add(ModItems.CHARCOAL_CALCULI.get());
//        tag(TUBE)
//                .add(ModItems.TUBE.get())
//                .add(ModItems.WATER_TUBE.get())
//                .add(ModItems.HARDENED_TUBE.get());
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.TUBE_HELMET.get())
                .add(ModItems.TUBE_CHESTPLATE.get())
                .add(ModItems.TUBE_LEGGINGS.get())
                .add(ModItems.TUBE_BOOTS.get());
    }
}
