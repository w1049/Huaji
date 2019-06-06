package w1049344862.huaji.item;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import w1049344862.huaji.creativetab.CreativeTabsLoader;
import w1049344862.huaji.entity.EntityHuajiArrow;

public class ItemHuajiBow extends ItemBow {
	@SideOnly(Side.CLIENT)
	private IIcon Bow1;
	@SideOnly(Side.CLIENT)
	private IIcon Bow2;
	@SideOnly(Side.CLIENT)
	private IIcon Bow3;

	public ItemHuajiBow() {
		super();
		this.setUnlocalizedName("huajiBow");
		this.setTextureName("huaji:huaji_bow");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
		this.setFull3D();
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack i, World w, EntityPlayer p, int time) {
		int j = this.getMaxItemUseDuration(i) - time;
		boolean flag = p.capabilities.isCreativeMode
				|| EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, i) > 0;

		if (flag || p.inventory.hasItem(Items.arrow)) {
			float f = (float) j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if ((double) f < 0.1D) {
				return;
			}

			if (f > 1.0F) {
				f = 1.0F;
			}

			EntityArrow a = new EntityArrow(w, p, f * 2.0F);

			if (f == 1.0F) {
				a.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, i);

			if (k > 0) {
				a.setDamage(a.getDamage() + (double) k * 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, i);

			if (l > 0) {
				a.setKnockbackStrength(l);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, i) > 0) {
				a.setFire(100);
			}

			i.damageItem(1, p);
			w.playSoundAtEntity(p, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag) {
				a.canBePickedUp = 2;
			} else {
				p.inventory.consumeInventoryItem(Items.arrow);
			}

			if (!w.isRemote) {
				w.spawnEntityInWorld(a);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister r) {
		this.itemIcon = r.registerIcon("huaji:huaji_bow_standby");
		Bow1 = r.registerIcon("huaji:huaji_bow_pulling_0");
		Bow2 = r.registerIcon("huaji:huaji_bow_pulling_1");
		Bow3 = r.registerIcon("huaji:huaji_bow_pulling_2");
	}

	public ItemStack onEaten(ItemStack p_77654_1_, World p_77654_2_, EntityPlayer p_77654_3_) {
		return p_77654_1_;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 72000;
	}

	/**
	 * returns the action that specifies what animation to play when the items
	 * is being used
	 */
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.bow;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is
	 * pressed. Args: itemStack, world, entityPlayer
	 */
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
		ArrowNockEvent event = new ArrowNockEvent(p_77659_3_, p_77659_1_);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return event.result;
		}

		if (p_77659_3_.capabilities.isCreativeMode || p_77659_3_.inventory.hasItem(Items.arrow)) {
			p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
		}

		return p_77659_1_;
	}

	public IIcon getIcon(ItemStack itemStack, int renderPass, EntityPlayer player, ItemStack usingItem,
			int useRemaining) {
		if (Minecraft.getMinecraft().gameSettings.thirdPersonView != 0) {
			GL11.glTranslatef(0.0F, -0.6F, -0.025F);
			GL11.glRotatef(-17.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(14.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(4.5F, 0.0F, 1.0F, 0.0F);
		}
		if (player.getItemInUse() == null) {
			return this.itemIcon;
		}
		int var8 = itemStack.getMaxItemUseDuration() - useRemaining;
		if (this == ItemLoader.huajiBow) {
			if (var8 >= 20) {
				return Bow3;
			} else if (var8 > 12) {
				return Bow2;
			} else if (var8 > 0) {
				return Bow1;
			}
		}
		return this.itemIcon;
	}
}
