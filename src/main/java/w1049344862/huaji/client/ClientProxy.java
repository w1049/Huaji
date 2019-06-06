package w1049344862.huaji.client;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import w1049344862.huaji.client.entity.EntityRenderLoader;
import w1049344862.huaji.client.tileentity.TileEntityRenderLoader;
import w1049344862.huaji.common.CommonProxy;

public class ClientProxy extends CommonProxy {
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		new EntityRenderLoader();
		new TileEntityRenderLoader();
	}

	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
	}
}