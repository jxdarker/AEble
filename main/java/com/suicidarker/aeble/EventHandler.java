package com.suicidarker.aeble;

import java.util.Iterator;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.legacy.aether.client.gui.button.GuiAccessoryButton;

public class EventHandler {
			
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.LOW)
	public void hideAccessoryButton(GuiScreenEvent.InitGuiEvent.Post event) {

		List<GuiButton> list = event.getButtonList();
		Iterator<GuiButton> iterator = list.iterator();
		for (GuiButton b:list) {
			if (b instanceof GuiAccessoryButton) {
				b.visible = false;
			}
		}

	}
	@SubscribeEvent
	public void removeLootload(LootTableLoadEvent event) {
		switch(event.getName().toString()) {
			case "aether_legacy:chests/bronze_dungeon_chest":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/bronze_dungeon_chest")));
				break;
			case "aether_legacy:chests/bronze_dungeon_chest_sub0":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/bronze_dungeon_chest_sub0")));
				break;
			case "aether_legacy:chests/bronze_dungeon_chest_sub1":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/bronze_dungeon_chest_sub1")));
				break;
			case "aether_legacy:chests/bronze_dungeon_chest_sub2":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/bronze_dungeon_chest_sub2")));
				break;
			case "aether_legacy:chests/bronze_dungeon_chest_sub3":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/bronze_dungeon_chest_sub3")));
				break;
			case "aether_legacy:chests/bronze_dungeon_reward":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/bronze_dungeon_reward")));
				break;
			case "aether_legacy:chests/silver_dungeon_chest":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/silver_dungeon_chest")));
				break;
			case "aether_legacy:chests/silver_dungeon_chest_sub0":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/silver_dungeon_chest_sub0")));
				break;
			case "aether_legacy:chests/silver_dungeon_chest_sub1":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/silver_dungeon_chest_sub1")));
				break;
			case "aether_legacy:chests/silver_dungeon_chest_sub2":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/silver_dungeon_chest_sub2")));
				break;
			case "aether_legacy:chests/silver_dungeon_chest_sub3":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/silver_dungeon_chest_sub3")));
				break;
			case "aether_legacy:chests/silver_dungeon_chest_sub4":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/silver_dungeon_chest_sub3")));
				break;
			case "aether_legacy:chests/silver_dungeon_reward":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/silver_dungeon_reward")));
				break;
			case "aether_legacy:chests/gold_dungeon_chest":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/gold_dungeon_chest")));
				break;
			case "aether_legacy:chests/gold_dungeon_chest_sub0":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/gold_dungeon_chest_sub0")));
				break;
			case "aether_legacy:chests/gold_dungeon_chest_sub1":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/gold_dungeon_chest_sub1")));
				break;
			case "aether_legacy:chests/gold_dungeon_chest_sub2":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/gold_dungeon_chest_sub2")));
				break;
			case "aether_legacy:chests/gold_dungeon_chest_sub3":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/gold_dungeon_chest_sub3")));
				break;
			case "aether_legacy:chests/gold_dungeon_chest_sub4":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/gold_dungeon_chest_sub3")));
				break;
			case "aether_legacy:chests/gold_dungeon_chest_sub5":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/gold_dungeon_chest_sub3")));
				break;
			case "aether_legacy:chests/gold_dungeon_reward":
				event.setTable(event.getLootTableManager().getLootTableFromLocation(new ResourceLocation("aeble:chests/gold_dungeon_reward")));
				break;
		}
	}
}
