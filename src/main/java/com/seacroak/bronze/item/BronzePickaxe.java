package com.seacroak.bronze.item;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class BronzePickaxe extends PickaxeItem {
  public BronzePickaxe(ToolMaterial toolMaterial) {
    super(toolMaterial, 1, -2.8f, getItemSettings());
  }

  private static Settings getItemSettings() {
    return (new Settings());
  }

}
