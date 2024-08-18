package com.seacroak.bronze.datagen.advancements;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;

import java.util.function.Consumer;

public class BronzeModAdvancementsProvider extends FabricAdvancementProvider {
  public BronzeModAdvancementsProvider(FabricDataOutput dataGenerator) {
    super(dataGenerator);
  }

  @Override
  public void generateAdvancement(Consumer<Advancement> consumer) {
    new BronzeAdvancements().accept(consumer);
  }
}
