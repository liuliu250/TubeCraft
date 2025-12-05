package com.kokhannia.tube.datagen;

import com.kokhannia.tube.TubeCraft;
import com.kokhannia.tube.custom.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipesProvider extends RecipeProvider {
    public ModRecipesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    public static final List<ItemLike> ING_PLASTIC_CHUNK = List.of(
            ModBlocks.PLASTIC_GRAVEL
    );

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        //samples
        //hint: namespace are from products
//        oreSmelting(recipeOutput, ING_PLASTIC_CHUNK, RecipeCategory.MISC, ModItems.PLASTIC_CHUNK, 0.7f, 200, "plastic");
//        oreBlasting(recipeOutput, ING_PLASTIC_CHUNK, RecipeCategory.MISC, ModItems.PLASTIC_CHUNK, 0.7f, 100, "plastic");
//
//        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TUBE)
//                .pattern(" P ")
//                .pattern("P P")
//                .pattern(" P ")
//                .define('P', ModItems.PLASTIC_PLATE)
//                .unlockedBy(getHasName(ModItems.PLASTIC_PLATE), has(ModItems.PLASTIC_PLATE))
//                .save(recipeOutput);
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PLASTIC_GRAVEL)
//                .requires(Blocks.GRAVEL)
//                .requires(ModItems.PLASTIC_CHUNK)
//                .unlockedBy(getHasName(ModItems.PLASTIC_CHUNK), has(ModItems.PLASTIC_CHUNK))
//                .save(recipeOutput);
    }

    protected static void oreSmelting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_smelting"
        );
    }

    protected static void oreBlasting(
            RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group
    ) {
        oreCooking(
                recipeOutput,
                RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                ingredients,
                category,
                result,
                experience,
                cookingTime,
                group,
                "_from_blasting"
        );
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(
            RecipeOutput recipeOutput,
            RecipeSerializer<T> serializer,
            AbstractCookingRecipe.Factory<T> recipeFactory,
            List<ItemLike> ingredients,
            RecipeCategory category,
            ItemLike result,
            float experience,
            int cookingTime,
            String group,
            String suffix
    ) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, serializer, recipeFactory)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TubeCraft.MOD_ID + ":" + getItemName(result) + suffix + "_" + getItemName(itemlike));
        }
    }

}
