package com.kokhannia.tube.custom;

import com.kokhannia.tube.TubeCraft;
import com.kokhannia.tube.item.WandItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.kokhannia.tube.custom.ModSmithingTemplateItem.*;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TubeCraft.MOD_ID);

    public static final DeferredItem<Item> PLASTIC_CHUNK = ITEMS.register("material/plastic_chunk", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TUBE = ITEMS.register("tube/tube", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WATER_TUBE = ITEMS.register("tube/water_tube", () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));
    public static final DeferredItem<Item> HARDENED_TUBE = ITEMS.register("tube/hardened_tube", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> PLASTIC_PLATE = ITEMS.register("material/plastic_plate", () -> new ModSmithingTemplateItem(
            PLASTIC_UPGRADE_APPLIES_TO,
            PLASTIC_UPGRADE_INGREDIENTS,
            PLASTIC_UPGRADE,
            PLASTIC_UPGRADE_BASE_SLOT_DESCRIPTION,
            PLASTIC_UPGRADE_ADDITIONS_SLOT_DESCRIPTION,
            ModSmithingTemplateItem.emptyUpgradeIconList(),
            ModSmithingTemplateItem.emptyMaterialList()
    ));

    public static final DeferredItem<ArmorItem> TUBE_HELMET = ITEMS.register("armor/tube_helmet",
            () -> new ArmorItem(ModArmorMaterials.TUBE, ArmorItem.Type.HELMET, new Item.Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant()
                    .durability(ArmorItem.Type.HELMET.getDurability(46))));
    public static final DeferredItem<ArmorItem> TUBE_CHESTPLATE = ITEMS.register("armor/tube_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TUBE, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(46))));
    public static final DeferredItem<ArmorItem> TUBE_LEGGINGS = ITEMS.register("armor/tube_leggings",
            () -> new ArmorItem(ModArmorMaterials.TUBE, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(46))));
    public static final DeferredItem<ArmorItem> TUBE_BOOTS = ITEMS.register("armor/tube_boots",
            () -> new ArmorItem(ModArmorMaterials.TUBE, ArmorItem.Type.BOOTS, new Item.Properties()
                    .rarity(Rarity.RARE)
                    .fireResistant()
                    .durability(ArmorItem.Type.BOOTS.getDurability(46))));

    public static final DeferredItem<Item> CHARCOAL_CALCULI = ITEMS.register("material/charcoal_calculi",
            () -> new ModFuelItem(new Item.Properties(), 3200));

    public static final DeferredItem<SwordItem> TUBE_SWORD = ITEMS.register("tool/tube_sword",
            () -> new SwordItem(ModTiers.TUBE, new Item.Properties()
                    .rarity(Rarity.RARE)
                    .attributes(SwordItem.createAttributes(ModTiers.TUBE, 6.0f, -2.2f))
                    .fireResistant()));
    public static final DeferredItem<PickaxeItem> TUBE_PICKAXE = ITEMS.register("tool/tube_pickaxe",
            () -> new PickaxeItem(ModTiers.TUBE, new Item.Properties()
                    .rarity(Rarity.RARE)
                    .attributes(PickaxeItem.createAttributes(ModTiers.TUBE, 1.0f, -2.6f))
                    .fireResistant()));
    public static final DeferredItem<AxeItem> TUBE_AXE = ITEMS.register("tool/tube_axe",
            () -> new AxeItem(ModTiers.TUBE, new Item.Properties()
                    .rarity(Rarity.RARE)
                    .attributes(AxeItem.createAttributes(ModTiers.TUBE, 8.0f, -2.8f))
                    .fireResistant()));
    public static final DeferredItem<ShovelItem> TUBE_SHOVEL = ITEMS.register("tool/tube_shovel",
            () -> new ShovelItem(ModTiers.TUBE, new Item.Properties()
                    .rarity(Rarity.RARE)
                    .attributes(ShovelItem.createAttributes(ModTiers.TUBE, 1.5f, -2.8f))
                    .fireResistant()));
    public static final DeferredItem<HoeItem> TUBE_HOE = ITEMS.register("tool/tube_hoe",
            () -> new HoeItem(ModTiers.TUBE, new Item.Properties()
                    .rarity(Rarity.RARE)
                    .attributes(HoeItem.createAttributes(ModTiers.TUBE, -4f, 0.5f))
                    .fireResistant()));

    public static final DeferredItem<WandItem> TUBE_WAND = ITEMS.register("tool/tube_wand",
            () -> new WandItem(new Item.Properties()
                    .durability(64)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
