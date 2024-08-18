package com.seacroak.bronze.material;

import com.seacroak.bronze.registry.MainRegistry;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class BronzeArmorMaterial implements ArmorMaterial {

  private static final int[] durabilityMap = new int[]{234, 270, 288, 198};
  private static final int[] protectionMap = new int[]{2, 5, 7, 2};

  @Override
  public int getDurability(ArmorItem.Type type) {
    return durabilityMap[type.getEquipmentSlot().getEntitySlotId()];
  }

  @Override
  public int getProtection(ArmorItem.Type type) {
    return protectionMap[type.getEquipmentSlot().getEntitySlotId()];
  }

  @Override
  public int getEnchantability() {
    return 9;
  }

  @Override
  public SoundEvent getEquipSound() {
    return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
  }

  @Override
  public Ingredient getRepairIngredient() {
    return Ingredient.ofItems(MainRegistry.BRONZE_INGOT);
  }

  @Override
  public String getName() {
    return "bronze";
  }

  @Override
  public float getToughness() {
    return 1.0f;
  }

  @Override
  public float getKnockbackResistance() {
    return 0.0f;
  }
}
