package com.kokhannia.tube.item;

import com.kokhannia.tube.TubeCraft;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TubeCraft.MOD_ID);

    public static final DeferredItem<Item> TUBE = ITEMS.register("tube", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PLASTIC_CHUNK = ITEMS.register("material/plastic_chunk", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WATER_TUBE = ITEMS.register("water_tube", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
