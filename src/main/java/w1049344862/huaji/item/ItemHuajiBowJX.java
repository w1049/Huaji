package w1049344862.huaji.item;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import w1049344862.huaji.creativetab.CreativeTabsLoader;
import w1049344862.huaji.entity.EntityHuajiArrow;

public class ItemHuajiBowJX extends ItemBow {
	@SideOnly(Side.CLIENT)
	private IIcon BowJX1;
	@SideOnly(Side.CLIENT)
	private IIcon BowJX2;
	@SideOnly(Side.CLIENT)
	private IIcon BowJX3;

	public ItemHuajiBowJX() {
		super();
		this.setUnlocalizedName("huajiBowJX");
		this.setTextureName("huaji:huaji_bow_jx");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
		this.setFull3D();
	}


	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister r) {
		this.itemIcon = r.registerIcon("huaji:huaji_bow_jx_standby");
		BowJX1 = r.registerIcon("huaji:huaji_bow_jx_pulling_0");
		BowJX2 = r.registerIcon("huaji:huaji_bow_jx_pulling_1");
		BowJX3 = r.registerIcon("huaji:huaji_bow_jx_pulling_2");
	}

	public IIcon getIcon(ItemStack itemStack, int renderPass, EntityPlayer player, ItemStack usingItem,
			int useRemaining) {
		if (Minecraft.getMinecraft().gameSettings.thirdPersonView != 0) {
			GL11.glTranslatef(0.0F, -0.6F, -0.025F);
			GL11.glRotatef(-17.0F, 0.0F, 0.0F, 1.0F);
			GL11.glRotatef(14.0F, 1.0F, 0.0F, 0.0F);
			GL11.glRotatef(4.5F, 0.0F, 1.0F, 0.0F);
		}
		if (player.getItemInUse() == null) {
			return this.itemIcon;
		}
		int var8 = itemStack.getMaxItemUseDuration() - useRemaining;
		if (this == ItemLoader.huajiBowJX) {
			if (var8 >= 20) {
				return BowJX3;
			} else if (var8 > 12) {
				return BowJX2;
			} else if (var8 > 0) {
				return BowJX1;
			}
		}
		return this.itemIcon;
	}
    public void onPlayerStoppedUsing(ItemStack p_77615_1_, World p_77615_2_, EntityPlayer p_77615_3_, int p_77615_4_)
    {
        int j = this.getMaxItemUseDuration(p_77615_1_) - p_77615_4_;

        ArrowLooseEvent event = new ArrowLooseEvent(p_77615_3_, p_77615_1_, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = p_77615_3_.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, p_77615_1_) > 0;

        if (flag || p_77615_3_.inventory.hasItem(ItemLoader.huajiArrow))
        {
            float f = (float)j / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;

            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow entityarrow = new EntityHuajiArrow(p_77615_2_, p_77615_3_, f * 2.0F);

            if (f == 1.0F)
            {
                entityarrow.setIsCritical(true);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, p_77615_1_);

            if (k > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
            }

            int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, p_77615_1_);

            if (l > 0)
            {
                entityarrow.setKnockbackStrength(l);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, p_77615_1_) > 0)
            {
                entityarrow.setFire(100);
            }

            p_77615_1_.damageItem(1, p_77615_3_);
            p_77615_2_.playSoundAtEntity(p_77615_3_, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 2;
            }
            else
            {
                p_77615_3_.inventory.consumeInventoryItem(ItemLoader.huajiArrow);
            }

            if (!p_77615_2_.isRemote)
            {
                p_77615_2_.spawnEntityInWorld(entityarrow);
            }
        }
    }
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
        ArrowNockEvent event = new ArrowNockEvent(p_77659_3_, p_77659_1_);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if (p_77659_3_.capabilities.isCreativeMode || p_77659_3_.inventory.hasItem(ItemLoader.huajiArrow))
        {
            p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
        }

        return p_77659_1_;
    }
}
