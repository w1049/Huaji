package w1049344862.huaji.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import w1049344862.huaji.achievement.AchievementLoader;
import w1049344862.huaji.creativetab.CreativeTabsLoader;

public class ItemHuajiPick extends ItemPickaxe {
	@SideOnly(Side.CLIENT)
	public static IIcon JX ;
	@SideOnly(Side.CLIENT)
	public static IIcon NORMAL;

	public ItemHuajiPick() {
		super(ItemHuajiSword.HUAJI);
		this.setUnlocalizedName("huajiPick");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
		this.setHarvestLevel("pickaxe", 5);
		this.setMaxDamage(0);
		this.canRepair = false;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister r) {
		JX = r.registerIcon("huaji:huaji_pick_jx");
		NORMAL = r.registerIcon("huaji:huaji_pick");
		this.itemIcon = NORMAL;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack i, EntityPlayer p, List list, boolean p_77624_4_) {
		list.add(I18n.format("huaji.huajiPick1"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack i, int renderPass) {
		if (i.stackTagCompound != null) {
			return i.stackTagCompound.getBoolean("flagJX") ? JX : NORMAL;
		} else {
			return NORMAL;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack i) {
		return this.getIcon(i, 0);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack i, World world, EntityPlayer p) {
		if (i.stackTagCompound == null) {
			i.stackTagCompound = new NBTTagCompound();
		}
		i.stackTagCompound.setBoolean("flagJX", !i.stackTagCompound.getBoolean("flagJX"));
		p.triggerAchievement(AchievementLoader.PickJX);
		return i;
	}

	/*
	 * @Override public boolean onBlockStartBreak(ItemStack i, int X, int Y, int
	 * Z, EntityPlayer p) { if (i != null) { if (i.getItem() ==
	 * ItemLoader.huajiPick) { if (i.stackTagCompound != null) { if
	 * (i.stackTagCompound.getBoolean("flagJX") == true) { World w =
	 * p.getEntityWorld(); EntityItem en = new EntityItem(w);
	 * en.setEntityItemStack(new ItemStack(ItemLoader.huajiCoin));
	 * w.spawnEntityInWorld(en); BreakEvent evt = new BlockEvent.BreakEvent(X,
	 * Y, Z, w, w.getBlock(X, Y, Z), w.getBlockMetadata(X, Y, Z), p);
	 * MinecraftForge.EVENT_BUS.post(evt); } } } } return false; }
	 */

}