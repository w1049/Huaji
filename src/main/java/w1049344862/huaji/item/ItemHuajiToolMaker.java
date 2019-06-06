package w1049344862.huaji.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import w1049344862.huaji.Huaji;
import w1049344862.huaji.creativetab.CreativeTabsLoader;

public class ItemHuajiToolMaker extends Item {
	public ItemHuajiToolMaker(String texture, String name) {
		super();
		this.setUnlocalizedName("huaji" + name);
		this.setTextureName("huaji:huaji_" + texture);
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
	}
	/*
	 * @Override
	 * 
	 * @SideOnly(Side.CLIENT) public void addInformation(ItemStack i,
	 * EntityPlayer p, List list, boolean p_77624_4_) { list.add(Huaji.Arthor);
	 * }
	 */
}