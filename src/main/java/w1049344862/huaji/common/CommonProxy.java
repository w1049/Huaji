package w1049344862.huaji.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import w1049344862.huaji.achievement.AchievementLoader;
import w1049344862.huaji.block.BlockLoader;
import w1049344862.huaji.crafting.CraftingLoader;
import w1049344862.huaji.creativetab.CreativeTabsLoader;
import w1049344862.huaji.entity.EntityLoader;
import w1049344862.huaji.item.ItemLoader;
import w1049344862.huaji.tileentity.TileEntityLoader;
import w1049344862.huaji.worldgen.BiomeLoader;
import w1049344862.huaji.worldgen.WorldGeneratorLoader;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent event) {
		new CreativeTabsLoader(event);
		new ItemLoader(event);
		new BlockLoader(event);
		new EntityLoader();
		new TileEntityLoader(event);
	}

	public void init(FMLInitializationEvent event) {
		new CraftingLoader();
		new AchievementLoader();
		new EventLoader();
		new BiomeLoader();
		new WorldGeneratorLoader();
	}

	public void postInit(FMLPostInitializationEvent event) {

	}

}