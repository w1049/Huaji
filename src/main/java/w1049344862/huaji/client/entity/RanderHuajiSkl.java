package w1049344862.huaji.client.entity;

import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.util.ResourceLocation;

public class RanderHuajiSkl extends RenderSkeleton{
	private static final ResourceLocation HuajiSklTextures = new ResourceLocation(
			"huaji:textures/entity/huaji_skl.png");;

	public RanderHuajiSkl() {
		super();
	}

	protected ResourceLocation getEntityTexture(EntitySkeleton p_110775_1_) {
		return HuajiSklTextures;
	}
}
