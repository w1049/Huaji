package w1049344862.huaji.client.tileentity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ResourceLocation;
import w1049344862.huaji.tileentity.TileEntityZombieSkull;

@SideOnly(Side.CLIENT)
public class RenderTileEntityZombieSkull extends TileEntitySpecialRenderer {
	private static final ResourceLocation huajiZombie = new ResourceLocation("huaji:textures/entity/huaji_zombie.png");

	public void renderTileEntityAt(TileEntityZombieSkull tileentity, double x, double y, double z, float f) {
		ModelSkeletonHead modelskeletonhead = new ModelSkeletonHead(0, 0, 64, 64);
		this.bindTexture(huajiZombie);
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_CULL_FACE);
		int meta = tileentity.getBlockMetadata();
		if (meta != 1) {
			switch (meta) {
			case 2:
				f = 0.0F;
				break;
			case 3:
				f = 180.0F;
				break;
			case 4:
				f = 270.0F;
				break;
			case 5:
			default:
				// GL11.glTranslatef((float)x + 0.26F, (float)y + 0.25F,
				// (float)z + 0.5F);
				f = 90.0F;
				break;
			}
		}
		// else
		// {
		// GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
		// }
		GL11.glTranslatef((float) x + 0.5F, (float) y, (float) z + 0.5F);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glScalef(-1.0F, -1.0F, 1.0F);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		modelskeletonhead.render((Entity) null, 0.0F, 0.0F, 0.0F, f, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float p_147500_8_) {
		this.renderTileEntityAt((TileEntityZombieSkull) tileentity, x, y, z, p_147500_8_);
	}

}