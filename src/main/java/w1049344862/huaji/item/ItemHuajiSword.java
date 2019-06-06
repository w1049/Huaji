package w1049344862.huaji.item;

import java.util.HashSet;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import w1049344862.huaji.achievement.AchievementLoader;
import w1049344862.huaji.creativetab.CreativeTabsLoader;
import w1049344862.huaji.entity.EntityHuajiBall;

public class ItemHuajiSword extends ItemSword {
	@SideOnly(Side.CLIENT)
	public static IIcon JX;
	@SideOnly(Side.CLIENT)
	public static IIcon NORMAL;
	public static final Item.ToolMaterial HUAJI = EnumHelper.addToolMaterial("Huaji", 3, 2001, 14, 7, 30);

	public ItemHuajiSword() {
		super(HUAJI);
		this.setUnlocalizedName("huajiSword");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
		this.setMaxDamage(0);
		this.canRepair = false;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister r) {
		JX = r.registerIcon("huaji:huaji_sword_jx");
		NORMAL = r.registerIcon("huaji:huaji_sword");
		this.itemIcon = NORMAL;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack i, EntityPlayer p, List list, boolean p_77624_4_) {
		list.add(I18n.format("huaji.huajiSword1"));
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
		p.triggerAchievement(AchievementLoader.SwordJX);
		return i;
	}

}