package w1049344862.huaji.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemZombieSkull extends ItemBlock {
	public ItemZombieSkull(Block block) {
		super(block);
		this.setTextureName("huaji:huaji_skull");
	}
}