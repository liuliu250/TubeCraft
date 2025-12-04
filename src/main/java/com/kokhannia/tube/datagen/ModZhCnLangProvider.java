package com.kokhannia.tube.datagen;

import com.kokhannia.tube.TubeCraft;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModZhCnLangProvider extends LanguageProvider {
    public ModZhCnLangProvider(PackOutput output) {
        super(output, TubeCraft.MOD_ID, "zh_cn");
    }

    @Override
    protected void addTranslations() {
        //samples same as ModEnUsLangProvider
    }
}
