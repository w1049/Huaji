package w1049344862.huaji.common;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import w1049344862.huaji.block.BlockLoader;
import w1049344862.huaji.entity.EntityHuajiBoss;
import w1049344862.huaji.entity.EntityHuajiSkl;
import w1049344862.huaji.entity.EntityHuajiVillager;
import w1049344862.huaji.entity.EntityHuajiZombie;
import w1049344862.huaji.item.ItemLoader;

public class CheckForHuajiAltar {
	public static boolean CheckBlock(World w, int x, int y, int z, Block b) {
		return w.getBlock(x, y, z) == b;
	}

	public static boolean CheckAll(World w, int x, int y, int z) {
		// ↑z
		// Tt [] Bb [] Tt
		// [] Bb [] Bb []
		// Bb [] Al [] Bb →x
		// [] Bb [] Bb []
		// Tt [] Bb [] Tt
		// Al:祭坛 Bb:滑稽块 Tt:树叶
		Block b = BlockLoader.huajiBlock;
		Block bl = BlockLoader.huajiLeaves;
		return CheckBlock(w, x + 2, y, z, b) && CheckBlock(w, x - 2, y, z, b) && CheckBlock(w, x, y, z + 2, b)
				&& CheckBlock(w, x, y, z - 2, b) && CheckBlock(w, x + 1, y, z + 1, b)
				&& CheckBlock(w, x + 1, y, z - 1, b) && CheckBlock(w, x - 1, y, z + 1, b)
				&& CheckBlock(w, x - 1, y, z - 1, b) && CheckBlock(w, x + 2, y, z + 2, b)
				&& CheckBlock(w, x + 2, y, z - 2, b) && CheckBlock(w, x - 2, y, z + 2, b)
				&& CheckBlock(w, x - 2, y, z - 2, b) && CheckBlock(w, x + 2, y + 1, z + 2, bl)
				&& CheckBlock(w, x + 2, y + 1, z - 2, bl) && CheckBlock(w, x - 2, y + 1, z + 2, bl)
				&& CheckBlock(w, x - 2, y + 1, z - 2, bl);
	}
	public static boolean CheckV(World w, int x, int y, int z){
		Block b = BlockLoader.huajiBlock;
		Block s = Blocks.quartz_block;
		Block l = BlockLoader.huajiLeaves;
		//[ ] [L] [ ] [L] [ ]
		//[L] [B] [B] [B] [L] 
		//[ ] [B] [A] [B] [ ]
	    //[L] [B] [B] [B] [L]
	    //[ ] [L] [ ] [L] [ ]
		return
		CheckBlock(w,x+1,y,z,b)&&
		CheckBlock(w,x-1,y,z,b)&&
		CheckBlock(w,x+1,y,z+1,b)&&
		CheckBlock(w,x-1,y,z+1,b)&&
		CheckBlock(w,x+1,y,z-1,b)&&
		CheckBlock(w,x-1,y,z-1,b)&&
		CheckBlock(w,x,y,z+1,b)&&
		CheckBlock(w,x,y,z-1,b)&&
		CheckBlock(w,x+1,y,z+2,l)&&
		CheckBlock(w,x-1,y,z+2,l)&&
		CheckBlock(w,x+2,y,z+1,l)&&
		CheckBlock(w,x-2,y,z+1,l)&&
		CheckBlock(w,x+1,y,z-2,l)&&
		CheckBlock(w,x-1,y,z-2,l)&&
		CheckBlock(w,x+2,y,z-1,l)&&
		CheckBlock(w,x-2,y,z-1,l)&&
		
		
		//[ ] [L] [ ] [L] [ ]
		//[L] [S] [ ] [S] [L] 
		//[ ] [ ] [ ] [ ] [ ]
	    //[L] [S] [ ] [S] [L]
	    //[ ] [L] [ ] [L] [ ]
		
		CheckBlock(w,x+1,y+1,z+1,s)&&
		CheckBlock(w,x-1,y+1,z+1,s)&&
		CheckBlock(w,x+1,y+1,z-1,s)&&
		CheckBlock(w,x-1,y+1,z-1,s)&&
		
		CheckBlock(w,x+1,y+1,z+2,l)&&
		CheckBlock(w,x-1,y+1,z+2,l)&&
		CheckBlock(w,x+2,y+1,z+1,l)&&
		CheckBlock(w,x-2,y+1,z+1,l)&&
		CheckBlock(w,x+1,y+1,z-2,l)&&
		CheckBlock(w,x-1,y+1,z-2,l)&&
		CheckBlock(w,x+2,y+1,z-1,l)&&
		CheckBlock(w,x-2,y+1,z-1,l)&&
		//[ ] [ ] [ ] [ ] [ ]
		//[ ] [S] [ ] [S] [ ] 
		//[ ] [ ] [ ] [ ] [ ]
	    //[ ] [S] [ ] [S] [ ]
	    //[ ] [ ] [ ] [ ] [ ]
		
		CheckBlock(w,x+1,y+2,z+1,s)&&
		CheckBlock(w,x-1,y+2,z+1,s)&&
		CheckBlock(w,x+1,y+2,z-1,s)&&
		CheckBlock(w,x-1,y+2,z-1,s);
	}

	public static void SpawnZombieInWorld(World w, int xx, int yy, int zz) {
		if (!w.isRemote) {
			double x = xx + 0.5;
			double y = yy + 1;
			double z = zz + 0.5;
			EntityLiving e1 = new EntityHuajiZombie(w);
			EntityLiving e2 = new EntityHuajiZombie(w);
			EntityLiving e3 = new EntityHuajiZombie(w);
			EntityLiving e4 = new EntityHuajiZombie(w);
			e1.setPositionAndUpdate(x, y, z - 2);
			e2.setPositionAndUpdate(x + 2, y, z);
			e3.setPositionAndUpdate(x - 2, y, z);
			e4.setPositionAndUpdate(x, y, z + 2);
			w.spawnEntityInWorld(e1);
			w.spawnEntityInWorld(e2);
			w.spawnEntityInWorld(e3);
			w.spawnEntityInWorld(e4);
			EntityLiving e5 = new EntityHuajiSkl(w);
			ItemStack its = new ItemStack(ItemLoader.toolHuajiWand);
			its.setItemDamage(-1);
	        e5.setCurrentItemOrArmor(0, its);
			if(w.rand.nextInt(3)==1){
				e5.setPositionAndUpdate(x, y+1, z - 2);
				w.spawnEntityInWorld(e5);
			}
			if(w.rand.nextInt(3)==1){
				e5.setPositionAndUpdate(x + 2, y+1, z);
				w.spawnEntityInWorld(e5);
			}
			if(w.rand.nextInt(3)==1){
				e5.setPositionAndUpdate(x - 2, y+1, z);
				w.spawnEntityInWorld(e5);
			}
			if(w.rand.nextInt(3)==1){
				e5.setPositionAndUpdate(x, y+1, z + 2);
				w.spawnEntityInWorld(e5);
			}
		}
	}

	// 以下为凋零生成
	/**
	 * Return 1:xIs 2:zIs 0:false
	 */
	public static int CheckBoss(World w, int x, int y, int z) {
		Block b = BlockLoader.huajiBlock;
		Block b1 = BlockLoader.zombieSkull;
		Block b2 = BlockLoader.bossBlock;
		boolean yIs = CheckBlock(w, x, y, z, b2) && CheckBlock(w, x, y - 1, z, b) && CheckBlock(w, x, y + 1, z, b1);
		boolean xIs = CheckBlock(w, x + 1, y, z, b) && CheckBlock(w, x - 1, y, z, b)
				&& CheckBlock(w, x + 1, y + 1, z, b1) && CheckBlock(w, x - 1, y + 1, z, b1);
		boolean zIs = CheckBlock(w, x, y, z + 1, b) && CheckBlock(w, x, y, z - 1, b)
				&& CheckBlock(w, x, y + 1, z + 1, b1) && CheckBlock(w, x, y + 1, z - 1, b1);
		return yIs ? xIs ? 1 : zIs ? 2 : 0 : 0;
	}

	public static void SpawnBoss(World w, int x, int y, int z, int meta) {
		int r = CheckBoss(w, x, y, z);
		if (r != 0) {
			w.setBlockToAir(x, y, z);
			w.setBlockToAir(x, y + 1, z);
			w.setBlockToAir(x, y - 1, z);
			if (r == 1) {
				// x
				w.setBlockToAir(x + 1, y, z);
				w.setBlockToAir(x - 1, y, z);
				w.setBlockToAir(x + 1, y + 1, z);
				w.setBlockToAir(x - 1, y + 1, z);
			} else if (r == 2) {
				// z
				w.setBlockToAir(x, y, z + 1);
				w.setBlockToAir(x, y, z - 1);
				w.setBlockToAir(x, y + 1, z + 1);
				w.setBlockToAir(x, y + 1, z - 1);
			}
			if (!w.isRemote) {
				// 计算方向
				float f;
				switch (meta) {
				case 2:
					f = 0.0F;
					break;
				case 3:
					f = 180.0F;
					break;
				case 4:
					f = 270.0F;
					break;
				case 5:
				default:
					f = 90.0F;
					break;
				}
				//
				EntityHuajiBoss e = new EntityHuajiBoss(w);
				e.setLocationAndAngles((double) x + 0.5D, (double) y + 1.45D, (double) z + 0.5D, f, 0.0F);
				e.renderYawOffset = f;
				e.func_82206_m();
				w.spawnEntityInWorld(e);
			}
			for (int i1 = 0; i1 < 120; ++i1) {
				w.spawnParticle("snowballpoof", (double) x + w.rand.nextDouble(),
						(double) (y - 2) + w.rand.nextDouble() * 3.9D, (double) (z + 1) + w.rand.nextDouble(), 0.0D,
						0.0D, 0.0D);
			}
			return;
		}
	}

	public static void SpawnVInWorld(World w, int x, int y, int z) {
		//生成村民
		Block b = Blocks.wool;
		Block a = Blocks.glass_pane;
		w.setBlock(x,y,z,b);
		w.setBlock(x+1,y,z,b);
		w.setBlock(x-1,y,z,b);
		w.setBlock(x+1,y,z+1,b);
		w.setBlock(x-1,y,z+1,b);
		w.setBlock(x+1,y,z-1,b);
		w.setBlock(x-1,y,z-1,b);
		w.setBlock(x,y,z+1,b);
		w.setBlock(x,y,z-1,b);
		
		w.setBlockMetadataWithNotify(x,y,z,4,0);
		w.setBlockMetadataWithNotify(x+1,y,z,4,0);
		w.setBlockMetadataWithNotify(x-1,y,z,4,0);
		w.setBlockMetadataWithNotify(x+1,y,z+1,4,0);
		w.setBlockMetadataWithNotify(x-1,y,z+1,4,0);
		w.setBlockMetadataWithNotify(x+1,y,z-1,4,0);
		w.setBlockMetadataWithNotify(x-1,y,z-1,4,0);
		w.setBlockMetadataWithNotify(x,y,z+1,4,0);
		w.setBlockMetadataWithNotify(x,y,z-1,4,0);
		
		w.setBlock(x+1,y+1,z,a);
		w.setBlock(x-1,y+1,z,a);
		w.setBlock(x+1,y+1,z+1,a);
		w.setBlock(x-1,y+1,z+1,a);
		w.setBlock(x+1,y+1,z-1,a);
		w.setBlock(x-1,y+1,z-1,a);
		w.setBlock(x,y+1,z+1,a);
		w.setBlock(x,y+1,z-1,a);
		
		w.setBlockToAir(x+1,y+2,z+1);
		w.setBlockToAir(x-1,y+2,z+1);
		w.setBlockToAir(x+1,y+2,z-1);
		w.setBlockToAir(x-1,y+2,z-1);
		
		w.setBlockToAir(x+1,y,z+2);
		w.setBlockToAir(x-1,y,z+2);
		w.setBlockToAir(x+2,y,z+1);
		w.setBlockToAir(x-2,y,z+1);
		w.setBlockToAir(x+1,y,z-2);
		w.setBlockToAir(x-1,y,z-2);
		w.setBlockToAir(x+2,y,z-1);
		w.setBlockToAir(x-2,y,z-1);
		
		w.setBlockToAir(x+1,y+1,z+2);
		w.setBlockToAir(x-1,y+1,z+2);
		w.setBlockToAir(x+2,y+1,z+1);
		w.setBlockToAir(x-2,y+1,z+1);
		w.setBlockToAir(x+1,y+1,z-2);
		w.setBlockToAir(x-1,y+1,z-2);
		w.setBlockToAir(x+2,y+1,z-1);
		w.setBlockToAir(x-2,y+1,z-1);
		
		w.setBlock(x,y+3,z,Blocks.glass);
		
		w.createExplosion((Entity)null, x, y+1, z, 0, false);
		if (!w.isRemote) {
		EntityHuajiVillager e = new EntityHuajiVillager(w);
		e.setPositionAndUpdate(x, y+1, z);
		w.spawnEntityInWorld(e);
		}
	}
}
