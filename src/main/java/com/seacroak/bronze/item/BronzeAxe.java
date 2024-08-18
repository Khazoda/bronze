package com.seacroak.bronze.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class BronzeAxe extends AxeItem {
  public BronzeAxe(ToolMaterial toolMaterial) {
    super(toolMaterial, 5.5f, -3.1f, getItemSettings());
  }

  private static Settings getItemSettings() {
    return (new Settings());
  }
}
