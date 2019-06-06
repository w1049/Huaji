package w1049344862.huaji.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraftforge.common.util.ForgeDirection;
import w1049344862.huaji.block.BlockHuajiSapling;
import w1049344862.huaji.block.BlockLoader;

public class HuajiTreeGen extends WorldGenTrees {
	public HuajiTreeGen(boolean b) {
		super(b);
	}

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		int l = r.nextInt(3) + 5;
		boolean flag = true;

		if (y >= 1 && y + l + 1 <= 256) {
			byte b0;
			int k1;
			Block block;

			for (int i1 = y; i1 <= y + 1 + l; ++i1) {
				b0 = 1;

				if (i1 == y) {
					b0 = 0;
				}

				if (i1 >= y + 1 + l - 2) {
					b0 = 2;
				}

				for (int j1 = x - b0; j1 <= x + b0 && flag; ++j1) {
					for (k1 = z - b0; k1 <= z + b0 && flag; ++k1) {
						if (i1 >= 0 && i1 < 256) {
							block = w.getBlock(j1, i1, k1);

							if (!this.isReplaceable(w, j1, i1, k1)) {
								flag = false;
							}
						} else {
							flag = false;
						}
					}
				}
			}

			if (!flag) {
				return false;
			} else {
				Block block2 = w.getBlock(x, y - 1, z);

				boolean isSoil = block2.canSustainPlant(w, x, y - 1, z, ForgeDirection.UP,
						(BlockHuajiSapling) BlockLoader.huajiSapling);
				if (isSoil && y < 256 - l - 1) {
					block2.onPlantGrow(w, x, y - 1, z, x, y, z);
					b0 = 3;
					byte b1 = 0;
					int l1;
					int i2;
					int j2;
					int i3;

					for (k1 = y - b0 + l; k1 <= y + l; ++k1) {
						i3 = k1 - (y + l);
						l1 = b1 + 1 - i3 / 2;

						for (i2 = x - l1; i2 <= x + l1; ++i2) {
							j2 = i2 - x;

							for (int k2 = z - l1; k2 <= z + l1; ++k2) {
								int l2 = k2 - z;

								if (Math.abs(j2) != l1 || Math.abs(l2) != l1 || r.nextInt(2) != 0 && i3 != 0) {
									Block block1 = w.getBlock(i2, k1, k2);

									if (block1.isAir(w, i2, k1, k2) || block1.isLeaves(w, i2, k1, k2)) {
										this.setBlockAndNotifyAdequately(w, i2, k1, k2, BlockLoader.huajiLeaves, 0);
									}
								}
							}
						}
					}

					for (k1 = 0; k1 < l; ++k1) {
						block = w.getBlock(x, y + k1, z);

						if (block.isAir(w, x, y + k1, z) || block.isLeaves(w, x, y + k1, z)) {
							this.setBlockAndNotifyAdequately(w, x, y + k1, z, Blocks.log, 0);
						}
					}
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}
}