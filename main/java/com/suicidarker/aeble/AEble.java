package com.suicidarker.aeble;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;

@Mod(modid = AEble.MODID, name = AEble.NAME, version = AEble.VERSION, dependencies = "required-after:aether_legacy;required-after:baubles")
public class AEble {
	public static final String MODID = "aeble";
	public static final String NAME = "AEble";
	public static final String VERSION = "1.2.0";

	static final CreativeTabs tabAEble = new CreativeTabs("tabAEble") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Items.WATER_BUCKET);
		}

	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
			RegisterHandler.init();


	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new com.suicidarker.aeble.EventHandler());
		CraftingHandler.removeRecipes();

	}
	

}
