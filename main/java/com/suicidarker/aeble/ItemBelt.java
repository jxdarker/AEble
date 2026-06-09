package com.suicidarker.aeble;

import java.util.List;
import java.util.Random;

import com.legacy.aether.entities.projectile.EntityZephyrSnowball;
import com.legacy.aether.entities.projectile.darts.EntityDartBase;
import com.legacy.aether.items.ItemsAether;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;

public class ItemBelt extends Item implements IBauble{
	
	private Random rand = new Random();

	public ItemBelt(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(AEble.tabAEble);
		RegisterHandler.itemSet.add(this);

	}
	@Override
	public BaubleType getBaubleType(ItemStack arg0) {
		return BaubleType.BELT;
	}
	
	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		if (itemstack.getItem() == RegisterHandler.luck_belt) {
			player.getEntityAttribute(SharedMonsterAttributes.LUCK).setBaseValue(60.0);
		}
		if (itemstack.getItem() == RegisterHandler.valkyrie_belt) {
			player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH,20,0));
		}
		if (itemstack.getItem() == RegisterHandler.repulsion_belt) {
			List<?> entities = player.world.getEntitiesWithinAABBExcludingEntity(player, player.getEntityBoundingBox().expand(4.0D, 4.0D, 4.0D));

			for (int size = 0; size < entities.size(); ++size)
			{
				Entity projectile = (Entity) entities.get(size);
				
				if (isProjectile(projectile) && (this.getShooter(projectile) != player))
				{
					double x, y, z;

					if (this.getShooter(projectile) != null)
					{
						Entity shooter = this.getShooter(projectile);
						x = player.posX - shooter.posX;
						y = player.getEntityBoundingBox().minY - shooter.getEntityBoundingBox().minY;
						z = player.posZ - shooter.posZ;
					}
					else
					{
						x = player.posX - projectile.posX;
						y = player.posY - projectile.posY;
						z = player.posZ - projectile.posZ;
					}

					double difference = -Math.sqrt((x * x) + (y * y) + (z * z));

					x /= difference; y /= difference; z /= difference;

					projectile.motionX = x * 0.75F; projectile.motionY = y * 0.75F + 0.05D; projectile.motionZ = z * 0.75F;

					this.setShooter(projectile, player);
					player.playSound(SoundEvents.BLOCK_NOTE_SNARE, 1.0F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.4F + 0.8F) * 1.1F);

					for (int pack = 0; pack < 12; ++pack)
					{
						double packX, packY, packZ;
						packX = (-projectile.motionX * 0.15F) + ((this.rand.nextFloat() - 0.5F) * 0.05F);
						packY = (-projectile.motionY * 0.15F) + ((this.rand.nextFloat() - 0.5F) * 0.05F);
						packZ = (-projectile.motionZ * 0.15F) + ((this.rand.nextFloat() - 0.5F) * 0.05F);
						packX *= 0.625F;
						packY *= 0.625F;
						packZ *= 0.625F;

						player.world.spawnParticle(EnumParticleTypes.FLAME, projectile.posX, projectile.posY, projectile.posZ, packX, packY, packZ);
					}
				}
			}
		}
		
	}
	private Entity getShooter(Entity ent) 
	{
		return ent instanceof EntityArrow ? ((EntityArrow)ent).shootingEntity :
			ent instanceof EntityThrowable ? ((EntityThrowable)ent).getThrower() :
				ent instanceof EntityDartBase ? ((EntityDartBase)ent).shootingEntity :
					ent instanceof EntityFireball ? ((EntityFireball)ent).shootingEntity :
							null;
	}

	private void setShooter(Entity ent, EntityLivingBase shooter) 
	{
		if (ent instanceof EntityArrow)
		{
			((EntityArrow)ent).shootingEntity = shooter;
		}
		else if (ent instanceof EntityFireball)
		{
			((EntityFireball)ent).shootingEntity = shooter;
		}
		else if (ent instanceof EntityFireball)
		{
			((EntityFireball)ent).shootingEntity = shooter;
		}
		else if (ent instanceof EntityDartBase)
		{
			((EntityDartBase)ent).shootingEntity = shooter;
		}
	}

	public static boolean isProjectile(Entity entity)
	{
		return entity instanceof EntityArrow || entity instanceof EntityFireball || entity instanceof EntityThrowable || entity instanceof EntityPotion || entity instanceof EntityDartBase || entity instanceof EntityZephyrSnowball;
	}

}
