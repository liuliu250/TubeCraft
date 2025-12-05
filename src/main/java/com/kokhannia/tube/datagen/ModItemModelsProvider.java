package com.kokhannia.tube.datagen;

import com.kokhannia.tube.TubeCraft;
import com.kokhannia.tube.custom.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelsProvider extends ItemModelProvider {
    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TubeCraft.MOD_ID, existingFileHelper);
    }

    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    @Override
    protected void registerModels() {
        //samples
//        basicItem(ModItems.PLASTIC_CHUNK.get());
//        trimmedArmorItem(ModItems.TUBE_HELMET);
//        trimmedArmorItem(ModItems.TUBE_CHESTPLATE);
//        trimmedArmorItem(ModItems.TUBE_LEGGINGS);
//        trimmedArmorItem(ModItems.TUBE_BOOTS);
    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> item) {
        final String MOD_ID = TubeCraft.MOD_ID; // Change this to your mod id

        ArmorItem armorItem = item.get();
        trimMaterials.forEach((trimMaterial, value) -> {
            float trimValue = value;

            String armorType = switch (armorItem.getEquipmentSlot()) {
                case HEAD -> "helmet";
                case CHEST -> "chestplate";
                case LEGS -> "leggings";
                case FEET -> "boots";
                default -> "";
            };

            String armorItemPath = armorItem.toString();
            String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
            String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
            ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
            ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace fuck!
            ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

            // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
            // avoid an IllegalArgumentException
            existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

            // Trimmed armorItem files
            getBuilder(currentTrimName)
                    .parent(new ModelFile.UncheckedModelFile("item/generated"))
                    .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                    .texture("layer1", trimResLoc);

            // Non-trimmed armorItem file (normal variant)
            this.withExistingParent(item.getId().getPath(), mcLoc("item/generated"))
                    .override()
                    .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                    .predicate(ResourceLocation.parse("trim_type"), trimValue).end()
                    .texture("layer0", ResourceLocation.fromNamespaceAndPath(MOD_ID, "item/" + item.getId().getPath()));
        });
    }

}
