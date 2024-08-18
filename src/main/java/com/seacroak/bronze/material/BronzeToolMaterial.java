package com.seacroak.bronze.material;

import com.seacroak.bronze.registry.MainRegistry;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BronzeToolMaterial implements ToolMaterial {

  public static final BronzeToolMaterial INSTANCE = new BronzeToolMaterial();

  @Override
  public int getDurability() {
    return 350;
  }

  @Override
  public float getMiningSpeedMultiplier() {
    return 7.0F;
  }

  @Override
  public float getAttackDamage() {
    return 2.5F;
  }

  @Override
  public int getMiningLevel() {
    return MiningLevels.IRON;
  }

  @Override
  public int getEnchantability() {
    return 13;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return Ingredient.ofItems(MainRegistry.BRONZE_INGOT);
  }
}
