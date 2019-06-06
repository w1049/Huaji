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

public class BlockHuajiBedrock extends Block {
	public BlockHuajiBedrock() {
		super(Material.grass);
		this.setHardness(3);
		this.setStepSound(soundTypeGrass);
		this.setBlockName("huajiBedrock");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);

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
