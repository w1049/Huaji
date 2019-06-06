package w1049344862.huaji.creativetab;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

public class CreativeTabsLoader {
	public static CreativeTabs tabHuaji;

	public CreativeTabsLoader(FMLPreInitializationEvent event) {
		tabHuaji = new CreativeTabsHuaji();
	}
}
