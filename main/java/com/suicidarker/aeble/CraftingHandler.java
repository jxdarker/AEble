package com.suicidarker.aeble;

import java.util.ArrayList;

import com.google.common.collect.Lists;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

import com.legacy.aether.items.accessories.ItemAccessory;

public class CraftingHandler {
	
	public static void removeRecipes() {
		 ForgeRegistry<IRecipe> recipeRegistry = (ForgeRegistry<IRecipe>)ForgeRegistries.RECIPES;
	     ArrayList<IRecipe> recipes = Lists.newArrayList(recipeRegistry.getValuesCollection());

		for (IRecipe r : recipes) {
			if (r.getRecipeOutput().getItem().getClass() == ItemAccessory.class)
				recipeRegistry.remove(r.getRegistryName());
		}

	}
}