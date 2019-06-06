package w1049344862.huaji.client.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;
import w1049344862.huaji.entity.EntityHuajiBall;

public class ArrowHitForHuaji {

	public static void SpawnHuaji(EntityLiving e, Entity s) {
		World w = e.worldObj;
		double x = e.posX;
		double y = e.posY;
		double z = e.posZ;
		for (int j = 0; j < 300; ++j) {
			double nx = x + w.rand.nextGaussian() * 7;
			double ny = y + 30 + w.rand.nextDouble() * 4;
			double nz = z
					+ w.rand.nextGaussian() * 7/* * 0.30000001192092896D */;
			w.spawnEntityInWorld(new EntityHuajiBall(w, nx, ny, nz, (int) e.getMaxHealth() / 10));
		}
	}

}
