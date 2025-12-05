package com.kokhannia.tube.datagen;

import com.kokhannia.tube.TubeCraft;
import com.kokhannia.tube.custom.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TubeCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //samples
//        tag(BlockTags.MINEABLE_WITH_PICKAXE)
//                .add(ModBlocks.TUBE_BLOCK.get());
//        tag(ModTags.NEEDS_TUBE_TOOL)
//                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
//        tag(ModTags.INCORRECT_FOR_TUBE_TOOL)
//                .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
//                .remove(ModTags.INCORRECT_FOR_TUBE_TOOL);
    }
}
