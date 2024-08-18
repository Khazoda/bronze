package com.seacroak.bronze.registry;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetDamageLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import java.util.*;

import static net.minecraft.loot.LootTables.*;

public class LootTableModification {

  public static final List<String> poolNames = Arrays.asList(
      "simple_dungeon_pool",
      "abandoned_mineshaft_pool",
      "ancient_city_pool",
      "buried_treasure_pool",
      "desert_pyramid_pool",
      "end_city_treasure_pool",
      "igloo_chest_pool",
      "jungle_temple_pool",
      "nether_bridge_pool",
      "pillager_outpost_pool",
      "nugget common_pool",
      "spawn_bonus_chest_pool",
      "stronghold_corridor_pool",
      "stronghold_crossing_pool",
      "underwater_ruin_big_pool",
      "woodland_mansion_pool",

      "village.village_armorer_pool",
      "village.village_toolsmith_pool",
      "village.village_weaponsmith_pool",

      "archaeology.desert_pyramid_pool",
      "archaeology.desert_well_pool"
  );

  /*
  * simple_dungeon - horse armor uncommon, ingot common
    abandoned_mineshaft - ingot common, pickaxe rare
    ancient_city - enchanted leggings uncommon
    buried_treasure - ingot common, sword uncommon
    desert_pyramid - horse armor uncommon
    end_city_treasure - enchanted armor uncommon, enchanted tools uncommon, enchanted sword uncommon
    igloo_chest - common nuggets
    jungle_temple - ingot common, horse armor uncommon
    nether_bridge - horse armor uncommon
    pillager_outpost - ingot uncommon
    shipwreck_treasure - ingot common, nugget common
    spawn_bonus_chest - nugget common
    stronghold_corridor - armor, tools, weapon common
    stronghold_crossing - ingot common, nugget common
    underwater_ruin_big - nugget common
    woodland_mansion - armor uncommon, ingot uncommon, hoe rare

    village/village_armorer - ingot common, helmet rare
    village/village_toolsmith - ingot rare, tools common
    village/village_weaponsmith - armor tools weapons common, horse armor uncommon

    archaeology/desert_pyramid - ingot uncommon
    archaeology/desert_well - nugget uncommon
  *
  */

  private static final List<LootPoolEntry> simple_dungeon_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_HORSE_ARMOR).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(4).build()
  );

  private static final List<LootPoolEntry> abandoned_mineshaft_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(5).build(),
      ItemEntry.builder(MainRegistry.BRONZE_PICKAXE).weight(1).build()
  );

  private static final List<LootPoolEntry> ancient_city_pool = Collections.singletonList(
      ItemEntry.builder(MainRegistry.BRONZE_LEGGINGS).weight(1).build()
  );

  private static final List<LootPoolEntry> buried_treasure_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(4).build(),
      ItemEntry.builder(MainRegistry.BRONZE_SWORD).weight(1).build()

  );

  private static final List<LootPoolEntry> desert_pyramid_pool = Collections.singletonList(
      ItemEntry.builder(MainRegistry.BRONZE_HORSE_ARMOR).weight(1).build()
  );

  private static final List<LootPoolEntry> end_city_treasure_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_HELMET).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_CHESTPLATE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_LEGGINGS).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_BOOTS).weight(1).build(),

      ItemEntry.builder(MainRegistry.BRONZE_SWORD).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_PICKAXE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_AXE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_SHOVEL).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_HOE).weight(1).build()
  );

  private static final List<LootPoolEntry> igloo_chest_pool = Collections.singletonList(
      ItemEntry.builder(MainRegistry.BRONZE_NUGGET).weight(2).build()
  );

  private static final List<LootPoolEntry> jungle_temple_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(4).build(),
      ItemEntry.builder(MainRegistry.BRONZE_HORSE_ARMOR).weight(1).build()
  );

  private static final List<LootPoolEntry> nether_bridge_pool = Collections.singletonList(
      ItemEntry.builder(MainRegistry.BRONZE_HORSE_ARMOR).weight(1).build()
  );

  private static final List<LootPoolEntry> pillager_outpost_pool = Collections.singletonList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(1).build()
  );

  private static final List<LootPoolEntry> shipwreck_treasure_chest_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(4).build(),
      ItemEntry.builder(MainRegistry.BRONZE_NUGGET).weight(3).build()
  );

  private static final List<LootPoolEntry> spawn_bonus_chest_pool = Collections.singletonList(
      ItemEntry.builder(MainRegistry.BRONZE_NUGGET).weight(2).build()
  );

  private static final List<LootPoolEntry> stronghold_corridor_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_HELMET).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_CHESTPLATE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_LEGGINGS).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_BOOTS).weight(1).build(),

      ItemEntry.builder(MainRegistry.BRONZE_SWORD).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_PICKAXE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_AXE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_SHOVEL).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_HOE).weight(1).build()
  );

  private static final List<LootPoolEntry> stronghold_crossing_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(2).build(),
      ItemEntry.builder(MainRegistry.BRONZE_NUGGET).weight(2).build()
  );

  private static final List<LootPoolEntry> underwater_ruin_big_pool = Collections.singletonList(
      ItemEntry.builder(MainRegistry.BRONZE_NUGGET).weight(2).build()
  );

  private static final List<LootPoolEntry> woodland_mansion_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_HELMET).weight(2).build(),
      ItemEntry.builder(MainRegistry.BRONZE_CHESTPLATE).weight(2).build(),
      ItemEntry.builder(MainRegistry.BRONZE_LEGGINGS).weight(2).build(),
      ItemEntry.builder(MainRegistry.BRONZE_BOOTS).weight(2).build(),
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(3).build(),
      ItemEntry.builder(MainRegistry.BRONZE_HOE).weight(1).build()

  );

  private static final List<LootPoolEntry> village_village_armorer_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(4).build(),
      ItemEntry.builder(MainRegistry.BRONZE_HELMET).weight(1).build()

  );

  private static final List<LootPoolEntry> village_village_toolsmith_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_PICKAXE).weight(3).build(),
      ItemEntry.builder(MainRegistry.BRONZE_AXE).weight(3).build(),
      ItemEntry.builder(MainRegistry.BRONZE_SHOVEL).weight(3).build(),
      ItemEntry.builder(MainRegistry.BRONZE_HOE).weight(3).build()
  );

  private static final List<LootPoolEntry> village_village_weaponsmith_pool = Arrays.asList(
      ItemEntry.builder(MainRegistry.BRONZE_HELMET).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_CHESTPLATE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_LEGGINGS).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_BOOTS).weight(1).build(),

      ItemEntry.builder(MainRegistry.BRONZE_SWORD).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_PICKAXE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_AXE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_SHOVEL).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_HOE).weight(1).build(),
      ItemEntry.builder(MainRegistry.BRONZE_HORSE_ARMOR).weight(1).build()
  );

  private static final List<LootPoolEntry> archaeology_desert_pyramid_pool = Collections.singletonList(
      ItemEntry.builder(MainRegistry.BRONZE_INGOT).weight(2).build()
  );

  private static final List<LootPoolEntry> archaeology_desert_well_pool = Collections.singletonList(
      ItemEntry.builder(MainRegistry.BRONZE_NUGGET).weight(2).build()
  );

  public static void addItems(List<LootPoolEntry> loot_pool, LootTable.Builder tableBuilder, boolean applyDamage) {
    /* Function adds 0-2 items that are undamaged with no enchantment */
    LootPool.Builder poolBuilder = LootPool.builder()
        .rolls(UniformLootNumberProvider.create(0f, 2f))
        .with(loot_pool);
    if (applyDamage) poolBuilder.apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.7f, 0.95f)))
        .bonusRolls(ConstantLootNumberProvider.create(0.5f));
    tableBuilder.pool(poolBuilder);
  }

  public static void addEnchantedItems(List<LootPoolEntry> loot_pool, LootTable.Builder tableBuilder, boolean applyDamage, float enchantMin, float enchantMax) {
    /* Function adds 0-2 items that are either enchanted and damaged, or full health with no enchantment */
    Collection<LootPool> lootPools = new ArrayList<>();
    LootPool.Builder enchantedPoolBuilder = LootPool.builder()
        .rolls(UniformLootNumberProvider.create(0f, 2f))
        .with(loot_pool);
/*               TODO: Fix this .apply() method when Fabric saves me from wrapperlookup stuff
                .apply(EnchantWithLevelsLootFunction.builder(
                        UniformLootNumberProvider.create(enchantMin, enchantMax)));
                        */
    if (applyDamage)
      enchantedPoolBuilder.apply(SetDamageLootFunction.builder(UniformLootNumberProvider.create(0.7f, 0.95f)))
          .bonusRolls(ConstantLootNumberProvider.create(0.5f));

    lootPools.add(enchantedPoolBuilder.build());
    tableBuilder.pools(lootPools);
  }

  public static void init() {
    LootTableEvents.MODIFY.register((resourceManager, lootManager, key, tableBuilder, source) -> {

      if (source.isBuiltin() && SIMPLE_DUNGEON_CHEST.equals(key)) {
        addItems(simple_dungeon_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && ABANDONED_MINESHAFT_CHEST.equals(key)) {
        addItems(abandoned_mineshaft_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && ANCIENT_CITY_CHEST.equals(key)) {
        addEnchantedItems(ancient_city_pool, tableBuilder, false, 15f, 30f);
      }

      if (source.isBuiltin() && BURIED_TREASURE_CHEST.equals(key)) {
        addItems(buried_treasure_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && DESERT_PYRAMID_CHEST.equals(key)) {
        addItems(desert_pyramid_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && END_CITY_TREASURE_CHEST.equals(key)) {
        addEnchantedItems(end_city_treasure_pool, tableBuilder, false, 22f, 30f);
      }

      if (source.isBuiltin() && IGLOO_CHEST_CHEST.equals(key)) {
        addItems(igloo_chest_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && JUNGLE_TEMPLE_CHEST.equals(key)) {
        addItems(jungle_temple_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && NETHER_BRIDGE_CHEST.equals(key)) {
        addItems(nether_bridge_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && PILLAGER_OUTPOST_CHEST.equals(key)) {
        addItems(pillager_outpost_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && SHIPWRECK_TREASURE_CHEST.equals(key)) {
        addItems(shipwreck_treasure_chest_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && SPAWN_BONUS_CHEST.equals(key)) {
        addItems(spawn_bonus_chest_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && STRONGHOLD_CORRIDOR_CHEST.equals(key)) {
        addItems(stronghold_corridor_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && STRONGHOLD_CROSSING_CHEST.equals(key)) {
        addItems(stronghold_crossing_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && UNDERWATER_RUIN_BIG_CHEST.equals(key)) {
        addItems(underwater_ruin_big_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && WOODLAND_MANSION_CHEST.equals(key)) {
        addItems(woodland_mansion_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && VILLAGE_ARMORER_CHEST.equals(key)) {
        addItems(village_village_armorer_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && VILLAGE_TOOLSMITH_CHEST.equals(key)) {
        addItems(village_village_toolsmith_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && VILLAGE_WEAPONSMITH_CHEST.equals(key)) {
        addItems(village_village_weaponsmith_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && DESERT_PYRAMID_ARCHAEOLOGY.equals(key)) {
        addItems(archaeology_desert_pyramid_pool, tableBuilder, false);
      }

      if (source.isBuiltin() && DESERT_WELL_ARCHAEOLOGY.equals(key)) {
        addItems(archaeology_desert_well_pool, tableBuilder, false);
      }
    });
  }
}
