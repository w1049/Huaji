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

public class BlockBoss extends Block {
	public BlockBoss() {
		super(Material.iron);
		this.setHardness(6);
		this.setStepSound(soundTypeMetal);
		this.setBlockName("bossBlock");
		this.setBlockTextureName("huaji:boss_block");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int side, float passx, float passy,
			float passz) {
		ItemStack i = p.getHeldItem();
		if (i != null) {
			if (i.getItem() == ItemLoader.toolHuajiWand) {
				// boss
				int meta;// 2 3 4 5 direction
				switch (MathHelper.floor_double((double) (p.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) {
				case 0:
					meta = 2;
					break;
				case 1:
					meta = 5;
					break;
				case 2:
				default:
					meta = 3;
					break;
				case 3:
					meta = 4;
					break;
				}
				if (CheckForHuajiAltar.CheckBoss(w, x, y, z) != 0) {
					CheckForHuajiAltar.SpawnBoss(w, x, y, z, meta);
					p.triggerAchievement(AchievementLoader.summonBoss);
					if (!p.capabilities.isCreativeMode)
						i.damageItem(1, p);
				}
				/////////////////////////
			}
		}
		return true;
	}
}
