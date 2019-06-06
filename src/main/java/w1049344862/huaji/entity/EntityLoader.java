package w1049344862.huaji.entity;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import w1049344862.huaji.Huaji;
import w1049344862.huaji.client.entity.RanderHuajiSkl;
import w1049344862.huaji.client.entity.RanderHuajiVillager;
import w1049344862.huaji.client.entity.RenderBossSkull;
import w1049344862.huaji.client.entity.RenderHuajiArrow;
import w1049344862.huaji.client.entity.RenderHuajiBoss;
import w1049344862.huaji.client.entity.RenderHuajiZombie;
import w1049344862.huaji.item.ItemLoader;

public class EntityLoader {
	private static int nextID = 0;

	// 注册实体
	public EntityLoader() {
		registerEntity(EntityHuajiBall.class, "HuajiBall", 64, 10, true);
		registerEntity(EntityHuajiArrow.class, "HuajiArrow", 64, 10, true);
		registerEntity(EntityHuajiZombie.class, "HuajiZombie", 64, 3, true);
		registerEntity(EntityHuajiBoss.class, "HuajiBoss", 128, 3, true);
		registerEntity(EntityBossSkull.class, "HuajiBossSkull", 64, 3, true);
		registerEntity(EntityHuajiSkl.class, "HuajiSkeleton", 64, 3, true);
		registerEntity(EntityHuajiVillager.class, "HuajiVillager", 32, 3, true);
	}

	// 方法:注册实体
	private static void registerEntity(Class<? extends Entity> entityClass, String name, int trackingRange,
			int updateFrequency, boolean sendsVelocityUpdates) {
		EntityRegistry.registerModEntity(entityClass, name, nextID++, Huaji.instance, trackingRange, updateFrequency,
				sendsVelocityUpdates);
	}

	// 注册渲染
	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityHuajiBall.class,
				new RenderSnowball(ItemLoader.huajiCoin));
		RenderingRegistry.registerEntityRenderingHandler(EntityHuajiArrow.class, new RenderHuajiArrow());
		RenderingRegistry.registerEntityRenderingHandler(EntityHuajiZombie.class, new RenderHuajiZombie());
		RenderingRegistry.registerEntityRenderingHandler(EntityHuajiBoss.class, new RenderHuajiBoss());
		RenderingRegistry.registerEntityRenderingHandler(EntityBossSkull.class, new RenderBossSkull());
		RenderingRegistry.registerEntityRenderingHandler(EntityHuajiSkl.class, new RanderHuajiSkl());
		RenderingRegistry.registerEntityRenderingHandler(EntityHuajiVillager.class, new RanderHuajiVillager());
	}
	/*
	 * private static void registerEntityEgg(Class<? extends Entity>
	 * entityClass, int eggPrimary, int eggSecondary) { EntityRegistry.
	 * EntityRegistry.registerEgg(entityClass, eggPrimary, eggSecondary); }
	 */
}