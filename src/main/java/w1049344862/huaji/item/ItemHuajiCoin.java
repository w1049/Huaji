package w1049344862.huaji.item;

import net.minecraft.item.Item;
import w1049344862.huaji.creativetab.CreativeTabsLoader;

public class ItemHuajiCoin extends Item {
	public ItemHuajiCoin() {
		super();
		this.setUnlocalizedName("huajiCoin");
		this.setTextureName("huaji:huaji_coin");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
	}
}