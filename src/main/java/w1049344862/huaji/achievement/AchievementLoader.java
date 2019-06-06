package w1049344862.huaji.achievement;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import w1049344862.huaji.Huaji;
import w1049344862.huaji.block.BlockLoader;
import w1049344862.huaji.item.ItemLoader;

public class AchievementLoader {
	// 成就
	public static Achievement huajiApple = new Achievement("achievement.w1049344862.huaji.huajiMaker",
			"w1049344862.huaji.huajiMaker", 0, 0, ItemLoader.huajiApple, null);
	public static Achievement getHuaji = new Achievement("achievement.w1049344862.huaji.getHuaji",
			"w1049344862.huaji.getHuaji", 2, 1, ItemLoader.huajiCoin, huajiApple);
	public static Achievement huajiWand = new Achievement("achievement.w1049344862.huaji.huajiWand",
			"w1049344862.huaji.huajiWand", 4, -1, ItemLoader.toolHuajiWand, getHuaji);
	public static Achievement huajiInf = new Achievement("achievement.w1049344862.huaji.huajiInf",
			"w1049344862.huaji.huajiInf", 4, -3, ItemLoader.toolHuajiWand, huajiWand);
	public static Achievement huajiBlock = new Achievement("achievement.w1049344862.huaji.huajiBlock",
			"w1049344862.huaji.huajiBlock", 4, 2, BlockLoader.huajiBlock, getHuaji);
	public static Achievement downSword = new Achievement("achievement.w1049344862.huaji.downSword",
			"w1049344862.huaji.downSword", 6, 2, ItemLoader.huajiSwordDown, huajiBlock);
	public static Achievement upSword = new Achievement("achievement.w1049344862.huaji.upSword",
			"w1049344862.huaji.upSword", 6, 1, ItemLoader.huajiSwordUp, huajiBlock);
	public static Achievement buildHuajiSword = new Achievement("achievement.w1049344862.huaji.buildHuajiSword",
			"w1049344862.huaji.buildHuajiSword", 8, 1, ItemLoader.huajiSword, upSword);
	public static Achievement SwordJX = new Achievement("achievement.w1049344862.huaji.SwordJX",
			"w1049344862.huaji.SwordJX", 10, 1, getJxItemStack(ItemLoader.huajiSword), buildHuajiSword);
	public static Achievement leftPick = new Achievement("achievement.w1049344862.huaji.leftPick",
			"w1049344862.huaji.leftPick", 4, 4, ItemLoader.huajiPickLeft, huajiBlock);
	public static Achievement rightPick = new Achievement("achievement.w1049344862.huaji.rightPick",
			"w1049344862.huaji.rightPick", 3, 4, ItemLoader.huajiPickRight, huajiBlock);
	public static Achievement buildHuajiPick = new Achievement("achievement.w1049344862.huaji.buildHuajiPick",
			"w1049344862.huaji.buildHuajiPick", 3, 6, ItemLoader.huajiPick, leftPick);
	public static Achievement PickJX = new Achievement("achievement.w1049344862.huaji.PickJX",
			"w1049344862.huaji.PickJX", 3, 8, getJxItemStack(ItemLoader.huajiPick), buildHuajiPick);
	public static Achievement huajiAltar = new Achievement("achievement.w1049344862.huaji.huajiAltar",
			"w1049344862.huaji.huajiAltar", 6, -1, BlockLoader.huajiAltar, huajiBlock);
	public static Achievement summonZombie = new Achievement("achievement.w1049344862.huaji.summonZombie",
			"w1049344862.huaji.summonZombie", 6, -3, BlockLoader.zombieSkull, huajiAltar);
	public static Achievement summonBoss = new Achievement("achievement.w1049344862.huaji.summonBoss",
			"w1049344862.huaji.summonBoss", 8, -3, BlockLoader.bossBlock, summonZombie);
	public static Achievement killBoss = new Achievement("achievement.w1049344862.huaji.killBoss",
			"w1049344862.huaji.killBoss", 10, -3, ItemLoader.bossStar, summonBoss);
	public static Achievement buildStick = new Achievement("achievement.w1049344862.huaji.buildStick",
			"w1049344862.huaji.buildStick", 0, 2, ItemLoader.huajiStick, getHuaji);
	public static Achievement dSword = new Achievement("achievement.w1049344862.huaji.dSword",
			"w1049344862.huaji.dSword", 1, 4, ItemLoader.dSword, buildStick);
	public static Achievement dPick = new Achievement("achievement.w1049344862.huaji.dPick", "w1049344862.huaji.dPick",
			-1, 4, ItemLoader.dPick, buildStick);
	public static Achievement buildBow = new Achievement("achievement.w1049344862.huaji.buildBow",
			"w1049344862.huaji.buildBow", -2, 2, ItemLoader.huajiBow, buildStick);
	public static Achievement bowJX = new Achievement("achievement.w1049344862.huaji.bowJX", "w1049344862.huaji.bowJX",
			-4, 2, getJxItemStack(ItemLoader.huajiBowJX), buildBow);
	// 成就页
	public static AchievementPage pageHuaji = new AchievementPage(Huaji.NAME, huajiApple, getHuaji, huajiWand, huajiInf,
			huajiBlock, upSword, downSword, buildHuajiSword, SwordJX, leftPick, rightPick, buildHuajiPick, PickJX,
			huajiAltar, summonZombie, summonBoss, killBoss, buildStick, dSword, dPick, buildBow, bowJX);

	public AchievementLoader() {
		// 成就页
		AchievementPage.registerAchievementPage(pageHuaji);
		// 成就
		huajiApple.initIndependentStat().registerStat();
		getHuaji.registerStat();
		huajiWand.registerStat();
		huajiInf.setSpecial().registerStat();
		huajiBlock.registerStat();
		upSword.registerStat();
		downSword.registerStat();
		buildHuajiSword.setSpecial().registerStat();
		SwordJX.setSpecial().registerStat();
		leftPick.registerStat();
		rightPick.registerStat();
		buildHuajiPick.setSpecial().registerStat();
		PickJX.setSpecial().registerStat();
		huajiAltar.registerStat();
		summonZombie.setSpecial().registerStat();
		summonBoss.registerStat();
		killBoss.setSpecial().registerStat();
		buildStick.registerStat();
		dSword.registerStat();
		dPick.registerStat();
		buildBow.registerStat();
		bowJX.setSpecial().registerStat();
	}

	public static ItemStack getJxItemStack(Item i) {
		ItemStack ii = new ItemStack(i);
		ii.stackTagCompound = new NBTTagCompound();
		ii.stackTagCompound.setBoolean("flagJX", true);
		ii.addEnchantment(Enchantment.unbreaking, 1);
		return ii;
	}

}
