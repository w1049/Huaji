package w1049344862.huaji.creativetab;

import w1049344862.huaji.item.ItemLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsHuaji extends CreativeTabs {
	public CreativeTabsHuaji() {
		super("huaji");
	}

	@Override
	public Item getTabIconItem() {
		return ItemLoader.huajiCoin;
	}
}