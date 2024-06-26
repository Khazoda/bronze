package com.seacroak.bronze.util;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import static com.seacroak.bronze.Constants.BRONZE_ID;

public class GenericUtils {
  @NotNull
  public static Identifier ID(@NotNull String path) {
    return Identifier.of(BRONZE_ID, path);
  }
}
