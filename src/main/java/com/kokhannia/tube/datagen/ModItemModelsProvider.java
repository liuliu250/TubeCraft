package com.kokhannia.tube.datagen;

import com.kokhannia.tube.TubeCraft;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelsProvider extends ItemModelProvider
{
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TubeCraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
