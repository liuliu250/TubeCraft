package com.kokhannia.tube.datagen;

import com.kokhannia.tube.TubeCraft;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStatesProvider extends BlockStateProvider {
    public ModBlockStatesProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TubeCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        //samples
//        simpleBlockWithItem(ModBlocks.TUBE_BLOCK.get(), cubeAll(ModBlocks.TUBE_BLOCK.get()));
    }
}
