package w1049344862.huaji.block;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockLoader {
	public static Block huajiBlock = new BlockHuajiBlock();
	public static Block huajiLeaves = new BlockHuajiLeaves();
	public static Block huajiAltar = new BlockHuajiAltar();
	public static Block huajiAltarA = new BlockHuajiAltarA();
	public static Block zombieSkull = new BlockZombieSkull();
	public static Block huajiSapling = new BlockHuajiSapling();
	public static Block bossBlock = new BlockBoss();
	public static Block huajiBedrock = new BlockHuajiBedrock();

	public BlockLoader(FMLPreInitializationEvent event) {
		GameRegistry.registerBlock(huajiBlock, ItemBlockCanHat.class, "huaji_block");
		GameRegistry.registerBlock(zombieSkull, "huaji_zombie_skull");
		GameRegistry.registerBlock(huajiLeaves, "huaji_leaves");
		GameRegistry.registerBlock(huajiAltar, "huaji_altar");
		GameRegistry.registerBlock(huajiAltarA, "huaji_altar_lit");
		GameRegistry.registerBlock(huajiSapling, "huaji_sapling");
		GameRegistry.registerBlock(bossBlock, "boss_block");
		GameRegistry.registerBlock(huajiBedrock, "huaji_bedrock");
	}
}