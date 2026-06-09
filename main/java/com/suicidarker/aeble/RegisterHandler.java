package com.suicidarker.aeble;

import java.util.HashSet;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = AEble.MODID)
public class RegisterHandler {

	public static ItemRing ice_ring;
	public static ItemRing air_ring;
	public static ItemRing regeneration_ring;
	public static ItemRing bubble_ring;
	public static ItemRing obsidian_ring;
	public static ItemRing zanite_ring;

	public static ItemBelt luck_belt;
	public static ItemBelt valkyrie_belt;
	public static ItemBelt repulsion_belt;
	
	public static HashSet<Item> itemSet = new HashSet<Item>();

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (Item i : itemSet) {
			event.getRegistry().register(i);
		}
	}

	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		for (Item i : itemSet) {
			registerRender(i);
		}
	}

	public static void init() {
		ice_ring = new ItemRing("ice_ring");
		air_ring = new ItemRing("air_ring");
		regeneration_ring = new ItemRing("regeneration_ring");
		bubble_ring = new ItemRing("bubble_ring");
		obsidian_ring = new ItemRing("obsidian_ring");
		zanite_ring = new ItemRing("zanite_ring");

		luck_belt = new ItemBelt("luck_belt");
		valkyrie_belt = new ItemBelt("valkyrie_belt");
		repulsion_belt = new ItemBelt("repulsion_belt");
	}

	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
