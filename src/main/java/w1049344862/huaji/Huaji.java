package w1049344862.huaji;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import w1049344862.huaji.common.CommonProxy;

//huaji planter
//huaji diji pick
//huaji diji sword
@Mod(modid = Huaji.MODID, name = Huaji.NAME, version = Huaji.VERSION, acceptedMinecraftVersions = "1.7.10")
public class Huaji {
	public static final String MODID = "huaji";
	public static final String NAME = "Huaji";
	public static final String VERSION = "1.3.1";
	public static final String Arthor = "Arthor:" + ((5246000 + 700) * 100 + 2431) * 2;

	@Instance(Huaji.MODID)
	public static Huaji instance;

	@SidedProxy(clientSide = "w1049344862.huaji.client.ClientProxy", serverSide = "w1049344862.huaji.common.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}
}