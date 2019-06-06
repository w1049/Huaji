package w1049344862.huaji.worldgen;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

public class BiomeLoader {
	public static BiomeGenBase huajiForest = new HuajiForest();

	public BiomeLoader() {
		BiomeDictionary.registerBiomeType(huajiForest, BiomeDictionary.Type.FOREST);
	}
}