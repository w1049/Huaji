package w1049344862.huaji.block;

import java.util.ArrayList;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import w1049344862.huaji.creativetab.CreativeTabsLoader;
import w1049344862.huaji.item.ItemLoader;

public class BlockHuajiLeaves extends BlockLeavesBase {

	public BlockHuajiLeaves() {

		super(Material.leaves, false);
		this.setBlockName("huajiLeaves");
		this.setTickRandomly(true);
		this.setHardness(0.2f);
		this.setLightOpacity(1);
		this.setStepSound(soundTypeGrass);
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
	}

	private static IIcon Top = null;
	private static IIcon Other = null;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		Top = icon.registerIcon("huaji:huaji_leaves_other");
		Other = icon.registerIcon("huaji:huaji_leaves");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 0 ? Top : side == 1 ? Top : Other;
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		int f = fortune >= 3 ? 3 : fortune;
		if (world.rand.nextInt(6 - f) == 0) {
			ret.add(new ItemStack(ItemLoader.huajiApple));
		}
		if (world.rand.nextInt(6 - f) == 1 || world.rand.nextInt(5 - f) == 2) {
			ret.add(new ItemStack(BlockLoader.huajiSapling));
		}
		return ret;
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int side, float passx, float passy,
			float passz) {
		ItemStack i = p.getHeldItem();
		if (i != null) {
			if (i.getItem() == ItemLoader.toolHuajiWand) {
				EntityItem enItem = new EntityItem(w, x, y, z, new ItemStack(BlockLoader.huajiLeaves));
				w.setBlockToAir(x, y, z);
				if (!w.isRemote) {
					w.spawnEntityInWorld(enItem);
				}
				if (!p.capabilities.isCreativeMode) {
					i.damageItem(1, p);
				}
			}
		}
		return true;
	}

	@Override
	public boolean isLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}
}
