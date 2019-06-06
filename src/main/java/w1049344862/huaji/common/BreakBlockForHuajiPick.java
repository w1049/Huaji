package w1049344862.huaji.common;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BreakBlockForHuajiPick {
	public static void BreakBlock(World w, int x, int y, int z, int shiyun, EntityPlayer p) {
		if (w.getBlock(x, y, z) != Blocks.bedrock) {
			if (!w.isRemote) {
				ArrayList<ItemStack> list = w.getBlock(x, y, z).getDrops(w, x, y, z, w.getBlockMetadata(x, y, z),
						shiyun);
				Iterator itor = list.iterator();
				int exp = w.getBlock(x, y, z).getExpDrop(w, w.getBlockMetadata(x, y, z), shiyun);
				while (itor.hasNext()) {
					ItemStack next = (ItemStack) itor.next();
					if (!p.capabilities.isCreativeMode) {
						w.spawnEntityInWorld(new EntityItem(w, x, y, z, next));
						if (exp != 0)
							w.spawnEntityInWorld(new EntityXPOrb(w, x, y, z, exp));
					}
					w.setBlockToAir(x, y, z);
				}
			}
		}
	}

	public static void Break3x3(World w, int x, int y, int z, int shiyun, EntityPlayer p) {
		BreakBlock(w, x, y, z, shiyun, p);
		BreakBlock(w, x + 1, y, z, shiyun, p);
		BreakBlock(w, x - 1, y, z, shiyun, p);
		BreakBlock(w, x, y, z + 1, shiyun, p);
		BreakBlock(w, x + 1, y, z + 1, shiyun, p);
		BreakBlock(w, x - 1, y, z + 1, shiyun, p);
		BreakBlock(w, x, y, z - 1, shiyun, p);
		BreakBlock(w, x + 1, y, z - 1, shiyun, p);
		BreakBlock(w, x - 1, y, z - 1, shiyun, p);
	}

	public static void BreakLiFangTi3x3x3(World w, int x, int y, int z, int shiyun, EntityPlayer p) {
		Break3x3(w, x, y, z, shiyun, p);
		Break3x3(w, x, y + 1, z, shiyun, p);
		Break3x3(w, x, y - 1, z, shiyun, p);
	}
}
