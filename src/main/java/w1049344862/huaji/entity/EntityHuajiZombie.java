package w1049344862.huaji.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import w1049344862.huaji.block.BlockLoader;
import w1049344862.huaji.item.ItemLoader;

public class EntityHuajiZombie extends EntityZombie {

	public EntityHuajiZombie(World w) {
		super(w);
		this.isImmuneToFire = true;
	}

	/*
	 * @Override public void onLivingUpdate(){ super.onLivingUpdate(); }
	 */
	@Override
	protected void dropFewItems(boolean pk, int n) {
		Item i = Item.getItemFromBlock(BlockLoader.zombieSkull);
		if (this.rand.nextInt(3) == 1) {
			this.dropItem(i, 1);
		}
		if (this.rand.nextInt(4) == 1) {
			this.dropItem(ItemLoader.rmb5, 1);
		}
		if (this.rand.nextInt(9) == 1) {
			this.dropItem(ItemLoader.rmb5, 1);
		}
		if (this.rand.nextInt(19) == 1) {
			this.dropItem(ItemLoader.rmb5, 2);
		}
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
	}
}
