package com.suicidarker.aeble;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class ItemRing extends Item implements IBauble {

	public ItemRing(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(AEble.tabAEble);
		RegisterHandler.itemSet.add(this);

	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.getItem() == RegisterHandler.air_ring) {
			player.fallDistance = 0;
		}
		if (itemstack.getItem() == RegisterHandler.ice_ring) {
			BlockPos positon = player.getPosition();
			IBlockState underblock = player.getEntityWorld()
					.getBlockState(new BlockPos(positon.getX(), positon.getY() - 1, positon.getZ()));
			if (underblock.getBlock() == Blocks.LAVA)
				player.getEntityWorld().setBlockState(new BlockPos(positon.getX(), positon.getY() - 1, positon.getZ()),
						Block.getStateById(Block.getIdFromBlock(Blocks.OBSIDIAN)));

			if (underblock.getBlock() == Blocks.FLOWING_LAVA)
				player.getEntityWorld().setBlockState(new BlockPos(positon.getX(), positon.getY() - 1, positon.getZ()),
						Block.getStateById(Block.getIdFromBlock(Blocks.STONE)));

			if (underblock.getBlock() == Blocks.FLOWING_WATER)
				player.getEntityWorld().setBlockState(new BlockPos(positon.getX(), positon.getY() - 1, positon.getZ()),
						Block.getStateById(Block.getIdFromBlock(Blocks.FROSTED_ICE)));

			if (underblock.getBlock() == Blocks.WATER)
				player.getEntityWorld().setBlockState(new BlockPos(positon.getX(), positon.getY() - 1, positon.getZ()),
						Block.getStateById(Block.getIdFromBlock(Blocks.FROSTED_ICE)));

		}
		if (itemstack.getItem() == RegisterHandler.regeneration_ring) {
			player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION,20,0));
		}
		if (itemstack.getItem() == RegisterHandler.bubble_ring) {
			player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING,20,3));
		}
		if (itemstack.getItem() == RegisterHandler.zanite_ring) {
			player.addPotionEffect(new PotionEffect(MobEffects.HASTE,20,0));
		}
		if (itemstack.getItem() == RegisterHandler.obsidian_ring) {
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE,20,0));
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE,20,0));
		}

	}

}
