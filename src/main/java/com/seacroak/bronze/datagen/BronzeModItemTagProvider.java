package com.seacroak.bronze.datagen;

import com.seacroak.bronze.registry.MainRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class BronzeModItemTagProvider extends FabricTagProvider.ItemTagProvider {
  public BronzeModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
    super(output, completableFuture);
  }

  @Override
  protected void configure(RegistryWrapper.WrapperLookup arg) {
    getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
        .add(MainRegistry.BRONZE_HELMET, MainRegistry.BRONZE_CHESTPLATE, MainRegistry.BRONZE_LEGGINGS, MainRegistry.BRONZE_BOOTS);
  }
}