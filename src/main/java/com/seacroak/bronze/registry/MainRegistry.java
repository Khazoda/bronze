package com.seacroak.bronze.registry;

import com.seacroak.bronze.block.*;
import com.seacroak.bronze.item.*;
import com.seacroak.bronze.material.BronzeArmorMaterial;
import com.seacroak.bronze.material.BronzeToolMaterial;
import com.seacroak.bronze.util.RegistryHelper;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import static com.seacroak.bronze.Constants.BRONZE_LOGGER;
import static com.seacroak.bronze.util.GenericUtils.ID;

public class MainRegistry {
  static final Item.Settings defaultItemSettings = new Item.Settings().maxCount(64);

  /* Items */
  public static final Item TIN_RAW = Registry.register(Registries.ITEM, ID("raw_tin"), new TinRaw(defaultItemSettings));
  public static final Item TIN_INGOT = Registry.register(Registries.ITEM, ID("tin_ingot"), new TinIngot(defaultItemSettings));
  public static final Item BRONZE_BLEND = Registry.register(Registries.ITEM, ID("bronze_blend"), new BronzeBlend(defaultItemSettings));
  public static final Item BRONZE_NUGGET = Registry.register(Registries.ITEM, ID("bronze_nugget"), new BronzeNugget(defaultItemSettings));
  public static final Item BRONZE_INGOT = Registry.register(Registries.ITEM, ID("bronze_ingot"), new BronzeIngot(defaultItemSettings));
  public static final Item BRONZE_HORSE_ARMOR = Registry.register(Registries.ITEM,ID("bronze_horse_armor"), new AnimalArmorItem(BronzeArmorMaterial.INSTANCE, AnimalArmorItem.Type.EQUESTRIAN, false, (new Item.Settings()).maxCount(1)));

  //  Weapons
  public static final ToolItem BRONZE_SWORD = Registry.register(Registries.ITEM, ID("bronze_sword"), new BronzeSword(BronzeToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(SwordItem.createAttributeModifiers(BronzeToolMaterial.INSTANCE, 3, -2.4F))));
  public static final ToolItem BRONZE_AXE = Registry.register(Registries.ITEM, ID("bronze_axe"), new BronzeAxe(BronzeToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(AxeItem.createAttributeModifiers(ToolMaterials.IRON, 6.0F, -3.1F))));
  public static final ToolItem BRONZE_PICKAXE = Registry.register(Registries.ITEM, ID("bronze_pickaxe"), new BronzePickaxe(BronzeToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 1.0F, -2.8F))));
  public static final ToolItem BRONZE_SHOVEL = Registry.register(Registries.ITEM, ID("bronze_shovel"), new BronzeShovel(BronzeToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(ShovelItem.createAttributeModifiers(ToolMaterials.IRON, 1.5F, -3.0F))));
  public static final ToolItem BRONZE_HOE = Registry.register(Registries.ITEM, ID("bronze_hoe"), new BronzeHoe(BronzeToolMaterial.INSTANCE, (new Item.Settings()).attributeModifiers(HoeItem.createAttributeModifiers(ToolMaterials.IRON, -2.0F, -1.0F))));

  // Armor
  public static final Item BRONZE_HELMET = Registry.register(Registries.ITEM, ID("bronze_helmet"), new ArmorItem(BronzeArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
  public static final Item BRONZE_CHESTPLATE = Registry.register(Registries.ITEM, ID("bronze_chestplate"), new ArmorItem(BronzeArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
  public static final Item BRONZE_LEGGINGS = Registry.register(Registries.ITEM, ID("bronze_leggings"), new ArmorItem(BronzeArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
  public static final Item BRONZE_BOOTS = Registry.register(Registries.ITEM, ID("bronze_boots"), new ArmorItem(BronzeArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

  /* Blocks */
  public static final TinOre TIN_ORE = registerBlock("tin_ore_block", new TinOre(), defaultItemSettings);
  public static final DeepslateTinOre DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore_block", new DeepslateTinOre(), defaultItemSettings);
  public static final TinRawBlock TIN_RAW_BLOCK = registerBlock("raw_tin_block", new TinRawBlock(), defaultItemSettings);
  public static final BronzeBlendBlock BRONZE_BLEND_BLOCK = registerBlock("bronze_blend_block", new BronzeBlendBlock(), defaultItemSettings);
  public static final TinBlock TIN_BLOCK = registerBlock("tin_block", new TinBlock(), defaultItemSettings);
  public static final BronzeBlock BRONZE_BLOCK = registerBlock("bronze_block", new BronzeBlock(), defaultItemSettings);



  /* WorldGen */
  public static final RegistryKey<PlacedFeature> TIN_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, ID("ore_tin"));


  public static void init() {
    BRONZE_LOGGER.info("Initializing Main Registry");
    /* Add Tin Ore to WorldGen */
    BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, TIN_ORE_PLACED_KEY);

  }

  /* Registration Functions */
  private static <B extends Block> B registerBlock(String name, B block, Item.Settings itemSettings) {
    return RegistryHelper.registerBlock(name, block, itemSettings);
  }

  private static <B extends Block> B registerBlockOnly(String name, B block) {
    return RegistryHelper.registerBlockOnly(name, block);
  }

  private static <I extends BlockItem> BlockItem registerBlockItem(String name, I blockItem) {
    return RegistryHelper.registerBlockItem(name, blockItem);
  }

  private static Item registerItem(String name) {
    return RegistryHelper.registerItem(name, new Item(defaultItemSettings));
  }
}
