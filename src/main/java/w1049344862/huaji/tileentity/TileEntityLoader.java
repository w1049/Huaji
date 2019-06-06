package w1049344862.huaji.tileentity;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.tileentity.TileEntity;
import w1049344862.huaji.client.tileentity.RenderTileEntityZombieSkull;

public class TileEntityLoader {
	public TileEntityLoader(FMLPreInitializationEvent event) {
		registerTileEntity(TileEntityZombieSkull.class, "ZombieSkull");
	}

	public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String id) {
		GameRegistry.registerTileEntity(tileEntityClass, "huaji:" + id);
	}
	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityZombieSkull.class, new RenderTileEntityZombieSkull());
	}
}