package w1049344862.huaji.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import w1049344862.huaji.achievement.AchievementLoader;
import w1049344862.huaji.common.CheckForHuajiAltar;
import w1049344862.huaji.creativetab.CreativeTabsLoader;
import w1049344862.huaji.item.ItemLoader;

public class BlockHuajiAltarA extends Block {
	public BlockHuajiAltarA() {
		super(Material.iron);
		this.setHardness(6);
		this.setStepSound(soundTypeMetal);
		this.setBlockName("huajiAltarA");
	}

	@SideOnly(Side.CLIENT)
	private static IIcon Other;
	@SideOnly(Side.CLIENT)
	private static IIcon On;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		Other = icon.registerIcon("huaji:huaji_altar_other");
		On = icon.registerIcon("huaji:huaji_altar_on");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? On : Other;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World w, int x, int y, int z) {
		return Item.getItemFromBlock(BlockLoader.huajiAltar);
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int side, float passx, float passy,
			float passz) {
		ItemStack i = p.getHeldItem();
		if (i != null) {
			if (i.getItem() == ItemLoader.toolHuajiWand) {
				////////////////////////
				if (CheckForHuajiAltar.CheckAll(w, x, y, z)) {
					w.setBlock(x, y, z, BlockLoader.huajiAltar);
					CheckForHuajiAltar.SpawnZombieInWorld(w, x, y, z);
					p.triggerAchievement(AchievementLoader.summonZombie);
					if (!p.capabilities.isCreativeMode)
						i.damageItem(1, p);
				}else if(CheckForHuajiAltar.CheckV(w, x, y, z)){
					CheckForHuajiAltar.SpawnVInWorld(w,x,y,z);
					if (!p.capabilities.isCreativeMode)
						i.damageItem(1, p);
				}
				//////////////////////
			}
		}
		return true;
	}
}
