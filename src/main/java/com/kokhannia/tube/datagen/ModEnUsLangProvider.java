package com.kokhannia.tube.datagen;

import com.kokhannia.tube.TubeCraft;
import com.kokhannia.tube.block.ModBlocks;
import com.kokhannia.tube.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput output) {
        super(output, TubeCraft.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //samples
//        add(ModItems.CHARCOAL_CALCULI.get(), "Charcoal Calculi");
//        add(ModBlocks.PLASTIC_GRAVEL.get(), "Plastic Gravel");
//        add("itemGroup.tubecraft_tab", "TubeCraft");
    }
}
