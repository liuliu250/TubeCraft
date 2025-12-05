package com.kokhannia.tube.worldgen;

import com.kokhannia.tube.TubeCraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> PLASTIC_GRAVEL_PLACED_KEY = registerKey("plastic_gravel_placed");
    public static final ResourceKey<PlacedFeature> NETHER_PLASTIC_GRAVEL_PLACED_KEY = registerKey("nether_plastic_gravel_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PLASTIC_GRAVEL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.O_PLASTIC_GRAVEL_KEY),
                ModOrePlacement.commonOrePlacement(16, HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80)
                )));
        register(context, NETHER_PLASTIC_GRAVEL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.N_PLASTIC_GRAVEL_KEY),
                ModOrePlacement.commonOrePlacement(16, HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(6), VerticalAnchor.absolute(128)
                )));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(TubeCraft.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
