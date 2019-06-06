package w1049344862.huaji.entity;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import w1049344862.huaji.client.entity.ArrowHitForHuaji;
import w1049344862.huaji.item.ItemLoader;

public class EntityHuajiArrow extends EntityArrow
{
/*    private int field_145791_d = -1;
    private int field_145792_e = -1;
    private int field_145789_f = -1;
    private Block field_145790_g;
    private int inData;
    private boolean inGround;
    public int canBePickedUp;
    public int arrowShake;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir;
    private double damage = 2.0D;
    private int knockbackStrength;
    private static final String __OBFID = "CL_00001715";*/
    private boolean newInGround;
    private int supx = -1;
    private int supy = -1;
    private int supz = -1;

    public EntityHuajiArrow(World p_i1753_1_)
    {
        super(p_i1753_1_);
        this.renderDistanceWeight = 10.0D;
        this.setSize(0.5F, 0.5F);
    }
    public EntityHuajiArrow(World w, EntityPlayer p, float f) {
		super(w, p, f);
	}
	public void onUpdate()
    {
        super.onUpdate();
        Block block = this.worldObj.getBlock(this.supx, this.supy, this.supz);
        if (block.getMaterial() != Material.air)
        {
            block.setBlockBoundsBasedOnState(this.worldObj, this.supx, this.supy, this.supz);
            AxisAlignedBB axisalignedbb = block.getCollisionBoundingBoxFromPool(this.worldObj, this.supx, this.supy, this.supz);

            if (axisalignedbb != null && axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ)))
            {
                this.newInGround = true;
            }
        }
    }
    public void onCollideWithPlayer(EntityPlayer p_70100_1_)
    {
        if (!this.worldObj.isRemote && this.newInGround && this.arrowShake <= 0)
        {
            boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && p_70100_1_.capabilities.isCreativeMode;

            if (this.canBePickedUp == 1 && !p_70100_1_.inventory.addItemStackToInventory(new ItemStack(ItemLoader.huajiArrow, 1)))
            {
                flag = false;
            }

            if (flag)
            {
                this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                p_70100_1_.onItemPickup(this, 1);
                this.setDead();
            }
        }
    }
    public void readEntityFromNBT(NBTTagCompound nTC)
    {
    	super.readEntityFromNBT(nTC);
    	this.supx = nTC.getShort("xTile");
        this.supy = nTC.getShort("yTile");
        this.supz = nTC.getShort("zTile");
    	
    }
    /*
	if (movingobjectposition.entityHit != null
			&& movingobjectposition.entityHit instanceof EntityLiving) {
		// this.shootingEntity 射击者
		// movingobjectposition.entityHit 被攻击
		ArrowHitForHuaji.SpawnHuaji((EntityLiving) movingobjectposition.entityHit,
				this.shootingEntity);
		//
	} */
}