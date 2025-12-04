package com.kokhannia.tube.item;

import com.kokhannia.tube.TubeCraft;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TubeCraft.MOD_ID);

    public static final DeferredItem<Item> PLASTIC_CHUNK = ITEMS.register("material/plastic_chunk", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TUBE = ITEMS.register("tube/tube", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WATER_TUBE = ITEMS.register("tube/water_tube", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> HARDENED_TUBE = ITEMS.register("tube/hardened_tube", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLASTIC_PLATE = ITEMS.register("material/plastic_plate", () -> new Item(new Item.Properties()));

    public static final DeferredItem<ArmorItem> TUBE_HELMET = ITEMS.register("armor/tube_helmet",
            () -> new ArmorItem(ModArmorMaterials.TUBE, ArmorItem.Type.HELMET, new Item.Properties()
                    .fireResistant()
                    .durability(ArmorItem.Type.HELMET.getDurability(46))));
    public static final DeferredItem<ArmorItem> TUBE_CHESTPLATE = ITEMS.register("armor/tube_chestplate",
            () -> new ArmorItem(ModArmorMaterials.TUBE, ArmorItem.Type.CHESTPLATE, new Item.Properties()
                    .fireResistant()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(46))));
    public static final DeferredItem<ArmorItem> TUBE_LEGGINGS = ITEMS.register("armor/tube_leggings",
            () -> new ArmorItem(ModArmorMaterials.TUBE, ArmorItem.Type.LEGGINGS, new Item.Properties()
                    .fireResistant()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(46))));
    public static final DeferredItem<ArmorItem> TUBE_BOOTS = ITEMS.register("armor/tube_boots",
            () -> new ArmorItem(ModArmorMaterials.TUBE, ArmorItem.Type.BOOTS, new Item.Properties()
                    .fireResistant()
                    .durability(ArmorItem.Type.BOOTS.getDurability(46))));

    public static final DeferredItem<Item> CHARCOAL_CALCULI = ITEMS.register("material/charcoal_calculi",
            () -> new ModFuelItem(new Item.Properties(), 3200));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
