package com.seacroak.bronze;

import com.seacroak.bronze.registry.ItemGroupRegistry;
import com.seacroak.bronze.registry.LootTableModification;
import com.seacroak.bronze.registry.MainRegistry;
import com.seacroak.bronze.util.GenericUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.seacroak.bronze.Constants.BRONZE_LOGGER;
import static com.seacroak.bronze.Constants.BRONZE_NAMESPACE;

public class BronzeMod implements ModInitializer {
  public static final ItemGroup BRONZE_ITEMGROUP = ItemGroupRegistry.createItemGroup();

  @Override
  public void onInitialize() {
    Registry.register(Registries.ITEM_GROUP, GenericUtils.ID(BRONZE_NAMESPACE), BRONZE_ITEMGROUP);

    MainRegistry.init();
    LootTableModification.init();
    ItemGroupRegistry.slideItemsIntoVanillaItemGroups();
    BRONZE_LOGGER.info("[Bronze] Finished Loading!");
  }
}