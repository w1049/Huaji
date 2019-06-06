package w1049344862.huaji.item;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import w1049344862.huaji.achievement.AchievementLoader;
import w1049344862.huaji.block.BlockLoader;
import w1049344862.huaji.creativetab.CreativeTabsLoader;
import w1049344862.huaji.entity.EntityHuajiBall;
import w1049344862.huaji.entity.EntityHuajiBoss;

public class ItemToolHuajiWand extends ItemTool {
	public static final Item.ToolMaterial HUAJI = EnumHelper.addToolMaterial("Huaji", 3, 256, 13, 2, 30);

	public ItemToolHuajiWand() {
		super(3, HUAJI, new HashSet());
		this.setUnlocalizedName("toolHuajiWand");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
		this.setTextureName("huaji:huaji_wand");

	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
		list.add(I18n.format("huaji.huajiWand1"));
		list.add(I18n.format("huaji.huajiWand2"));
		list.add(I18n.format("huaji.huajiWand3"));
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
		MovingObjectPosition m = this.getMovingObjectPositionFromPlayer(world, entityPlayer, false);
		if (!entityPlayer.capabilities.isCreativeMode) {
			itemStack.damageItem(1, entityPlayer);
		}
		if (m != null) {
			// 滑稽获得
			if (world.getBlock(m.blockX, m.blockY, m.blockZ) == Blocks.diamond_block) {
				Random r = new Random();
				if (r.nextInt(3) == 1) {
					entityPlayer.inventory.addItemStackToInventory(new ItemStack(ItemLoader.huajiCoin));
					entityPlayer.triggerAchievement(AchievementLoader.huajiInf);
				}
				return itemStack;
			}
		}
		// 发射
		world.playSoundAtEntity(entityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!world.isRemote) {
			world.spawnEntityInWorld(new EntityHuajiBall(world, entityPlayer));
		}
		return itemStack;
	}

}
