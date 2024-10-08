package com.seacroak.bronze.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;


public class ItemGroupRegistry {
  public static ItemGroup createItemGroup() {
    return FabricItemGroup.builder()
        .icon(() -> new ItemStack(MainRegistry.BRONZE_INGOT))
        .displayName(Text.translatable("bronze.itemGroup"))
        .entries((displayContext, entries) -> {

          entries.add(new ItemStack(MainRegistry.BRONZE_SWORD));
          entries.add(new ItemStack(MainRegistry.BRONZE_AXE));
          entries.add(new ItemStack(MainRegistry.BRONZE_PICKAXE));
          entries.add(new ItemStack(MainRegistry.BRONZE_SHOVEL));
          entries.add(new ItemStack(MainRegistry.BRONZE_HOE));
          entries.add(new ItemStack(MainRegistry.SICKLE));

          entries.add(new ItemStack(MainRegistry.BRONZE_HELMET));
          entries.add(new ItemStack(MainRegistry.BRONZE_CHESTPLATE));
          entries.add(new ItemStack(MainRegistry.BRONZE_LEGGINGS));
          entries.add(new ItemStack(MainRegistry.BRONZE_BOOTS));

          entries.add(new ItemStack(MainRegistry.TIN_BLOCK));
          entries.add(new ItemStack(MainRegistry.BRONZE_BLOCK));
          entries.add(new ItemStack(MainRegistry.TIN_RAW_BLOCK));
          entries.add(new ItemStack(MainRegistry.BRONZE_BLEND_BLOCK));
          entries.add(new ItemStack(MainRegistry.TIN_ORE));
          entries.add(new ItemStack(MainRegistry.DEEPSLATE_TIN_ORE));
          entries.add(new ItemStack(MainRegistry.TIN_RAW));
          entries.add(new ItemStack(MainRegistry.BRONZE_BLEND));
          entries.add(new ItemStack(MainRegistry.TIN_INGOT));
          entries.add(new ItemStack(MainRegistry.BRONZE_INGOT));
          entries.add(new ItemStack(MainRegistry.BRONZE_NUGGET));

          entries.add(new ItemStack(MainRegistry.BRONZE_HORSE_ARMOR));
          entries.add(new ItemStack(MainRegistry.BRONZE_DOOR));
          entries.add(new ItemStack(MainRegistry.BRONZE_TRAPDOOR));

          entries.add(new ItemStack(MainRegistry.TIN_FRAMED_GLASS));
        }).build();
  }

  /* Method needs to be manually updated with the vanilla itemGroups each entry should reside in */
  public static void slideItemsIntoVanillaItemGroups() {

    /* Tools */
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
      content.addAfter(Items.IRON_HOE,
          MainRegistry.BRONZE_SHOVEL,
          MainRegistry.BRONZE_PICKAXE,
          MainRegistry.BRONZE_AXE,
          MainRegistry.BRONZE_HOE);

      content.addAfter(Items.BRUSH,
          MainRegistry.SICKLE);
    });

    /* Combat */
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
      content.addAfter(Items.IRON_SWORD,
          MainRegistry.BRONZE_SWORD);

      content.addAfter(Items.IRON_AXE,
          MainRegistry.BRONZE_AXE);

      content.addAfter(Items.IRON_BOOTS,
          MainRegistry.BRONZE_HELMET,
          MainRegistry.BRONZE_CHESTPLATE,
          MainRegistry.BRONZE_LEGGINGS,
          MainRegistry.BRONZE_BOOTS);

      content.addAfter(Items.IRON_HORSE_ARMOR,
          MainRegistry.BRONZE_HORSE_ARMOR);
    });

    /* Ingredients */
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
      content.addAfter(Items.RAW_IRON,
          MainRegistry.BRONZE_BLEND,
          MainRegistry.TIN_RAW);

      content.addAfter(Items.IRON_NUGGET,
          MainRegistry.BRONZE_NUGGET);

      content.addAfter(Items.IRON_INGOT,
          MainRegistry.BRONZE_INGOT,
          MainRegistry.TIN_INGOT);
    });

    /* Natural Blocks */
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(content -> {
      content.addAfter(Items.DEEPSLATE_IRON_ORE,
          MainRegistry.TIN_ORE,
          MainRegistry.DEEPSLATE_TIN_ORE);

      content.addAfter(Items.RAW_IRON_BLOCK,
          MainRegistry.BRONZE_BLEND_BLOCK,
          MainRegistry.TIN_RAW_BLOCK);
    });

    /* Building Blocks */
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
      content.addAfter(Items.CHAIN,
          MainRegistry.BRONZE_BLOCK,
          MainRegistry.TIN_BLOCK);
    });

    /* Redstone Blocks */
    ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
      content.addAfter(Items.IRON_DOOR,
          MainRegistry.BRONZE_DOOR);

      content.addAfter(Items.IRON_TRAPDOOR,
          MainRegistry.BRONZE_TRAPDOOR);
    });


  }
}
