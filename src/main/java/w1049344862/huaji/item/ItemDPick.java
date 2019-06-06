package w1049344862.huaji.item;

import net.minecraft.item.ItemPickaxe;
import w1049344862.huaji.creativetab.CreativeTabsLoader;

public class ItemDPick extends ItemPickaxe {
	public ItemDPick() {
		super(ItemHuajiSword.HUAJI);
		this.setUnlocalizedName("dPick");
		this.setTextureName("huaji:huaji_dpick");
		this.setCreativeTab(CreativeTabsLoader.tabHuaji);
	}
}
