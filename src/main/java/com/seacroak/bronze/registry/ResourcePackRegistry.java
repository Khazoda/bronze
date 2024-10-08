package com.seacroak.bronze.registry;

import com.seacroak.bronze.Constants;
import com.seacroak.bronze.util.GenericUtils;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;

public class ResourcePackRegistry {
  /* Register resource pack if external mod is present */
  public static boolean registerIfPresent(String external_mod_id, String resource_pack_name) {
    if (FabricLoader.getInstance().isModLoaded(external_mod_id)) {
      FabricLoader.getInstance().getModContainer(Constants.BRONZE_ID).ifPresent(modContainer -> {
        ResourceManagerHelper.registerBuiltinResourcePack(GenericUtils.ID(resource_pack_name), modContainer, Text.translatable("resource_pack.bronze." + resource_pack_name + ".name"), ResourcePackActivationType.DEFAULT_ENABLED);
      });
      return true;
    }
    return false;
  }

  /* Register resource pack */
  public static void register(String resource_pack_name) {
    FabricLoader.getInstance().getModContainer(Constants.BRONZE_ID).ifPresent(modContainer -> {
      ResourceManagerHelper.registerBuiltinResourcePack(GenericUtils.ID(resource_pack_name), modContainer, Text.translatable("resource_pack.bronze." + resource_pack_name + ".name"), ResourcePackActivationType.DEFAULT_ENABLED);
    });
  }
}

