package w1049344862.huaji.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.nbt.NBTTagCompound;
import w1049344862.huaji.block.BlockLoader;
import w1049344862.huaji.item.ItemLoader;

public class CraftingLoader {
	public CraftingLoader() {
		registerRecipe();
		registerSmelting();
		registerFuel();
	}

	private static void registerRecipe() {
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.huajiCoin, 9), BlockLoader.huajiBlock);
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.huajiBlock),
				new Object[] { "###", "###", "###", '#', ItemLoader.huajiCoin, });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.huajiSwordUp), new Object[] { "LHL", "ZHZ", "ZHZ", 'L',
				ItemLoader.huajiApple, 'H', ItemLoader.huajiCoin, 'Z', Blocks.diamond_block });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.huajiSwordDown), new Object[] { "JJJ", "HXH", "PHP", 'J',
				Blocks.gold_block, 'H', ItemLoader.huajiCoin, 'X', Items.nether_star, 'P', Items.leather });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.huajiSword),
				new Object[] { "HUH", "BXB", "HDH", 'H', ItemLoader.huajiCoin, 'B', BlockLoader.huajiBlock, 'U',
						ItemLoader.huajiSwordUp, 'D', ItemLoader.huajiSwordDown, 'X', ItemLoader.bossStar });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.toolHuajiWand),
				new Object[] { "HSH", " S ", " S ", 'H', ItemLoader.huajiCoin, 'S', Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.huajiPickLeft), new Object[] { "LZH", "HHH", "LZZ", 'H',
				ItemLoader.huajiCoin, 'L', ItemLoader.huajiApple, 'Z', Blocks.diamond_block });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.huajiPickRight), new Object[] { "ZZL", "HHH", "HZL", 'H',
				ItemLoader.huajiCoin, 'L', ItemLoader.huajiApple, 'Z', Blocks.diamond_block });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.huajiPick),
				new Object[] { "ZBY", "LXL", "LSL", 'B', BlockLoader.huajiBlock, 'L', ItemLoader.huajiApple, 'Z',
						ItemLoader.huajiPickLeft, 'Y', ItemLoader.huajiPickRight, 'X', ItemLoader.bossStar, 'S',
						ItemLoader.huajiStick });
		GameRegistry.addShapedRecipe(new ItemStack(BlockLoader.huajiAltar),
				new Object[] { "HWH", "OHO", "OOO", 'H', ItemLoader.huajiCoin, 'W', Items.bowl, 'O', Blocks.obsidian });
		GameRegistry.addShapelessRecipe(getStackWithMeta(new ItemStack(ItemLoader.huajiApple), 1),
				new Object[] { ItemLoader.huajiApple, Items.emerald });
		GameRegistry.addShapelessRecipe(getStackWithMeta(new ItemStack(ItemLoader.huajiApple), 2),
				new Object[] { ItemLoader.huajiApple, Items.redstone });
		GameRegistry.addShapelessRecipe(getStackWithMeta(new ItemStack(ItemLoader.huajiApple), 3),
				new Object[] { ItemLoader.huajiApple, Blocks.redstone_block});
		GameRegistry.addShapelessRecipe(getStackWithMeta(new ItemStack(ItemLoader.huajiApple), 4),
				new Object[] { ItemLoader.huajiApple, Items.glowstone_dust });
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.huajiStick),
				new Object[] { ItemLoader.huajiCoin, Items.stick });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.dPick),
				new Object[] { "AHA", "XSX", "OSO", 'A', Blocks.diamond_block, 'H', Blocks.emerald_block, 'X',
						ItemLoader.huajiCoin, 'S', ItemLoader.huajiStick, 'O', BlockLoader.huajiLeaves });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.dSword),
				new Object[] { "XAX", "OHO", "PSP", 'A', Blocks.diamond_block, 'H', Blocks.emerald_block, 'X',
						ItemLoader.huajiCoin, 'S', ItemLoader.huajiStick, 'O', BlockLoader.huajiLeaves, 'P',
						Items.leather });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.huajiBow), new Object[] { "HZY", "ZSY", "HZY", 'Z',
				Blocks.diamond_block, 'H', BlockLoader.huajiBlock, 'Y', Blocks.wool, 'S', ItemLoader.huajiCoin });
		GameRegistry.addShapedRecipe(new ItemStack(ItemLoader.huajiBowJX), new Object[] { "PFP", "FGF", "LFL", 'F',
				ItemLoader.toolHuajiWand, 'P', Items.leather, 'G', ItemLoader.huajiBow, 'L', Blocks.emerald_block });
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.huajiArrow, 64),
				new Object[] { ItemLoader.bossStar, ItemLoader.huajiStick, ItemLoader.huajiCoin });
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.rmb20), new Object[]{ItemLoader.rmb5,ItemLoader.rmb5,ItemLoader.rmb5,ItemLoader.rmb5});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemLoader.rmb100), new Object[]{ItemLoader.rmb20,ItemLoader.rmb20,ItemLoader.rmb20,ItemLoader.rmb20,ItemLoader.rmb20});
		// 以下为红宝石时代物品
		/*
		 * GameRegistry.addShapedRecipe(new
		 * ItemStack(BlockLoader.redDiamondBlock), new Object[] { "###", "###",
		 * "###", '#', ItemLoader.redDiamond, });
		 * /////////////////////////////////////////////////////////////////////
		 * //////////////////////// GameRegistry.addShapedRecipe(new
		 * ItemStack(ItemLoader.redLight), new Object[] { "#*#", " # ", '#',
		 * Items.iron_ingot, '*', ItemLoader.redDiamond });
		 * /////////////////////////////////////////////////////////////////////
		 * /////////////////////////// GameRegistry.addShapedRecipe(new
		 * ItemStack(ItemLoader.redLightBig), new Object[] { "#*#", '*',
		 * Items.iron_ingot, '#', ItemLoader.redLight });
		 * /////////////////////////////////////////////////////////////////////
		 * /////////////////////////// GameRegistry.addShapedRecipe(new
		 * ItemStack(ItemLoader.redLightShoot), new Object[] { "-+-", " * ",
		 * "###", '#', Items.iron_ingot, '*', ItemLoader.redDiamondLight, '-',
		 * ItemLoader.redLight, '+', ItemLoader.redLightBig });
		 * /////////////////////////////////////////////////////////////////////
		 * /////////////////////////// GameRegistry.addShapedRecipe(new
		 * ItemStack(ItemLoader.toolRedKill), new Object[] { "---", "*#*", " * "
		 * , '*', Items.iron_ingot, '#', ItemLoader.redDiamondLight, '-',
		 * ItemLoader.redLightShoot });
		 * /////////////////////////////////////////////////////////////////////
		 * /////////////////////////// GameRegistry.addShapedRecipe(new
		 * ItemStack(ItemLoader.toolRedStone), new Object[] { "---", "*#*",
		 * "***", '*', Items.iron_ingot, '#', ItemLoader.redDiamondLight, '-',
		 * ItemLoader.redLightShoot });
		 * /////////////////////////////////////////////////////////////////////
		 * /////////////////////////// GameRegistry.addShapedRecipe(new
		 * ItemStack(ItemLoader.toolRedDirt), new Object[] { "* *", "*#*",
		 * "*-*", '*', Items.iron_ingot, '#', ItemLoader.redLightShoot, '-',
		 * ItemLoader.redDiamondLight });
		 * /////////////////////////////////////////////////////////////////////
		 * /////////////////////////// GameRegistry.addShapedRecipe(new
		 * ItemStack(ItemLoader.toolRedWood), new Object[] { "*-*", "# #", " # "
		 * , '#', Items.iron_ingot, '*', ItemLoader.redLightShoot, '-',
		 * ItemLoader.redDiamondLight });
		 * /////////////////////////////////////////////////////////////////////
		 * /////////////////////////// GameRegistry.addShapelessRecipe(new
		 * ItemStack(ItemLoader.redDiamond, 9), BlockLoader.redDiamondBlock);
		 */

	}

	private static void registerSmelting() {

		/*
		 * GameRegistry.addSmelting(BlockLoader.redDiamondOre, new
		 * ItemStack(ItemLoader.redDiamond), 2);
		 * GameRegistry.addSmelting(ItemLoader.redDiamond, new
		 * ItemStack(ItemLoader.redDiamondLight), 2);
		 */
	}

	private static void registerFuel() {

	}

	public static ItemStack getStackWithMeta(ItemStack i, int meta) {
		if (i.stackTagCompound == null) {
			i.stackTagCompound = new NBTTagCompound();
		}
		i.stackTagCompound.setInteger("meta", meta);
		i.addEnchantment(Enchantment.unbreaking, 1);
		return i;
	}
}