package com.seacroak.bronze.block;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;

public class TinOre extends Block {
  public TinOre() {
    super(Settings.create().strength(2.5f).sounds(BlockSoundGroup.METAL).requiresTool());
  }
}
