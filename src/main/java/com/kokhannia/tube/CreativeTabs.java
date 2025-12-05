package com.kokhannia.tube;

import com.kokhannia.tube.custom.ModBlocks;
import com.kokhannia.tube.custom.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class CreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TubeCraft.MOD_ID);

    public static final Supplier<CreativeModeTab> TUBE_TAB = CREATIVE_TABS.register("tube_tab", () ->
            CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.WATER_TUBE.get()))
                    .title(Component.translatable("itemGroup.tubecraft_tab"))
                    .displayItems(((parameters, output) -> {
                        output.accept(ModItems.PLASTIC_CHUNK.get());
                        output.accept(ModItems.PLASTIC_PLATE.get());

                        output.accept(ModItems.WATER_TUBE.get());
                        output.accept(ModItems.TUBE.get());
                        output.accept(ModItems.HARDENED_TUBE.get());

                        output.accept(ModBlocks.PLASTIC_GRAVEL);
                        output.accept(ModBlocks.NETHER_PLASTIC_GRAVEL);
                        output.accept(ModBlocks.TUBE_BLOCK);
                        output.accept(ModBlocks.TUBE_MACHINE);

                        output.accept(ModItems.TUBE_HELMET.get());
                        output.accept(ModItems.TUBE_CHESTPLATE.get());
                        output.accept(ModItems.TUBE_LEGGINGS.get());
                        output.accept(ModItems.TUBE_BOOTS.get());

                        output.accept(ModItems.TUBE_SWORD.get());
                        output.accept(ModItems.TUBE_PICKAXE.get());
                        output.accept(ModItems.TUBE_AXE.get());
                        output.accept(ModItems.TUBE_SHOVEL.get());
                        output.accept(ModItems.TUBE_HOE.get());

                        output.accept(ModItems.CHARCOAL_CALCULI.get());

                        output.accept(ModItems.TUBE_WAND.get());
                    }))
                    .build()
    );
    public static void register(IEventBus eventBus) {
        CREATIVE_TABS.register(eventBus);
    }

}
