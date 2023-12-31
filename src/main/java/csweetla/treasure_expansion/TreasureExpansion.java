package csweetla.treasure_expansion;

import csweetla.treasure_expansion.item.EscapeRopeItem;
import csweetla.treasure_expansion.item.LabyrinthGeneratorItem;

import csweetla.treasure_expansion.item.LavaCharmItem;
import csweetla.treasure_expansion.item.SilverSwordItem;
import net.fabricmc.api.ModInitializer;

import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemArmor;
import net.minecraft.core.item.material.ArmorMaterial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.helper.*;

import java.util.Properties;

public class TreasureExpansion implements ModInitializer {
    public static final String MOD_ID = "treasure_expansion";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final ConfigHandler config;
	public static boolean mod_fruit_enabled;
	public static int minor_treasure_rarity;
	public static boolean minor_treasure_enabled;
	static {
		// Config
		Properties prop = new Properties();
		prop.setProperty("ids.piston_boots", "32200");
		prop.setProperty("ids.diving_helmet", "32201");
		prop.setProperty("ids.silver_sword", "32202");
		prop.setProperty("ids.escape_rope", "32203");
		prop.setProperty("ids.escape_rope_gold", "32204");
		prop.setProperty("ids.strange_device", "32205");
		prop.setProperty("ids.labyrinth_generator", "32206");
		prop.setProperty("ids.orange", "32207");
		prop.setProperty("ids.grapes", "32208");
		prop.setProperty("ids.bananas", "32209");
		prop.setProperty("ids.fruit_salad", "32210");
		prop.setProperty("ids.lava_charm", "32211");
		prop.setProperty("ids.spider_silk", "32212");
		prop.setProperty("loot.use_custom_tables","false");
		prop.setProperty("loot.mod_fruit_enabled","true");
		prop.setProperty("loot.minor_treasure_enabled","true");
		prop.setProperty("loot.minor_treasure_rarity","3");
		prop.setProperty("durability.escape_rope_gold","6");
		prop.setProperty("durability.escape_rope","1");
		prop.setProperty("durability.piston_boots","220");
		prop.setProperty("durability.diving_helmet","220");
		prop.setProperty("durability.lava_charm","120");
		prop.setProperty("durability.silver_sword","512");

		config = new ConfigHandler(MOD_ID, prop);
	}

	public static ArmorMaterial armorMaterialPistonBoots;
	public static ArmorMaterial armorMaterialDiving;
	public static Item armorItemPistonBoots;
	public static Item armorItemDivingHelmet;
	public static Item toolItemSilverSword;
	public static Item itemEscapeRope;
	public static Item itemEscapeRopeGold;
	public static Item itemStrangeDevice;
	public static Item itemLabyrinthGenerator;
	public static Item foodItemOrange;
	public static Item foodItemGrapes;
	public static Item foodItemBananas;
	public static Item foodItemFruitSalad;
	public static Item itemLavaCharm;
	public static Item itemSpiderSilk;

	public void initializeArmorMaterials() {
		armorMaterialPistonBoots = ArmorHelper.createArmorMaterial("piston_boots",config.getInt("durability.diving_helmet"),50.0F,50.0F,20.0F,120.0F);
		armorMaterialDiving = ArmorHelper.createArmorMaterial("diving",config.getInt("durability.diving_helmet"),20.0F,60.0F,20.0F,20.0F);
	}

	public void initializeItems() {
		int[] tex_coords;

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"piston_boots.png");
		armorItemPistonBoots = new ItemArmor(MOD_ID + ".piston_boots", config.getInt("ids.piston_boots"), armorMaterialPistonBoots, 3)
			.setIconCoord(tex_coords[0],tex_coords[1]);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"diving_helmet.png");
		armorItemDivingHelmet = new ItemArmor(MOD_ID + ".diving_helmet", config.getInt("ids.diving_helmet"), armorMaterialDiving, 0)
			.setIconCoord(tex_coords[0],tex_coords[1]);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"silver_sword.png");
		toolItemSilverSword = new SilverSwordItem(MOD_ID + ".silver_sword", config.getInt("ids.silver_sword"), ToolMaterial.iron, config.getInt("durability.silver_sword"))
			.setIconCoord(tex_coords[0],tex_coords[1]);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"escape_rope_gold.png");
		itemEscapeRopeGold = new EscapeRopeItem(MOD_ID + ".escape_rope_gold", config.getInt("ids.escape_rope_gold"), config.getInt("durability.escape_rope_gold"))
			.setIconCoord(tex_coords[0],tex_coords[1]);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"escape_rope.png");
		itemEscapeRope = new EscapeRopeItem(MOD_ID + ".escape_rope", config.getInt("ids.escape_rope"), config.getInt("durability.escape_rope"))
			.setIconCoord(tex_coords[0],tex_coords[1]);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"device.png");
		itemStrangeDevice = new Item(MOD_ID + ".strange_device", config.getInt("ids.strange_device"))
			.setIconCoord(tex_coords[0],tex_coords[1]).setMaxStackSize(1);

		itemLabyrinthGenerator = new LabyrinthGeneratorItem(MOD_ID + ".labyrinth_generator", config.getInt("ids.labyrinth_generator"))
			.setIconCoord(tex_coords[0],tex_coords[1]).setMaxStackSize(1);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"spider_silk.png");
		itemSpiderSilk = new Item(MOD_ID + ".spider_silk", config.getInt("ids.spider_silk"))
			.setIconCoord(tex_coords[0],tex_coords[1]).setMaxStackSize(1);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"orange.png");
		foodItemOrange = new ItemFood(MOD_ID + ".orange",config.getInt("ids.orange"),4,false)
			.setIconCoord(tex_coords[0],tex_coords[1]);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"grapes.png");
		foodItemGrapes = new ItemFood(MOD_ID + ".grapes",config.getInt("ids.grapes"),4,false)
			.setIconCoord(tex_coords[0],tex_coords[1]);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"bananas.png");
		foodItemBananas = new ItemFood(MOD_ID + ".bananas",config.getInt("ids.bananas"),4,false)
			.setIconCoord(tex_coords[0],tex_coords[1]);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"fruit_salad.png");
		foodItemFruitSalad = new ItemFood(MOD_ID + ".fruit_salad",config.getInt("ids.fruit_salad"),20,false)
			.setIconCoord(tex_coords[0],tex_coords[1]);

		tex_coords = TextureHelper.getOrCreateItemTexture(MOD_ID,"lava_charm.png");
		itemLavaCharm = new LavaCharmItem(MOD_ID + ".lava_charm",config.getInt("ids.lava_charm"),config.getInt("durability.lava_charm"))
			.setIconCoord(tex_coords[0],tex_coords[1]);
	}

	private void initializeRecipes() {
		RecipeHelper.Crafting.createShapelessRecipe(foodItemFruitSalad,1,
			new Object[]{
				Item.bowl,
				Item.foodApple,
				Item.cherry,
				foodItemBananas,
				foodItemGrapes,
				foodItemOrange
			}
		);
	}

	@Override
    public void onInitialize() {
		mod_fruit_enabled = config.getBoolean("loot.mod_fruit_enabled");
		minor_treasure_enabled = config.getBoolean("loot.minor_treasure_enabled");
		minor_treasure_rarity = config.getInt("loot.minor_treasure_rarity");
		LootTables.initialize();
		LOGGER.info(MOD_ID + " initialized.");

		initializeArmorMaterials();
		initializeItems();
		initializeRecipes();

	}
}
