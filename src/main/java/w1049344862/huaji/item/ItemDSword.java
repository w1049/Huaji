package w1049344862.huaji.item;

import net.minecraft.item.ItemSword;
import w1049344862.huaji.creativetab.CreativeTabsLoader;

public class ItemDSword extends ItemSword {
	public ItemDSword() {
		super(ItemHuajiSword.HUAJI);
		this.setUnlocalizedName("dSword");
		this.setTextureName("huaji:huaji_dsword");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
	}
}
