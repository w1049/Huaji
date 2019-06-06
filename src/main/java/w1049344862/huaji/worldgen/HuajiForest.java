package w1049344862.huaji.worldgen;

import net.minecraft.world.biome.BiomeGenForest;

public class HuajiForest extends BiomeGenForest {
	public HuajiForest() {
		super(4, 1);
		this.worldGeneratorTrees = new HuajiTreeGen(false);
		this.setBiomeName("Huaji Forest");
		this.theBiomeDecorator.treesPerChunk = 1;
		this.spawnableMonsterList.clear();
	}

}
