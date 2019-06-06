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
import w1049344862.huaji.creativetab.CreativeTabsLoader;
import w1049344862.huaji.item.ItemLoader;

public class BlockHuajiAltar extends Block {
	public BlockHuajiAltar() {
		super(Material.iron);
		this.setHardness(6);
		this.setStepSound(soundTypeMetal);
		this.setBlockName("huajiAltar");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);

	}

	@SideOnly(Side.CLIENT)
	private static IIcon Other;
	@SideOnly(Side.CLIENT)
	private static IIcon On;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon) {
		Other = icon.registerIcon("huaji:huaji_altar_other");
		On = icon.registerIcon("huaji:huaji_altar_off");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return side == 1 ? On : Other;
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int side, float passx, float passy,
			float passz) {
		ItemStack i = p.getHeldItem();
		if (i != null) {
			if (i.getItem() == ItemLoader.huajiApple) {
				if (!p.capabilities.isCreativeMode)
					--i.stackSize;
				w.setBlock(x, y, z, BlockLoader.huajiAltarA);
			}
		}
		return true;
	}
}
