package com.seacroak.bronze.material;

import com.seacroak.bronze.registry.MainRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

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
    return 3.0F;
  }

  @Override
  public TagKey<Block> getInverseTag() {
    return BlockTags.INCORRECT_FOR_IRON_TOOL;
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
