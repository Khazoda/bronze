package com.seacroak.bronze.item;

import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;

public class BronzeShovel extends ShovelItem {
  public BronzeShovel(ToolMaterial toolMaterial) {
    super(toolMaterial, 1, -3.0f, getItemSettings());
  }

  private static Settings getItemSettings() {
    return (new Settings());
  }
}
