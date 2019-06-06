package w1049344862.huaji.item;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import w1049344862.huaji.creativetab.CreativeTabsLoader;

public class ItemLoader {

	///// Money
	public static Item rmb1 = new Item().setUnlocalizedName("rmb1").setTextureName("huaji:rmb1")
			.setCreativeTab(CreativeTabsLoader.tabHuaji);
	public static Item rmb5 = new Item().setUnlocalizedName("rmb5").setTextureName("huaji:rmb5")
			.setCreativeTab(CreativeTabsLoader.tabHuaji);
	public static Item rmb10 = new Item().setUnlocalizedName("rmb10").setTextureName("huaji:rmb10")
			.setCreativeTab(CreativeTabsLoader.tabHuaji);
	public static Item rmb20 = new Item().setUnlocalizedName("rmb20").setTextureName("huaji:rmb20")
			.setCreativeTab(CreativeTabsLoader.tabHuaji);
	public static Item rmb50 = new Item().setUnlocalizedName("rmb50").setTextureName("huaji:rmb50")
			.setCreativeTab(CreativeTabsLoader.tabHuaji);
	public static Item rmb100 = new Item().setUnlocalizedName("rmb100").setTextureName("huaji:rmb100")
			.setCreativeTab(CreativeTabsLoader.tabHuaji);
	public static Item gg1 = new Item().setUnlocalizedName("gg1").setTextureName("huaji:gg1")
			.setCreativeTab(CreativeTabsLoader.tabHuaji).setFull3D();
	///// Money

	//
	public static Item bossStar = new Item().setUnlocalizedName("bossStar").setTextureName("huaji:boss_star")
			.setCreativeTab(CreativeTabsLoader.tabHuaji);
	//
	public static Item huajiCoin = new ItemHuajiCoin();
	public static Item huajiSwordUp = new ItemHuajiToolMaker("sword_up", "SwordUp");
	public static Item huajiSwordDown = new ItemHuajiToolMaker("sword_down", "SwordDown");
	public static Item huajiPickLeft = new ItemHuajiToolMaker("pick_left", "PickLeft");
	public static Item huajiPickRight = new ItemHuajiToolMaker("pick_right", "PickRight");
	public static Item huajiStick = new ItemHuajiToolMaker("stick", "Stick");
	public static ItemSword huajiSword = new ItemHuajiSword();
	public static ItemPickaxe huajiPick = new ItemHuajiPick();
	public static ItemSword dSword = new ItemDSword();
	public static ItemPickaxe dPick = new ItemDPick();
	public static ItemTool toolHuajiWand = new ItemToolHuajiWand();
	public static ItemFood huajiApple = new ItemHuajiApple();
	public static ItemBow huajiBow = new ItemHuajiBow();
	public static ItemBow huajiBowJX = new ItemHuajiBowJX();
	public static Item huajiArrow = new Item().setUnlocalizedName("huajiArrow").setTextureName("huaji:huaji_arrow")
			.setCreativeTab(CreativeTabsLoader.tabHuaji);;

	public ItemLoader(FMLPreInitializationEvent event) {
		///// Money
		register(rmb1, "rmb1");
		register(rmb5, "rmb5");
		register(rmb10, "rmb10");
		register(rmb20, "rmb20");
		register(rmb50, "rmb50");
		register(rmb100, "rmb100");
		register(gg1, "gg1");
		///// Money

		/////
		register(bossStar, "boss_star");
		/////
		register(huajiCoin, "huaji_coin");
		register(huajiSwordUp, "huaji_sword_up");
		register(huajiSwordDown, "huaji_sword_down");
		register(huajiSword, "huaji_sword");
		register(toolHuajiWand, "huaji_wand");
		register(huajiPickLeft, "huaji_pick_left");
		register(huajiPickRight, "huaji_pick_right");
		register(huajiPick, "huaji_pick");
		register(huajiApple, "huaji_apple");
		register(huajiStick, "huaji_stick");
		register(dSword, "huaji_dsword");
		register(dPick, "huaji_dpick");
		register(huajiBow, "huaji_bow");
		register(huajiBowJX, "huaji_bow_JX");
		register(huajiArrow, "huaji_arrow");
	}

	private static void register(Item item, String name) {
		GameRegistry.registerItem(item, name);
	}

}
