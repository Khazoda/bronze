package com.seacroak.bronze.item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class BronzeHoe extends HoeItem {
  public BronzeHoe(ToolMaterial toolMaterial) {
    super(toolMaterial, -2, -1, getItemSettings());
  }

  private static Settings getItemSettings() {
    return (new Settings());
  }
}
