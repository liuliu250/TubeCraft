package com.kokhannia.tube.worldgen;

import com.kokhannia.tube.TubeCraft;
import com.kokhannia.tube.custom.ModBlocks;
import com.kokhannia.tube.custom.ModTags;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> O_PLASTIC_GRAVEL_KEY = registerKey("plastic_gravel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> N_PLASTIC_GRAVEL_KEY = registerKey("nether_plastic_gravel");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest oReplaceables = new TagMatchTest(ModTags.GRAVEL_ORE_REPLACEABLES);
        RuleTest nReplaceables = new TagMatchTest(ModTags.NETHER_GRAVEL_ORE_REPLACEABLES);
        //same as end stone

        List<OreConfiguration.TargetBlockState> overworldPlasticGravels = List.of(
                OreConfiguration.target(oReplaceables, ModBlocks.PLASTIC_GRAVEL.get().defaultBlockState())
//                OreConfiguration.target(oReplaceables, ModBlocks.DEEP_PLASTIC_GRAVEL.get().defaultBlockState())
        );//deepslate version added here if needed
        register(context, O_PLASTIC_GRAVEL_KEY, Feature.ORE, new OreConfiguration(overworldPlasticGravels, 10));
        register(context, N_PLASTIC_GRAVEL_KEY, Feature.ORE, new OreConfiguration(nReplaceables, ModBlocks.PLASTIC_GRAVEL.get().defaultBlockState(), 6));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {;
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(TubeCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
