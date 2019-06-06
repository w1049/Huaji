package w1049344862.huaji.client.entity;

import net.minecraft.client.renderer.entity.RenderZombie;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.ResourceLocation;

public class RenderHuajiZombie extends RenderZombie {
	private static final ResourceLocation HuajiZombieTextures = new ResourceLocation(
			"huaji:textures/entity/huaji_zombie.png");;

	public RenderHuajiZombie() {
	}

	protected ResourceLocation getEntityTexture(EntityZombie p_110775_1_) {
		return HuajiZombieTextures;
	}

}
