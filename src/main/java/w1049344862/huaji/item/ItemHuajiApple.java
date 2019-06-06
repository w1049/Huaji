package w1049344862.huaji.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import w1049344862.huaji.creativetab.CreativeTabsLoader;

public class ItemHuajiApple extends ItemFood {
	public ItemHuajiApple() {
		super(4, 0.8f, false);
		this.setAlwaysEdible();
		this.setUnlocalizedName("huajiApple");
		this.setTextureName("huaji:huaji_apple");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack s, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
		if (s.stackTagCompound == null) {
			s.stackTagCompound = new NBTTagCompound();
		}
		int meta = s.stackTagCompound.getInteger("meta");
		switch (meta) {
		case 1:// 无负面
			list.add(I18n.format("huaji.huajiApple1"));
			break;
		case 2:// 15s
			list.add(I18n.format("huaji.huajiApple2"));
			break;
		case 3:// 40s
			list.add(I18n.format("huaji.huajiApple3"));
			break;
		case 4:// 增强
			list.add(I18n.format("huaji.huajiApple4"));
			break;
		}
		list.add(I18n.format("huaji.huajiMaker1"));
		list.add(I18n.format("huaji.huajiMaker2"));
	}

	/*
	 * public ItemStack onItemRightClick(ItemStack i, World w, EntityPlayer p) {
	 * MovingObjectPosition m = this.getMovingObjectPositionFromPlayer(w, p,
	 * false);
	 * 
	 * if (m != null) { if (w.getBlock(m.blockX, m.blockY, m.blockZ) ==
	 * Blocks.diamond_block) { p.triggerAchievement(AchievementLoader.getHuaji);
	 * w.setBlockToAir(m.blockX, m.blockY, m.blockZ);
	 * p.inventory.addItemStackToInventory(new ItemStack(ItemLoader.huajiCoin));
	 * --i.stackSize; return i; } else { return i; } } else { return i; } }
	 */
	// 丧心病狂
	public final int[] g = new int[] { 1, 3, 5, 6, 8, 10, 11, 12, 13, 14, 16, 21, 22, 23 };

	@Override
	public void onFoodEaten(ItemStack s, World w, EntityPlayer p) {
		if (s.stackTagCompound == null) {
			s.stackTagCompound = new NBTTagCompound();
		}
		if (!w.isRemote) {
			int meta = s.stackTagCompound.getInteger("meta");
			switch (meta) {
			case 0:// 正常
			default:
				p.addPotionEffect(new PotionEffect(w.rand.nextInt(23) + 1, 200, 0));
			case 1:// 无负面
				p.addPotionEffect(new PotionEffect(g[w.rand.nextInt(g.length)], 200, 0));
				break;
			case 2:// 15s
				p.addPotionEffect(new PotionEffect(w.rand.nextInt(23) + 1, 300, 0));
				break;
			case 3:// 40s
				p.addPotionEffect(new PotionEffect(w.rand.nextInt(23) + 1, 800, 0));
				break;
			case 4:// 增强
				p.addPotionEffect(new PotionEffect(w.rand.nextInt(23) + 1, 200, 1));
				break;
			}

			// p.addPotionEffect(new PotionEffect(Potion.saturation.id, 200,
			// 1));
		}
		super.onFoodEaten(s, w, p);
	}
}