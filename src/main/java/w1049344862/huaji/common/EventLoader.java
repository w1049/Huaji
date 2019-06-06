package w1049344862.huaji.common;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import w1049344862.huaji.achievement.AchievementLoader;
import w1049344862.huaji.block.BlockLoader;
import w1049344862.huaji.item.ItemLoader;

public class EventLoader {
	public EventLoader() {
		MinecraftForge.EVENT_BUS.register(this);
		FMLCommonHandler.instance().bus().register(this);
	}

	// 滑稽剑打人效果
	@SubscribeEvent
	public void onPlayerAttack(AttackEntityEvent evt) {
		EntityPlayer p = evt.entityPlayer;
		Entity target = evt.target;
		ItemStack i = p.getHeldItem();
		if (i != null) {
			if (i.getItem() == ItemLoader.huajiSword && target instanceof EntityLivingBase) {
				if (i.stackTagCompound != null) {
					if (i.stackTagCompound.getBoolean("flagJX") == true) {
						EntityLivingBase t = (EntityLivingBase) target;
						float maxHealth = t.getMaxHealth();
						if (maxHealth <= 20) {
							t.attackEntityFrom(DamageSource.causePlayerDamage(p).setDamageIsAbsolute(), 20);
						} else {
							t.attackEntityFrom(DamageSource.causePlayerDamage(p).setDamageIsAbsolute(),
									maxHealth / 2 + maxHealth / 20);
						}
					}
				}
			}
		}
	}

	// 得到制作成就
	@SubscribeEvent
	public void onPlayerItemCrafted(ItemCraftedEvent evt) {
		if (evt.crafting.getItem() == ItemLoader.huajiApple) {
			evt.player.triggerAchievement(AchievementLoader.huajiApple);
		} else if (evt.crafting.getItem() == ItemLoader.toolHuajiWand) {
			evt.player.triggerAchievement(AchievementLoader.huajiWand);
		} else if (evt.crafting.getItem() == Item.getItemFromBlock(BlockLoader.huajiBlock)) {
			evt.player.triggerAchievement(AchievementLoader.huajiBlock);
		} else if (evt.crafting.getItem() == ItemLoader.huajiSwordUp) {
			evt.player.triggerAchievement(AchievementLoader.upSword);
		} else if (evt.crafting.getItem() == ItemLoader.huajiSwordDown) {
			evt.player.triggerAchievement(AchievementLoader.downSword);
		} else if (evt.crafting.getItem() == ItemLoader.huajiSword) {
			evt.player.triggerAchievement(AchievementLoader.buildHuajiSword);
		} else if (evt.crafting.getItem() == ItemLoader.huajiPickLeft) {
			evt.player.triggerAchievement(AchievementLoader.leftPick);
		} else if (evt.crafting.getItem() == ItemLoader.huajiPickRight) {
			evt.player.triggerAchievement(AchievementLoader.rightPick);
		} else if (evt.crafting.getItem() == ItemLoader.huajiPick) {
			evt.player.triggerAchievement(AchievementLoader.buildHuajiPick);
		} else if (evt.crafting.getItem() == Item.getItemFromBlock(BlockLoader.huajiAltar)) {
			evt.player.triggerAchievement(AchievementLoader.huajiAltar);
		} else if (evt.crafting.getItem() == ItemLoader.huajiStick) {
			evt.player.triggerAchievement(AchievementLoader.buildStick);
		} else if (evt.crafting.getItem() == ItemLoader.huajiBow) {
			evt.player.triggerAchievement(AchievementLoader.buildBow);
		} else if (evt.crafting.getItem() == ItemLoader.huajiBowJX) {
			evt.player.triggerAchievement(AchievementLoader.bowJX);
		}
	}

	// 滑稽镐挖东西

	@SubscribeEvent
	public void onPlayerBreak(BreakEvent evt) {
		EntityPlayer p = evt.getPlayer();
		ItemStack i = p.getHeldItem();
		if (i != null) {
			if (i.getItem() == ItemLoader.huajiPick) {
				if (i.stackTagCompound != null) {
					if (i.stackTagCompound.getBoolean("flagJX") == true) {
						BreakBlockForHuajiPick.BreakLiFangTi3x3x3(evt.world, evt.x, evt.y, evt.z, 3, p);
					}
				}
			}
		}
	}

	// 捡起物品
	@SubscribeEvent
	public void onPickup(EntityItemPickupEvent evt) {
		if (evt.item.getEntityItem() != null) {
			if (evt.item.getEntityItem().getItem() == ItemLoader.huajiApple) {
				evt.entityPlayer.triggerAchievement(AchievementLoader.huajiApple);
			} else if (evt.item.getEntityItem().getItem() == ItemLoader.bossStar) {
				evt.entityPlayer.triggerAchievement(AchievementLoader.killBoss);
			}
		}
	}

	@SubscribeEvent
	public void onRightClick(PlayerInteractEvent evt) {
		if (evt.world.getBlock(evt.x, evt.y, evt.z) == Blocks.diamond_block) {
			ItemStack i = evt.entityPlayer.getHeldItem();
			if (i != null) {
				if (i.getItem() == ItemLoader.huajiApple) {
					if (evt.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
						evt.entityPlayer.triggerAchievement(AchievementLoader.getHuaji);
						evt.world.setBlockToAir(evt.x, evt.y, evt.z);
						evt.entityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemLoader.huajiCoin));
						--i.stackSize;
					}
				}
			}
		}
	}

}
