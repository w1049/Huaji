package w1049344862.huaji.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import w1049344862.huaji.creativetab.CreativeTabsLoader;
import w1049344862.huaji.item.ItemLoader;
import w1049344862.huaji.worldgen.HuajiTreeGen;

public class BlockHuajiSapling extends BlockBush implements IGrowable {
	private static IIcon ICON = null;

	protected BlockHuajiSapling() {
		this.setBlockName("huajiSapling");
		float f = 0.4F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int side, float passx, float passy,
			float passz) {
		ItemStack i = p.getHeldItem();
		if (i != null) {
			if (i.getItem() == Items.dye) {
				w.setBlockToAir(x, y, z);
				new HuajiTreeGen(true).generate(w, w.rand, x, y, z);
				if (!p.capabilities.isCreativeMode)
					i.damageItem(1, p);
			}
		}
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return ICON;
	}
	/*
	 * public void func_149878_d(World w, int x, int y, int z, Random r) { //
	 * new WorldGenTrees(true).generate(w, r, x, y, z); }
	 */

	public boolean func_149880_a(World p_149880_1_, int p_149880_2_, int p_149880_3_, int p_149880_4_,
			int p_149880_5_) {
		return p_149880_1_.getBlock(p_149880_2_, p_149880_3_, p_149880_4_) == this
				&& (p_149880_1_.getBlockMetadata(p_149880_2_, p_149880_3_, p_149880_4_) & 7) == p_149880_5_;
	}

	public int damageDropped(int p_149692_1_) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister r) {
		ICON = r.registerIcon("huaji:huaji_sapling");
	}

	public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_,
			boolean p_149851_5_) {
		return true;
	}

	public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_,
			int p_149852_5_) {
		return (double) p_149852_1_.rand.nextFloat() < 0.45D;
	}

	public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_,
			int p_149853_5_) {
	}
}