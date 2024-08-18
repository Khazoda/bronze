package com.seacroak.bronze;

import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;

import static com.seacroak.bronze.util.GenericUtils.ID;

public class BronzeModTags {

  public static class Block {
    public static final TagKey<net.minecraft.block.Block> TIN_ORES = TagKey.of(RegistryKeys.BLOCK, ID("tin_ores"));
  }

  public static class Items {

  }

}
