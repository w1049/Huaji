package w1049344862.huaji.client.entity;

import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.client.renderer.entity.RenderVillager;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;

public class RanderHuajiVillager extends RenderVillager{
	private static final ResourceLocation HuajiVillagerTextures = new ResourceLocation(
			"huaji:textures/entity/huaji_villager.png");;

	public RanderHuajiVillager() {
		super();
	}

	protected ResourceLocation getEntityTexture(EntityVillager p_110775_1_) {
		return HuajiVillagerTextures;
	}
}
