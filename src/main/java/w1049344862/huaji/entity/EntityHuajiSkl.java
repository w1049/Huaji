package w1049344862.huaji.entity;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import w1049344862.huaji.block.BlockLoader;
import w1049344862.huaji.item.ItemLoader;

public class EntityHuajiSkl extends EntitySkeleton{

	public EntityHuajiSkl(World w) {
		super(w);
		this.isImmuneToFire = true;
	}
	@Override
	protected void dropFewItems(boolean pk, int n) {
		if (this.rand.nextInt(4) == 1) {
			this.dropItem(ItemLoader.rmb5, 2);
		}
		if (this.rand.nextInt(9) == 1) {
			this.dropItem(ItemLoader.rmb5, 2);
		}
		if (this.rand.nextInt(19) == 1) {
			this.dropItem(ItemLoader.rmb5, 4);
		}
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(100.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
	}
	@Override
    protected void addRandomArmor()
    {
		ItemStack its = new ItemStack(ItemLoader.toolHuajiWand);
		its.setItemDamage(-1);
        this.setCurrentItemOrArmor(0, its);
    }
    public void setCombatTask()
    {
        this.tasks.addTask(4, new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F));
    }
    public void attackEntityWithRangedAttack(EntityLivingBase p_82196_1_, float p_82196_2_)
    {
        EntityHuajiBall eh = new EntityHuajiBall(this.worldObj, this);
        eh.setDamage((double)(p_82196_2_ * 2.0F) + this.rand.nextGaussian() * 0.25D + (double)((float)this.worldObj.difficultySetting.getDifficultyId() * 0.11F));
        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.worldObj.spawnEntityInWorld(eh);
    }

}
