package w1049344862.huaji.entity;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import w1049344862.huaji.block.BlockLoader;
import w1049344862.huaji.item.ItemLoader;

public class EntityHuajiVillager extends EntityVillager{

	public EntityHuajiVillager(World wIn) {
		super(wIn);
	}
	@Override
    public boolean interact(EntityPlayer e)
    {
        ItemStack i = e.inventory.getCurrentItem();

        if(i!=null&i.getItem()==ItemLoader.rmb100){
        	--i.stackSize;
        	e.inventory.addItemStackToInventory(new ItemStack(BlockLoader.bossBlock));
            return true;
        }
        else
        {
            return superInteract(e);
        }
    }
	
    public boolean superInteract(EntityPlayer e)
    {
            ItemStack itemstack = e.inventory.getCurrentItem();

            if (itemstack != null && itemstack.getItem() == Items.spawn_egg)
            {
                if (!this.worldObj.isRemote)
                {
                    Class oclass = EntityList.getClassFromID(itemstack.getItemDamage());

                    if (oclass != null && oclass.isAssignableFrom(this.getClass()))
                    {
                        EntityAgeable entityageable = this.createChild(this);

                        if (entityageable != null)
                        {
                            entityageable.setGrowingAge(-24000);
                            entityageable.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
                            this.worldObj.spawnEntityInWorld(entityageable);

                            if (itemstack.hasDisplayName())
                            {
                                entityageable.setCustomNameTag(itemstack.getDisplayName());
                            }

                            if (!e.capabilities.isCreativeMode)
                            {
                                --itemstack.stackSize;

                                if (itemstack.stackSize <= 0)
                                {
                                    e.inventory.setInventorySlotContents(e.inventory.currentItem, (ItemStack)null);
                                }
                            }
                        }
                    }
                }

                return true;
            }
            else
            {
                return false;
            }
        }
    }

