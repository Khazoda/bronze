package com.seacroak.bronze.item;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class BronzeSword extends SwordItem {
  public BronzeSword(ToolMaterial toolMaterial) {
    super(toolMaterial, 3, -2.4f, getItemSettings());
  }

  private static Settings getItemSettings() {
    return (new Settings());
  }


}
