package w1049344862.huaji.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityHuajiBall extends EntityThrowable {
	public double damage = 2;

	public EntityHuajiBall(World worldIn) {
		super(worldIn);
	}

	public EntityHuajiBall(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}

	public EntityHuajiBall(World worldIn, double x, double y, double z, int damage) {
		super(worldIn, x, y, z);
		this.damage = damage;
	}

	protected void onImpact(MovingObjectPosition m) {
		if (m.entityHit != null) {
			m.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)damage);
			m.entityHit.setFire(10);
		}
		if(this.worldObj.rand.nextInt(3)==1){
			EntityLivingBase e;
			if(this.getThrower()!=null)
				e=this.getThrower();
			else
				e=null;
			this.worldObj.createExplosion(e, m.blockX, m.blockY, m.blockZ, (float) damage, false);
			
		}

		for (int i = 0; i < 15; ++i) {
			this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}

		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
	// 砸中物体后效果

	public void setDamage(double d) {
		this.damage=d;
	}

}