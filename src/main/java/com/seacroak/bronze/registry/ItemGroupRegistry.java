package com.seacroak.bronze.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;


public class ItemGroupRegistry {
  public static ItemGroup createItemGroup() {
    return FabricItemGroup.builder()
        .icon(() -> new ItemStack(MainRegistry.BRONZE_INGOT))
        .displayName(Text.translatable("bronze.itemGroup"))
        .entries((displayContext, entries) -> {
          entries.add(new ItemStack(MainRegistry.BRONZE_INGOT));

        }).build();
  }

}
